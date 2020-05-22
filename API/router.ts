import { PATH } from "./Config/config.ts"
import {getUsers} from './controller.ts'
let oakModule = await import(`${PATH}x/oak/mod.ts`)
const Router = await oakModule.Router

const router = new Router()
router.get('/users',getUsers)

export default router;
