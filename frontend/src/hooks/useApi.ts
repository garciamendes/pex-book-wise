import axios from "axios";
import { useEffect } from "react";
import { useLocalStorage } from "./useLocalStorage";

export const useApi = () => {
  const { getItem } = useLocalStorage()

  const instance = axios.create({
    baseURL: import.meta.env.VITE_BASE_URL_API,
    headers: {
      'Content-Type': 'application/json',
    },
  });

  const token = getItem(import.meta.env.VITE_KEY_PREFIX_TOKEN)
  useEffect(() => {
    instance.defaults.headers.common['Authorization'] = String(token);

  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [token]);

  return { api: instance }
};
