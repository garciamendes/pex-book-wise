import axios from "axios";
import { useEffect } from "react";
import { useLocalStorage } from "./useLocalStorage";

export const useApi = () => {
  const { getItem } = useLocalStorage()

  const instance = axios.create({
    baseURL: import.meta.env.BASE_URL,
  });

  const token = getItem('auth-token')
  useEffect(() => {
    instance.defaults.headers.common['Authorization'] = String(token);

  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [token]);

  return { api: instance }
};
