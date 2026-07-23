import React from 'react';

function CourseDetails({ courses }) {
  const courseDetails = courses?.map((course) => (
    <div key={course.id}>
      <h2>{course.name}</h2>
      <h4>{course.date}</h4>
    </div>
  ));

  return (
    <div>
      <h1>Course Details</h1>
      {courseDetails?.length ? courseDetails : <p>No courses available.</p>}
    </div>
  );
}

export default CourseDetails;
