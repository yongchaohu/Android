# Git

- 配置

```
git config --global user.name "刘桂林"
git config --global user.email "liuguilin74@gmail.com"
```

- 初始化

```
git init
git remote add origin https://xxxx.git
git add -A
git commit -m "Initial commit"
git push -u origin master
//refusing to merge unrelated histories
git pull origin master --allow-unrelated-histories
```

- 克隆

```
git clone https://xxxx.git
```

- 添加

```
//添加文件
git add xxx
//添加全部
git add -A
git add .
git add *
```

- 提交

```
//提交 需要填写说明
git commit 
//提交 附带说明
git commit -m 'xxxx'

```

- 推送

```
//推送
git push 
//推送到指定分支
git push origin xxx
```

- 下拉

```
//下拉
git pull 
//下拉指定分支
```
- 查看状态

```
git status
```

- 查看分支

```
git branch -a
```

- 查看log

```
git log
```

- 根据作者过滤log

```
git log --author='xxx'
```

- 切换分支

```
git checkout xxx
```

- 合并分支

```
git merge xxx
```

- 合并提交

```
git log
git cherry-pick xxx
```

- 回退版本

```
git log 
git reset --hard xxx
```

- 查看某个文件的提交历史

```
git log --pretty=oneline <文件名>
```

- 查看某个提交的某个文件的改动

```
git show <git提交版本号> <文件名>
```