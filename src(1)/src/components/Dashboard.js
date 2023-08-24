// import React from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import dashboardStyles from '../assets/dashboard.css'; // Make sure to adjust the import path as needed
import connectImage from '../assets/connect.png';
import interactImage from '../assets/interact.png';
import signupImage from '../assets/signup.png';

function Dashboard() {
  return (
    <div className="dash">
      <div>
        <img style={{ height: '50px' }} src="https://img2.shaadi.com/assests/2016/images/home-logo.png" alt="logo" />
      </div>
      <div>
        <button className="btn1 bm">
          <Link to="/">help</Link>
        </button>
        <button className="btn2 bm">
          <Link to="/login">Login</Link>
        </button>
      </div>
      <div>
        <h1 className="text"> Sunbeam Matrimonial Service</h1>
        <h3 className="subtext">Founded for Placement</h3>
      </div>
      <div>
        <button className="bt">
          <Link to="/register">Let's Begin</Link>
        </button>
      </div>
      <div>
        <h1 className="tx">Find Someone Special</h1>
        <span>
          <Link to="/register">
            <img className="icon1" width="100px" height="100px" src={signupImage} alt="signup" />
          </Link>
          <Link to="/login">
            <img className="icon2" width="90px" height="100px" src={connectImage} alt="connect" />
          </Link>
          <img className="icon3" width="100px" height="100px" src={interactImage} alt="interact" />
        </span>
        <span>
          <h3 className="icon1">Signup</h3>
          <h3 className="ictx">Connect</h3>
          <h3 className="ictx1">Contact Us</h3>
        </span>
      </div>
    </div>
  );
}

export default Dashboard;
