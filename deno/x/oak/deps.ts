// Copyright 2018-2020 the oak authors. All rights reserved. MIT license.

// This file contains the external dependencies that oak depends upon

// `std` dependencies

export { HmacSha256 } from "./../../std/hash/sha256.ts";
export {
  Response,
  serve,
  Server,
  ServerRequest,
  serveTLS,
} from "./../../std/http/server.ts";
export {
  Status,
  STATUS_TEXT,
} from "./../../std/http/http_status.ts";
export {
  Cookies,
  Cookie,
  setCookie,
  getCookies,
  delCookie,
} from "./../../std/http/cookie.ts";
export {
  basename,
  extname,
  join,
  isAbsolute,
  normalize,
  parse,
  resolve,
  sep,
} from "./../../std/path/mod.ts";
export { assert } from "./../../std/testing/asserts.ts";

// 3rd party dependencies

export {
  contentType,
  lookup,
} from "../media_type/mod.ts";
export {
  compile,
  Key,
  parse as pathParse,
  ParseOptions,
  pathToRegexp,
  TokensToRegexpOptions,
} from "../path_to_regexp/index.ts";
