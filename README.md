# Yatzy

## fixup a commit
```shell
#get last commit hash
git log --pretty -n 1
# add a fixup to the commit
git commit -a --fixup <COMMIT_HASH>
```

Then, after the review is done, autosquash the commits in the branch.
```shell
git rebase -i --autosquash <COMMIT_HASH>^
```

Force push changes to the remote.
```shell
git push origin <BRANCH> -f
```

## amend a commit 
```shell
git commit -a --amend 
```
