import axios from 'axios';
import { Link } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
const Home = ({}) => {
  // Simulated user data
  const [user, setUser] = useState({firstName: "", age:0,email: "",});
  
  useEffect(() => {
    // Make the GET request when the component mounts
    axios.get(`http://127.0.0.1:8080/user/1`)
      .then(response => {
        setUser(response.data);
       
      })
      .catch(error => {
        console.error('Error fetching user data:', error);
        
      });
    },[]);
  return (
    <div>
      <h2>Welcome to Your Home, {user.firstName}!</h2>
      <div>
        
      <p>Email: {user.email}</p>
        <p>Age: {user.age}</p>
        {/* Display other user data */}
      </div>
      <Link to="/profile">Edit Profile</Link> 
      <Link to="/search">Search Profiles</Link> 
      <Link to="/messages">Messages</Link> 
      <Link to="/settings">Settings</Link> 
      
    </div>
  );
};

export default Home;