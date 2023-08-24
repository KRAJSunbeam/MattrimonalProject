
import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import loginStyles from '../assets/login.css';
import { useHistory } from 'react-router-dom';

const Login = () => {
  const history = useHistory();
  const [formdata, setFormdata] = useState({
    email: "",
    password: ""
  });

  const loginHandler = (event) => {
    const { name, value } = event.target;
    setFormdata((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const login = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post('http://127.0.0.1:8080/login', formdata);
      console.log(response.data);
      history.push('/home');
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="login ">
      <h1 align="center" style={{ color: "white" }}>Matrimonial Login Form</h1>
      <form className='needs-validation container'>
        <div className="form-group">
          <label>Email:</label>
          <input
            type="text"
            className="form-control mb-2"
            placeholder="email"
            name="email"
            value={formdata.email}
            onChange={loginHandler}
            required
          />
          <div className="valid-feedback">Valid.</div>
          <div className="invalid-feedback">Please fill out this field.</div>
        </div>
        <div className="form-group">
          <label>Password:</label>
          <input
            type="password"
            className="form-control mb-2"
            placeholder="Password"
            name="password"
            value={formdata.password}
            onChange={loginHandler}
            required
          />
          <div className="valid-feedback">Valid.</div>
          <div className="invalid-feedback">Please fill out this field.</div>
        </div>
        <div>
        <button  type="submit" onClick={login} >login</button>
          <button type='reset'>Reset</button>
        </div>
      </form>
    </div>
  );
};

export default Login;
