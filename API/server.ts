
import {PATH} from './Config/config.ts'
// import { serve } from  '../deno/std/http/server.ts'
let serverModule = await import(`${PATH}std/http/server.ts`);//
const serve = await serverModule.serve


   
    const s = serve({ port: 5000 })


    console.log(`${PATH}std/http/server.ts`)
    console.log("http://localhost:5000/");
    for await (const req of s) {
      req.respond({ body: `Hello World\n ${PATH}` })
    }




