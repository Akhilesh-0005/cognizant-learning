# Blog App

ReactJS Hands-On Lab demonstrating React component lifecycle methods.

## Objective

The application:

- Defines a `Post` class.
- Defines a class-based `Posts` component.
- Stores posts in component state.
- Uses `loadPosts()` and the Fetch API.
- Loads posts from JSONPlaceholder.
- Calls `loadPosts()` from `componentDidMount()`.
- Displays each post title and body.
- Implements `componentDidCatch()` for component errors.
- Renders `Posts` from `App`.

## API

The application fetches posts from:

`https://jsonplaceholder.typicode.com/posts`

## Flat Repository Structure

All files are directly in the repository root:

```text
Post.js
Posts.js
App.js
index.js
style.css
index.html
package.json
.gitignore
README.md
```

There are no `src`, `public`, or other subfolders in this submission package.

## Run

```bash
npm install
npm start
```

Then open:

`http://localhost:3000`

## Concepts Demonstrated

- React class components
- State
- Constructor
- Fetch API
- `componentDidMount()`
- `render()`
- `componentDidCatch()`
- Rendering lists with `map()`
