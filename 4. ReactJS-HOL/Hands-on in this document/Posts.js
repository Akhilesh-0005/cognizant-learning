import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Unable to load posts');
        }
        return response.json();
      })
      .then(data => {
        const posts = data.map(
          item => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts });
      })
      .catch(error => {
        alert(error.message);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('Error: ' + error.message);
    console.error(error, info);
  }

  render() {
    return (
      <div className="posts">
        <h1>Blog Posts</h1>

        {this.state.posts.map(post => (
          <div className="post" key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
