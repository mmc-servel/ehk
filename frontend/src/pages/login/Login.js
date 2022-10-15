import css from "./Login.module.css"

function Login(props) {

  const onButtonClick = (theButton) => {
    fetch('api/login', { method: 'POST', body: JSON.stringify({ 'username': document.getElementById("uname").value.trim() ,'password': document.getElementById("upass").value.trim() }), headers: { 'Content-Type': 'application/json' } }).then((response) => {
      return response.json();
    }).then((data) => {
      processLoginResponce(data);
    });
  }  

  function processLoginResponce(data) {
    if(data.responce==="OK"){
      props.onLogin(data.data.sessionid);
    }else{
      props.onLogin("");
    }
    /* history.replace("/");*/    
  }

    return (
        <div className={css.login}>
          <center><p>Log In</p></center>
          <p className={css.label_format}>Username</p>
          <input type="email" id="uname" className={css.input_format}/>

          <p className={css.label_format}>Password</p>
          <input type="password" id="upass" className={css.input_format}/>   
          <p></p>
          <center><button className={css.input_buton} onClick={onButtonClick.bind(this)}>LogIn</button> </center>      
        </div>
  );
}

export default Login;