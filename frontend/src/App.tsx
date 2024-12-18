import { BrowserRouter, Route, Routes } from "react-router";
import { ThemeProvider } from "./contexts/theme";
import { Home } from '@/pages/Home';
import { AuthProvider } from "@/contexts/Auth";
import { PrivateRoute } from "@/components/privateRouter";
import { Explore } from "@/pages/Explore";
import { Authenticate } from "@/pages/Authenticate";
import { Login } from "@/pages/Authenticate/login";
import { Register } from "@/pages/Authenticate/register";
import { Toaster } from "sonner";
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'

const queryClient = new QueryClient()
export function App() {

  return (
    <QueryClientProvider client={queryClient}>
      <AuthProvider>
        <ThemeProvider defaultTheme="dark">
          <BrowserRouter>
            <Toaster richColors />

            <Routes>
              <Route path="/" element={<Home />} />

              <Route element={<Authenticate />}>
                <Route path="/login" element={<Login />} />

                <Route path="/register" element={<Register />} />
              </Route>

              <Route element={<PrivateRoute />}>
                <Route path="/explore" element={<Explore />} />
              </Route>
            </Routes>
          </BrowserRouter>
        </ThemeProvider>
      </AuthProvider>
    </QueryClientProvider>
  )
}
