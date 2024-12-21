export interface ILogin {
  email: string
  password: string
}

export type LoginResponse = {
  token: string
}