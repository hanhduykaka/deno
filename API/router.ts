import { PATH } from "./Config/config.ts"
import {getUsers ,getUser, addUser} from './controller.ts'
let oakModule = await import(`${PATH}x/oak/mod.ts`)
const Router = await oakModule.Router

const router = new Router()
router.get('/users',getUsers).get('/users/:id',getUser).post('/users',addUser)

export default router;
