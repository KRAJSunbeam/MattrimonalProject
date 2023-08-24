import React, { useState, useEffect } from 'react';
import axios from 'axios';

function EditProfile({ userId }) {
  const [user, setUser] = useState({});
  
  const [formData, setFormData] = useState({});

  useEffect(() => {
    axios.get(`http://127.0.0.1:8080/profile/1`)
      .then(response => {
        setUser(response.data);
        
      })
      .catch(error => {
        console.error('Error fetching user data:', error);
        
      });
  }, [userId]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData(prevData => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSave = () => {
    // Send the updated data to the server
    axios.put(`http://127.0.0.1:8080/profile/10`, formData)
      .then(response => {
        console.log('Profile updated successfully!', response.data);
        // Update local user data if needed
        setUser(response.data);
      })
      .catch(error => {
        console.error('Error updating user profile:', error);
      });
  };


  return (
    <div>
      <h1>Edit Profile</h1>
      <label>Name: </label>
      <input
        type="text"
        name="name"
        value={formData.name || user.name || ''}
        onChange={handleInputChange}
      />
      {/* Add more fields for editing */}
      <button onClick={handleSave}>Save</button>
    </div>
  );
}

export default EditProfile;
s