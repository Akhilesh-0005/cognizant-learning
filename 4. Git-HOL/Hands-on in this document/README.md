# Git Merge Conflict Resolution

Git Hands-On Lab demonstrating how to create and resolve a merge conflict.

## Scenario

The lab creates a branch named:

```text
GitWork
```

Both `GitWork` and `master` independently create/change `hello.xml` with different content. Merging `GitWork` into `master` therefore produces a conflict that must be resolved.

## Core Commands

```bash
git checkout master
git status

git checkout -b GitWork
# create/update hello.xml
git add hello.xml
git commit -m "Update hello.xml in GitWork"

git checkout master
# create hello.xml with different content
git add hello.xml
git commit -m "Add hello.xml in master"

git log --oneline --graph --decorate --all
git diff master GitWork
git difftool master GitWork

git merge GitWork
git mergetool

git add hello.xml
git commit -m "Resolve merge conflict between master and GitWork"

git status
git add .gitignore
git commit -m "Ignore merge backup files"

git branch -a
git branch -d GitWork

git log --oneline --graph --decorate
```

## Conflict Markers

Before resolution, `hello.xml` can contain:

```text
<<<<<<< HEAD
content from master
=======
content from GitWork
>>>>>>> GitWork
```

These markers identify the conflicting sections. Resolve them manually or with a three-way merge tool such as P4Merge, then stage and commit the resolved file.

## .gitignore

The included `.gitignore` ignores common backup files generated during conflict resolution:

```gitignore
*.orig
*.bak
*~
```

## Repository Structure

All files are directly at the repository root:

```text
hello.xml
.gitignore
git-conflict-resolution-commands.txt
README.md
```

There are no folders or subfolders.

> The lab document uses `master`. If your repository uses `main`, substitute `main` for `master`.
