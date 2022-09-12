import css from "./Login.module.css"

function Login(props) {
    return (
        <div className={css.login}>
          <center><p>Log In</p></center>
          <p className={css.label_format}>Username</p>
          <input type="email" id="title" className={css.input_format}/>

          <p className={css.label_format}>Password</p>
          <input type="password" className={css.input_format}/>   
          <p></p>
          <center><button>LogIn</button> </center>      
        </div>
  );
}

export default Login;