import React, { createContext, useContext } from "react";

export const NameContext = createContext();

export const UseContext = () => {

  const myname = useContext(NameContext);

  return (
    <div>
      <h2>Name from Context : {myname}</h2>
    </div>
  );
};