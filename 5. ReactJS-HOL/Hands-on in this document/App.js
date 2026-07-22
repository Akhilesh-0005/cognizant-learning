import React from 'react';
import CohortDetails from './CohortDetails';
import './index.css';

function App() {
  const cohorts = [
    {
      cohortCode: 'INTADMDF10',
      technology: '.NET FSD',
      startDate: '22-Feb-2022',
      currentStatus: 'Scheduled',
      coach: 'Athma',
      trainer: 'Jojo Jose'
    },
    {
      cohortCode: 'ADM21JF014',
      technology: 'Java FSD',
      startDate: '10-Sep-2021',
      currentStatus: 'Ongoing',
      coach: 'Apoorv',
      trainer: 'Elisa Smith'
    },
    {
      cohortCode: 'CDBJF21025',
      technology: 'Java FSD',
      startDate: '24-Dec-2021',
      currentStatus: 'Ongoing',
      coach: 'Athma',
      trainer: 'John Doe'
    }
  ];

  return (
    <div className="app">
      <h1>Cohorts Details</h1>

      <div>
        {cohorts.map((cohort) => (
          <CohortDetails
            key={cohort.cohortCode}
            cohort={cohort}
          />
        ))}
      </div>
    </div>
  );
}

export default App;
