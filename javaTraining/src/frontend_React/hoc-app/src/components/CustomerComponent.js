
export const CustomerComponent = (props)=> {
  return (
    <div>
      <h1>Customer Component</h1>
      <div>
        <h3>Customer Name: {props.name}</h3>
        <h4>Role: {props.role}</h4>
      </div>
    
    </div>
  )
}