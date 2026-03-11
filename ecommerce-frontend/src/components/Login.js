import React, { useState } from "react";
import API from "../services/api";
import "./Login.css";

function Login({ onLogin, goToRegister }) {

  const [user,setUser]=useState({
    email:"",
    password:""
  });

  const handleChange=(e)=>{
    setUser({...user,[e.target.name]:e.target.value});
  };

  const handleSubmit=async(e)=>{
    e.preventDefault();

    try{

      const res = await API.post("/users/login",user);

      if(res.data){
        alert("Login Successful");
        onLogin();
      }

    }
    catch(err){
      alert("Invalid Email or Password");
    }
  };

  return(

    <div className="login-container">

      <div className="login-card">

        <h2>Login</h2>

        <form onSubmit={handleSubmit}>

          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            onChange={handleChange}
            required
          />

          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            onChange={handleChange}
            required
          />

          <button type="submit" className="login-btn">
            Login
          </button>

        </form>

        <p className="switch-text">Don't have an account?</p>

        <button className="switch-btn" onClick={goToRegister}>
          Register
        </button>

      </div>

    </div>
  );
}

export default Login;