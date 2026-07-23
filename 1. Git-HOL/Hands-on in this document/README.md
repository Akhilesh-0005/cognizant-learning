# GitDemo

Git hands-on lab covering basic Git configuration, editor configuration, repository initialization, staging, committing, pulling, and pushing.

## Lab Objectives

- Configure Git username and email
- Configure Notepad++ as the default Git editor
- Initialize a Git repository
- Create and track `welcome.txt`
- Commit changes
- Use `git status`
- Pull from a remote repository
- Push changes to a remote repository

## Required File

`welcome.txt` contains:

```text
Welcome to the version control
```

## Main Commands

```bash
git version
git config --global user.name "Your Name"
git config --global user.email "your-email@example.com"
git config --global --list

git init GitDemo
cd GitDemo

git status
git add welcome.txt
git commit
git status
```

To connect your own GitLab/GitHub repository:

```bash
git remote add origin <YOUR-REMOTE-REPOSITORY-URL>
git pull origin master
git push origin master
```

If your repository uses `main` instead of `master`:

```bash
git pull origin main
git push -u origin main
```

## Repository Structure

All submission files are directly at the repository root:

```text
welcome.txt
git-commands.txt
README.md
.gitignore
```

There are no subfolders.
