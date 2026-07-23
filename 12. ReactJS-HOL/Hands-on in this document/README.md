# Ticket Booking App

ReactJS Hands-On Lab demonstrating conditional rendering.

## Requirements Implemented

- Guest page
- User page
- Login button
- Logout button
- Conditional rendering
- Element variable for Login/Logout button
- Guest users can view flight details
- Logged-in users can book tickets
- Login displays the User page
- Logout returns to the Guest page

## Conditional Rendering

The application maintains an `isLoggedIn` state.

When logged out:

```text
Please sign up.
Login
```

When logged in:

```text
Welcome back
Logout
```

The logged-in page also provides a **Book Ticket** button.

## Run

```bash
npm install
npm start
```

## Flat GitHub Structure

```text
App.js
index.js
style.css
index.html
package.json
.gitignore
README.md
```

All files are directly at the repository root. No folders or subfolders are included.
