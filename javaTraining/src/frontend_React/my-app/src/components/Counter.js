import { useState } from "react"

export const Counter = () => {
  
  const[count,setCount] = useState(0)

  return(
    <div>
      <h1>Count : {count} </h1><br/>
      <button onClick={()=>setCount(count+1)}>ADD</button>
      <button onClick={()=>setCount(count >0 ? count-1 : 0)}>SUB</button>
    </div>
  )
}