import {dayOfYear} from '../deno/std/datetime/mod.ts'


console.log(dayOfYear(new Date(2020,5,6)))


const source = await Deno.open("from.txt");
const buffer = new Deno.Buffer()
const bytesCopied1 = await Deno.copy(source, Deno.stdout);
const bytesCopied2 = await Deno.copy(source, buffer);
await Deno.copyFile("from.txt", "to.txt");
