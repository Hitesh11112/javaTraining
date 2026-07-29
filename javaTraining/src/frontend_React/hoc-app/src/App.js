import './App.css';
import { Auth } from './components/Auth';
import { CustomerComponent } from './components/CustomerComponent';
import { UserComponent } from './components/UserComponent';
import { WelcomeComponent } from './components/Welcome';

// const EnhancedUser = WelcomeComponent(UserComponent)
// const EnhancedCustomer = WelcomeComponent(CustomerComponent);

const AuthenticatedUser = Auth(UserComponent);
const AuthenticatedCustomer = Auth(CustomerComponent);

function App() {
  const isLoggedIn = true;
  return (
    <div className="App">
      {/* <UserComponent myname="Hitesh" /> */}
      {/* <EnhancedUser myname="Hitesh" /> */}
      {/* <EnhancedCustomer msg="Customer Name is : Ram" /> */}
      <AuthenticatedUser isLoggedIn={`${isLoggedIn}`}
      name = "hitesh" role = "admin" />

      <AuthenticatedCustomer isLoggedIn={false}
      name = "Ram" role = "manager"/>

    </div>
  );
}

export default App;