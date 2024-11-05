import React, { createContext, useContext, useState, useEffect } from 'react';
import { jwtDecode } from 'jwt-decode';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser ] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      try {
        const decodedUser  = jwtDecode(token);
        setUser (decodedUser );
      } catch (error) {
        console.error("Token inválido ou expirado:", error);
        logout(); // Logout se o token não puder ser decodificado
      }
    }
  }, []);

  const login = (userData, token) => {
    setUser (userData);
    localStorage.setItem('token', token);
    sessionStorage.setItem('token', token);
  };

  const logout = () => {
    setUser (null);
    localStorage.removeItem('token'); // Remove do localStorage
    sessionStorage.removeItem('token'); // Remove da sessionStorage
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  return useContext(AuthContext);
};