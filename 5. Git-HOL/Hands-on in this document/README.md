# Git Clean Up and Push to Remote

Git Hands-On Lab 5 demonstrates the final cleanup and remote synchronization workflow.

## Objectives

- Verify that the trunk branch is clean
- List available branches
- Pull changes from the remote repository
- Push pending local changes to the remote repository
- Verify that the changes are reflected remotely

## Commands

```bash
git checkout master
git status

git branch -a

git pull origin master

git push origin master

git remote -v
git log --oneline --graph --decorate --all
git status
```

## If Your Repository Uses `main`

Use:

```bash
git checkout main
git status
git branch -a
git pull origin main
git push origin main
```

## Expected Final State

After synchronization:

```text
nothing to commit, working tree clean
```

The latest commits and files should also be visible in the remote GitHub/GitLab repository.

## Repository Structure

All files are directly at the repository root:

```text
git-cleanup-push-commands.txt
README.md
.gitignore
```

No folders or subfolders are included.
