import { WelcomeComponent } from "./Welcome";

export const UserComponent = (props) => {
    return (
        <>
            <div>
                <h1>User Component</h1>
                <h3>User Name : {props.name}</h3>
                <h4>Role : {props.role}</h4>
            </div>
            {/* <WelcomeComponent myname={props.myname}></WelcomeComponent> */}
        </>
    );
};