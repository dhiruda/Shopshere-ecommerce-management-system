import React, { useState } from "react";
import API from "../services/api";
import "./Register.css";

function Register({ goToLogin }) {

  const [user,setUser]=useState({
    ename:"",
    email:"",
    password:""
  });

  const handleChange=(e)=>{
    setUser({...user,[e.target.name]:e.target.value});
  };

  const handleSubmit=async(e)=>{
    e.preventDefault();

    try{
      await API.post("/users/save",user);
      alert("Registration Successful");
      goToLogin();
    }
    catch(err){
      alert("Registration Failed");
    }
  };

  return(

    <div className="register-container">

      <div className="register-card">

        <h2>Register</h2>

        <form onSubmit={handleSubmit}>

          <input
            name="ename"
            placeholder="Name"
            onChange={handleChange}
            required
          />

          <input
            name="email"
            placeholder="Email"
            onChange={handleChange}
            required
          />

          <input
            type="password"
            name="password"
            placeholder="Password"
            onChange={handleChange}
            required
          />

          <button type="submit" className="register-btn">
            Register
          </button>

        </form>

        <p className="switch-text">
          Already have an account?
        </p>

        <button className="switch-btn" onClick={goToLogin}>
          Login
        </button>

      </div>

    </div>
  );
}

export default Register;