import React from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './style.css';

function App() {
  const books = [
    { id: 101, bname: 'Master React', price: 670 },
    { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
    { id: 103, bname: 'Mongo Essentials', price: 450 }
  ];

  const blogs = [
    {
      id: 1,
      title: 'React Learning',
      author: 'Stephen Biz',
      description: 'Welcome to learning React!'
    },
    {
      id: 2,
      title: 'Installation',
      author: 'Schwarzmuller',
      description: 'You can install React from npm.'
    }
  ];

  const courses = [
    { id: 1, name: 'Angular', date: '4/5/2021' },
    { id: 2, name: 'React', date: '6/3/20201' }
  ];

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div className="details-container">
      <section className="column course-column">
        {showCourses && <CourseDetails courses={courses} />}
      </section>

      <section className="column book-column">
        {showBooks ? <BookDetails books={books} /> : <p>Books are hidden.</p>}
      </section>

      <section className="column blog-column">
        {showBlogs && blogs.length > 0 && <BlogDetails blogs={blogs} />}
      </section>
    </div>
  );
}

export default App;
