const res = await fetch('https://speed.hetzner.de/10GB.bin');
const file = await Deno.open('./10gb.bin', { create: true, write: true })


await Deno.copy(res.body, file, { bufSize: 1 << 10 /* 1mb */ })
for await(const chunk of res.body) {
    await Deno.writeAll(file, chunk);
}
await res.body.close();