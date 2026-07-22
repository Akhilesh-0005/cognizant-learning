# StudentApp - Student Management Portal

ReactJS hands-on lab demonstrating **class components**, multiple components, and component rendering.

## Task

Create a React application named `StudentApp` with three components:

- `Home`
- `About`
- `Contact`

The application invokes all three components from `App.js`.

## Expected Output

```text
Welcome to the Home page of Student Management Portal

Welcome to the About page of the Student Management Portal

Welcome to the Contact page of the Student Management Portal
```

## Project Structure

```text
StudentApp/
├── public/
│   └── index.html
├── src/
│   ├── Components/
│   │   ├── Home.js
│   │   ├── About.js
│   │   └── Contact.js
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   └── index.css
├── .gitignore
├── package.json
└── README.md
```

## Run the Project

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm start
```

Open:

```text
http://localhost:3000
```

## Concepts Demonstrated

- React class components
- `Component` from React
- `render()` method
- Creating multiple components
- Importing components
- Rendering components inside `App`
