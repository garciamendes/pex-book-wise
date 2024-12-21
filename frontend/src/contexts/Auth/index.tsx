import React, { createContext, useState, useEffect } from "react";

interface AuthContextProps {
  isAuthenticated: boolean;
}

// eslint-disable-next-line react-refresh/only-export-components
export const AuthContext = createContext<AuthContextProps | undefined>(undefined);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const token = localStorage.getItem(import.meta.env.VITE_KEY_PREFIX_TOKEN)
  useEffect(() => {
    setIsAuthenticated(!!token)
  }, [token]);

  return (
    <AuthContext.Provider value={{ isAuthenticated }}>
      {children}
    </AuthContext.Provider>
  );
};