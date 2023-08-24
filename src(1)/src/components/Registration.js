import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import register from '../assets/register.css';
import { useHistory } from 'react-router-dom'; 
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';


const Register = () => {
  const [regdata, setRegdata] = useState({
    firstName: '',
    lastName: '',
    gender: '',
    age: 0,
    password: '',
    pincode: 0,
    email: '',
    mobileNo: '',
    birthDate: '',
    gender:'',
    userType: ''
  });
  const history = useHistory();

  const regFieldHandler = (event) => {
    const { name, value } = event.target;
    setRegdata((prevRegdata) => ({ ...prevRegdata, [name]: value }));
  };

  const registerHandler = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post('http://127.0.0.1:8080/user', regdata);
      console.log(response.data.profile.profileId);
      history.push('/login');
      
    } catch (error) {
      console.log('Registration error:', error);
    }
  };

  return (
    <div className="reg">
      <div className="container">
        <h1 align="center">Matrimonial Registration Form</h1>
        <form>

        <label for="fname">First Name:</label>
    <input type="text" id="fname" name="firstName" placeholder="First Name" onChange={regFieldHandler}/>

    <label for="lname">Last Name:</label>
    <input type="text" id="lname" name="lastName" placeholder="Last name.."onChange={regFieldHandler}/>
    
    <label for="lname">Age:</label>
    <input type="number" id="lname" name="age" placeholder="Age.." onChange={regFieldHandler}/> 

    <div className="form-group">
                  <label> Gender:</label>
                  <select class="form-control" name="gender" onChange={regFieldHandler} >
                      <option name="genderDto" onChange={regFieldHandler}>Male</option>
                      <option name="genderDto" onChange={regFieldHandler}>Female</option>
                      <option name="genderDto" onChange={regFieldHandler}>Others</option>
                  </select>
              </div> 
 
    <label for="lname">Password:</label>
    <input type="text" id="lname" name="password" placeholder="Password.." onChange={regFieldHandler}/>

    <label for="lname">Pincode:</label>
    <input type="number" id="lname" name="pincode" placeholder="Pincode.." onChange={regFieldHandler}/>

    <label for="lname">Mobile.No:</label>
    <input className="form-control mb-2" type="number" id="lname" name="mobileNo" placeholder="contact Number" onChange={regFieldHandler}/> 

    <label for="lname">Email Id:</label>
    <input className="form-control mb-2" type="email" id="lname" name="email" placeholder="Email id" onChange={regFieldHandler}/>

     <label  for="lname">DOB:</label>
    <input className="form-control mb-2" type="date" id="lname" name="birthDate" placeholder="enter DOB" onChange={regFieldHandler}/>

    <div className="form-group">
                  <label> userType:</label>
                  <select class="form-control" name="userType" onChange={regFieldHandler} >
                      <option name="genderDto" onChange={regFieldHandler}>Admin</option>
                      <option name="genderDto" onChange={regFieldHandler}>Candidate</option>
                     
                  </select>
              </div>

   <br/>

   <button  type="submit" onClick={registerHandler}><Link to='/login'>Register</Link></button>
        
        </form>
      </div>
    </div>
  );
};

export default Register;