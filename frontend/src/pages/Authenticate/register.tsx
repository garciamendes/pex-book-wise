import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Separator } from "@/components/ui/separator"
import { ArrowLeft } from "lucide-react"
import { useNavigate } from "react-router"

export const Register = () => {
  const navigate = useNavigate()

  const handlerSendData = (formData: FormData) => {
    console.log(formData.get('email'))
    console.log(formData.get('password'))
    console.log(formData.get('confirmPassword'))
  }

  return (
    <div className="flex flex-col gap-4">
      <div className="flex flex-col">
        <strong className="text-lg text-gray-100">Boas vindas!</strong>
        <p className="text-sm text-gray-200">Crie uma conta e compartilhe suas leituras.</p>
      </div>

      <form action={handlerSendData} className="flex flex-col gap-4 ">
        <Input
          placeholder="Email"
          id="email"
          name="email"
          className="bg-inputDefault p-6 w-full" />
        <Input
          type="password"
          placeholder="Senha"
          id="password"
          name="password"
          className="bg-inputDefault p-6 w-full" />
        <Input
          type="password"
          placeholder="Confirme sua Senha"
          id="confirm-password"
          name="confirm-password"
          className="bg-inputDefault p-6 w-full" />

        <Button type="submit" className="p-6 mt-6">Criar</Button>
      </form>

      <Separator className="my-4" />

      <Button className="flex justify-start" variant='link' onClick={() => navigate('/login')}>
        <ArrowLeft />
        Voltar
      </Button>
    </div>
  )
}