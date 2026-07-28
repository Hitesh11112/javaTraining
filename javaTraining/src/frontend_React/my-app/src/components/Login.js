import { useEffect,useState } from "react";

export const Login = () => {

  const [uname, setUname] = useState("");
  const [pwd, setPwd] = useState("");

  const handleSubmit = (event) => {
    
    event.preventDefault();
    console.log(uname);
    console.log(pwd);

  };

  useEffect(() => {
    console.log("Component rendered");
  });

  return (
    <div className="container-fluid mt-3">
      <div className="card">
        <h1 className="card-header">Login Form</h1>

        <form onSubmit={handleSubmit}>

          <div className="card-body">

            {/* Username */}
            <div className="mb-3">
              <label className="form-label">
                UserName
              </label>

              <input
                type="text"
                className="form-control"
                value={uname}
                onChange={(event) => setUname(event.target.value)}
                placeholder="Enter UserName"
              />
            </div>


            {/* Password */}
            <div className="mb-3">
              <label className="form-label">
                Password
              </label>

              <input
                type="password"
                className="form-control"
                value={pwd}
                onChange={(event) => setPwd(event.target.value)}
                placeholder="Enter Password"
              />
            </div>


            {/* Button */}
            <div className="text-center">
              <button className="btn btn-primary" type="submit">
                Login
              </button>
            </div>

          </div>

        </form>

      </div>
    </div>
  );
};