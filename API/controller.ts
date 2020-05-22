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

const getUser = (
  { params, response }: { params: { id: string }; response: any },
) => {
  const user: IUser | undefined = searchUserById(params.id);
  if (!user) {
    response.status = 404;
    response.body = { message: "User not found" };
  } else {
    response.status = 200;
    response.body = user;
  }
};

const searchUserById = (id: string): (IUser | undefined) =>
  users.find((item) => item.id === id);

export { getUsers, getUser };
