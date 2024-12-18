import AuthImg from '@/assets/images/image-login.svg'
import LogoImg from '@/assets/images/logo.svg'
import { motion } from 'motion/react'
import { Outlet, useLocation } from 'react-router'

export const Authenticate = () => {
  const location = useLocation()

  return (
    <div className="h-full w-full flex p-5">
      <div className='relative flex justify-center items-center'>
        <img src={LogoImg} alt='logo' className='absolute' />
        <img src={AuthImg} alt="auth-login" className='rounded-[10px]' />
      </div>

      <div className='flex-1 flex justify-center items-center'>
        <motion.div
          key={location.pathname} // A chave indica que a rota mudou
          initial={{ x: "100%", opacity: 0 }}
          animate={{ x: "0%", opacity: 1 }}
          exit={{ x: "-100%", opacity: 0 }}
          transition={{ duration: 0.5, ease: "easeInOut" }}
        >
          <Outlet />
        </motion.div>
      </div>
    </div>
  )
}