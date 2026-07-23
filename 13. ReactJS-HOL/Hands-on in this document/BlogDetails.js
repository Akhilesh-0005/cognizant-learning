import React from 'react';

function BlogDetails({ blogs }) {
  return (
    <div>
      <h1>Blog Details</h1>

      {blogs && blogs.length > 0 ? (
        blogs.map((blog) => (
          <div key={blog.id}>
            <h2>{blog.title}</h2>
            <h4>{blog.author}</h4>
            <p>{blog.description}</p>
          </div>
        ))
      ) : (
        <p>No blogs available.</p>
      )}
    </div>
  );
}

export default BlogDetails;
