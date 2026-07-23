import React from 'react';
import './style.css';

function App() {
  const element = 'Office Space';

  const offices = [
    { Name: 'DBS', Rent: 50000, Address: 'Chennai' },
    { Name: 'Regus', Rent: 65000, Address: 'Bangalore' },
    { Name: 'WeWork', Rent: 70000, Address: 'Hyderabad' }
  ];

  return (
    <div className="container">
      <h1>{element}, at Affordable Range</h1>

      <img
        className="office-image"
        src="https://images.unsplash.com/photo-1497366811353-6870744d04b2?auto=format&fit=crop&w=600&q=80"
        alt="Office Space"
      />

      {offices.map((office, index) => {
        const rentStyle = {
          color: office.Rent < 60000 ? 'red' : 'green'
        };

        return (
          <div className="office" key={index}>
            <h1>Name: {office.Name}</h1>
            <h3 style={rentStyle}>Rent: Rs. {office.Rent}</h3>
            <h3>Address: {office.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
