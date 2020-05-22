import { PATH } from "./Config/config.ts"
import {getUsers ,getUser} from './controller.ts'
let oakModule = await import(`${PATH}x/oak/mod.ts`)
const Router = await oakModule.Router

const router = new Router()
router.get('/users',getUsers).get('/users/:id',getUser)

export default router;
