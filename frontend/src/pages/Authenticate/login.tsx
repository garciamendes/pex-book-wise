import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Separator } from "@/components/ui/separator"
import { useUser } from "@/hooks/useUser"
import { ILogin } from "@/types/login"
import { FormEvent, useState } from "react"
import { useNavigate } from "react-router"
import { toast } from "sonner"

export const Login = () => {
  const [form, setForm] = useState<Record<string, string>>({})
  const { mutationLogin } = useUser()
  const navigate = useNavigate()

  const onChange = (name: string, value: string) => {
    setForm(prevState => ({ ...prevState, [name]: value }))
  }

  const handlerSendData = async (event: FormEvent) => {
    event.preventDefault()
    const email = form['email']
    const password = form['password']

    if (!email || !password)
      return toast.error('Todos os campos são obrigatórios')

    const data: ILogin = {
      email,
      password
    }

    await mutationLogin.mutateAsync(data)
  }

  return (
    <div className="flex flex-col gap-4">
      <div className="flex flex-col">
        <strong className="text-lg text-gray-100">Boas vindas!</strong>
        <p className="text-sm text-gray-200">Acesse sua conta e compartilhe suas leituras.</p>
      </div>

      <form onSubmit={handlerSendData} className="flex flex-col gap-4 ">
        <Input
          placeholder="Email"
          id="email"
          name="email"
          onChange={({ target }) => onChange(target.name, target.value)}
          className="bg-inputDefault p-6 w-full" />
        <Input
          type="password"
          placeholder="Senha"
          id="password"
          name="password"
          onChange={({ target }) => onChange(target.name, target.value)}
          className="bg-inputDefault p-6 w-full" />

        <Button type="submit" className="p-6 mt-6">Acessar</Button>
      </form>

      <Separator className="my-4" />

      <Button variant='outline' onClick={() => navigate('/register')}>Criar uma conta</Button>
    </div>
  )
}