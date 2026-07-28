import "./App.css";
import React from "react";

import { Hello } from "./components/Hello";
import { UseContext, NameContext } from "./components/UseContext";

function App() {

  return (
    <NameContext.Provider value="Hitesh Patwal">

      <Hello myname="Hitesh" />

      <UseContext />

    </NameContext.Provider>
  );
}

export default App;