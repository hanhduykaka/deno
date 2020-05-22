import { PATH } from "./Config/config.ts"
import router from "./router.ts"
const env = Deno.env.toObject()
const HOST = env.HOST || 'localhost'
const PORT = env.PORT || 7700

 let oakModule = await import(`${PATH}x/oak/mod.ts`)
 const Application = await oakModule.Application

const app = new Application()

app.use(router.routes())
app.use(router.allowedMethods())

console.log(`Listening on the  http://${HOST}:${PORT}`)

await app.listen(`${HOST}:${PORT}`)