import { useDispatch, useSelector } from "react-redux";
import { decrement, increment, reset } from "./CounterSlice";
import "bootstrap/dist/css/bootstrap.min.css";

export const Counter = () => {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  return (
    <div className="container mt-4 text-center">
      <h1>Redux Demo</h1>
      <h1>Count : {count}</h1>

      <button className="btn btn-primary m-3" onClick={() => dispatch(increment())}>
        Increment
      </button>
      <button className="btn btn-primary m-3" onClick={() => dispatch(decrement())}>
        Decrement
      </button>
      <button className="btn btn-primary m-3" onClick={() => dispatch(reset())}>
        Reset
      </button>
    </div>
  );
};