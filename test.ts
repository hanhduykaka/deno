// Deno.mkdirSync("new_dir");
// Deno.mkdirSync("nested/directories", { recursive: true });
// Deno.mkdirSync("restricted_access_dir", { mode: 0o700 });

// const conn4 = await Deno.connect({ hostname: "golang.org", port: 80, transport: "tcp" });

// console.log(conn4)



// const source = await Deno.open("README.md")
// const buffer = new Deno.Buffer()
// const bytesCopied1 = await Deno.copy(source, Deno.stdout)
// const bytesCopied2 = await Deno.copy(source, buffer)

// const buf = new Uint8Array(900);
// const numberOfBytesRead = await Deno.read(source.rid, buf); // 11 bytes
// const text = new TextDecoder().decode(buf);  // "hello world"
// console.log(text)
// Deno.close(source.rid);




// const file = await Deno.create("bar.txt");
// console.log(file)

// const file2 = await Deno.createSync("borr.txt");
// console.log(file2)

// const tempDirName0 = await Deno.makeTempDir();  // e.g. /tmp/2894ea76
// console.log(tempDirName0)
// const tempDirName1 = await Deno.makeTempDir({ prefix: 'my_temp' });
//  console.log(tempDirName1)


// import { assert } from "https://deno.land/std/testing/asserts.ts";
// const fileInfo = await Deno.lstat("foo.txt");
// assert(fileInfo.isFile);


// for await (const dirEntry of Deno.readDir("/")) {
//     console.log(dirEntry.name);
//   }


// const decoder = new TextDecoder("utf-8");
// const data = await Deno.readFile("README.md");
// console.log(decoder.decode(data));


// e.g. given /home/alice/file.txt and current directory /home/alice
await Deno.symlink("foo.txt", "bar.txt");
const realPath = await Deno.realPath("./file.txt");
const realSymLinkPath = await Deno.realPath("./symlink_file.txt");
console.log(realPath);  // outputs "/home/alice/file.txt"
console.log(realSymLinkPath);