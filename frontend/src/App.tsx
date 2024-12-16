import { ModeToggle } from "./components/mode-toggle";
import { ThemeProvider } from "./contexts/theme";

export function App() {
  return (
    <ThemeProvider defaultTheme="dark">
      <div className="h-1/2 bg-slate-800">
        <ModeToggle />
      </div>
    </ThemeProvider>
  )
}
