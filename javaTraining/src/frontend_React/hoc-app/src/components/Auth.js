export const Auth = (WrappedComponent) => {
  return function AuthenticationComponent(props) {
    const isLoggedIn = true;

    if (!isLoggedIn) {
      return (
        <div>
          <h3>Please Login to continue</h3>
        </div>
      );
    }

    return <WrappedComponent {...props} />;
  };
};
