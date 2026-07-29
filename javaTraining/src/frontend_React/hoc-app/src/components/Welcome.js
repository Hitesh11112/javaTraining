// const BasicWelcome = (props) => {
//     return (
//         <div>
//             <h1>Welcome {props.myname}</h1>
//         </div>
//     );
// };

export const WelcomeComponent = (WrappedComponent) => {
    return function EnhancedComponent(props) {
        return (
            <div>
                <h2>Enhanced Component Demo</h2>
                <h1>Welcome.....</h1>
                <WrappedComponent {...props} />
            </div>
        );
    };
};
