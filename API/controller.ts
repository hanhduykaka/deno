interface IUser {
  id: string;
  name: string;
  gender: string;
}

let users: Array<IUser> = [{
  id: "1",
  name: "Robin Wieruch",
  gender: "Male",
}, {
  id: "2",
  name: "Kyle Simpson",
  gender: "Other",
}, {
  id: "3",
  name: "Andreas A. Antonopoulos",
  gender: "Female",
}];

const getUsers = ({ response }: { response: any }) => {
  response.body = users;
};

export { getUsers };
