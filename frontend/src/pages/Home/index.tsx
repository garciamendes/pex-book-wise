import { ModeToggle } from "@/components/mode-toggle"

export const Home = () => {
  return (
    <div className="h-full flex flex-col p-5">
      <div className="self-end">
        <ModeToggle />
      </div>

      <h1>Hello</h1>
    </div>
  )
}