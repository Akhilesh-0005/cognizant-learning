# Git Branching and Merging Hands-On Lab

This repository contains the files and commands for Git HOL 3.

## Objectives

The exercise demonstrates:

- Creating a Git branch
- Listing local and remote branches
- Switching branches
- Making and committing changes on a branch
- Comparing a branch with the trunk
- Viewing visual differences using P4Merge
- Merging the branch into `master`/`main`
- Viewing the Git commit graph
- Deleting the branch after merging

## Branch Used

```text
GitNewBranch
```

## Core Workflow

```bash
git branch GitNewBranch
git branch -a
git checkout GitNewBranch

git add branch-file.txt
git commit -m "Add file in GitNewBranch"
git status

git checkout master
git diff master GitNewBranch
git difftool master GitNewBranch
git merge GitNewBranch

git log --oneline --graph --decorate

git branch -d GitNewBranch
git status
```

If your repository uses `main`, replace `master` with `main`.

## P4Merge

After configuring P4Merge as the Git difftool, use:

```bash
git difftool master GitNewBranch
```

The P4Merge executable location varies by installation, so the included
`git-branch-merge-commands.txt` contains an example configuration.

## Repository Structure

All submission files are directly at the repository root:

```text
branch-file.txt
git-branch-merge-commands.txt
README.md
.gitignore
```

There are no folders or subfolders.
