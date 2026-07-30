import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchUser } from "./userSlice";

export const User = () => {
  const dispatch = useDispatch();

  const { data, loading, error } = useSelector(
    (state) => state.user
  );

  const handleGetUser = () => {
    dispatch(fetchUser());
  };

  return (
    <div style={{ marginTop: "20px" }}>
      <button onClick={handleGetUser}>
        Get User
      </button>

      {loading && <h3>Loading...</h3>}

      {error && <h3>{error}</h3>}

      {data && (
        <div>
          <h2>User Details</h2>
          <p>ID: {data.id}</p>
          <p>Name: {data.name}</p>
          <p>Designation: {data.desg}</p>
        </div>
      )}
    </div>
  );
};