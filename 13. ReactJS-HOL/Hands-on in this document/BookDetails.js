import React from 'react';

function BookDetails({ books }) {
  if (!books || books.length === 0) {
    return <p>No books available.</p>;
  }

  return (
    <div>
      <h1>Book Details</h1>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </div>
  );
}

export default BookDetails;
