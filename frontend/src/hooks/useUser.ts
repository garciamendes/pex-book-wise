import { ILogin, LoginResponse } from "@/types/login";
import { useMutation } from "@tanstack/react-query";
import { toast } from "sonner";
import { useApi } from "./useApi";
import { useLocalStorage } from "./useLocalStorage";
import { RegisterRequest } from "@/types/register";

export const useUser = () => {
  const { api } = useApi();
  const { setItem } = useLocalStorage();

  const mutationLogin = useMutation({
    mutationFn: handlerLoginMutation,
    onSuccess: (response) => {
      const { token } = response;

      setItem(import.meta.env.VITE_KEY_PREFIX_TOKEN as string, token);
    },
    onError: (error) => {
      if (error.message) return toast.error(error.message);

      return toast.error("Falha ao efetuar login");
    },
  });

  const mutationRegister = useMutation({
    mutationFn: handlerRegisterMutation,
    onSuccess: () => {
      toast.success("Cadastro efetuado com sucesso!");
    },
    onError: (error) => {
      if (error.message) return toast.error(error.message);

      return toast.error("Falha ao efetuar cadastro");
    },
  });

  async function handlerLoginMutation(data: ILogin): Promise<LoginResponse> {
    const response = await api.post("/auth/login", data);
    return response.data;
  }

  async function handlerRegisterMutation(data: RegisterRequest): Promise<void> {
    await api.post("/auth/register", data);
  }

  return {
    mutationLogin,
    mutationRegister,
  };
};
