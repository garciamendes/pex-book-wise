import { useAuth } from "@/hooks/useAuth"
import { Navigate, Outlet, useLocation } from "react-router"

export const PrivateRoute = () => {
  const { isAuthenticated } = useAuth()
  const location = useLocation()

  return isAuthenticated ? <Outlet /> : <Navigate to="/" state={{ from: location }} replace />

}