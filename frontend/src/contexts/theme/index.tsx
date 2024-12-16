import { createContext, ReactNode, useEffect, useState } from "react"

export type Theme = 'dark' | 'light' | 'system'

export type ThemeProviderProps = {
  children: ReactNode
  defaultTheme?: Theme
}

export type ThemeProviderState = {
  theme: Theme
  setTheme: (theme: Theme) => void
}

const initialState: ThemeProviderState = {
  theme: 'system',
  setTheme: () => null
}

// eslint-disable-next-line react-refresh/only-export-components
export const ThemeProviderContext = createContext<ThemeProviderState>(initialState)

export const ThemeProvider = ({ children, defaultTheme = 'system', ...props }: ThemeProviderProps) => {
  const [theme, setTheme] = useState<Theme>(defaultTheme)

  useEffect(() => {
    const root = window.document.documentElement
    root.classList.remove('light', 'dark')

    if (theme === 'system') {
      const systemTheme = window.matchMedia("(prefers-color-scheme: dark)").matches ? 'dark' : 'light'

      root.classList.add(systemTheme)
      return
    }

    root.classList.add(theme)
  }, [theme])

  const handlerSetTheme = (theme: Theme) => setTheme(theme)

  return (
    <ThemeProviderContext.Provider {...props} value={{
      theme,
      setTheme: handlerSetTheme
    }}>
      {children}
    </ThemeProviderContext.Provider>
  )
}