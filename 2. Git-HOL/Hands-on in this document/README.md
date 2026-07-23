# Git Ignore Hands-On Lab

Demonstrates ignoring `.log` files and `log` directories using Git.

## Required `.gitignore`

```gitignore
*.log
log/
```

Create the required test items locally:

```bash
echo "Sample application log" > application.log
mkdir log
echo "Sample log folder content" > log/sample.txt
```

Then run:

```bash
git status
```

Neither `application.log` nor `log/` should appear as untracked content.

Commit the ignore configuration:

```bash
git add .gitignore
git commit -m "Add gitignore rules for log files and folders"
git status
```

## Flat repository

The submission ZIP contains only root-level files, with no subfolders. The `log/` directory is intentionally not packaged because the requested repository structure is flat; create it locally with the command above to demonstrate that Git ignores it.
