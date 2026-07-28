import React, { useState } from "react";
import { Hi } from "./Hi";

export function Hello(props) {

  const [name, setName] = useState("hiteshpatwal");

  return (
    <div>
      <h3>Hello function component from Hello.js</h3>

      <h3>Hello my name from parent component is {props.myname}</h3>

      <Hi myname={props.myname} />

      {/* Uncomment if you want to use state
      <h3>{name}</h3>

      <button onClick={() => setName("patwalhitesh")}>
        Change Name
      </button>
      */}
    </div>
  );
}