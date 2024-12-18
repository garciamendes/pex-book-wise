import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Separator } from "@/components/ui/separator"
import { useNavigate } from "react-router"

export const Login = () => {
  const navigate = useNavigate()

  const handlerSendData = (formData: FormData) => {
    console.log(formData.get('email'))
    console.log(formData.get('password'))
  }

  return (
    <div className="flex flex-col gap-4">
      <div className="flex flex-col">
        <strong className="text-lg text-gray-100">Boas vindas!</strong>
        <p className="text-sm text-gray-200">Acesse sua conta e compartilhe suas leituras.</p>
      </div>

      <form action={handlerSendData} className="flex flex-col gap-4 ">
        <Input placeholder="Email" id="email" name="email" className="bg-inputDefault p-6 w-full" />
        <Input type="password" placeholder="Senha" id="password" name="password" className="bg-inputDefault p-6 w-full" />

        <Button type="submit" className="p-6 mt-6">Acessar</Button>
      </form>

      <Separator className="my-4" />

      <Button variant='outline' onClick={() => navigate('/register')}>Criar uma conta</Button>
    </div>
  )
}