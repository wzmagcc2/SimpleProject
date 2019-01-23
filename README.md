# SimpleProject
- <a href="#1">GIT操作</a>
   - <a href="#1.1">文件</a>
      - <a href="#1.1.1">添加</a>
      - <a href="#1.1.2">删除</a>
   - <a href="#1.2">分支</a>
      - <a href="#1.2.1">新建</a>
      - <a href="#1.2.2">合并</a>
      - <a href="#1.2.3">合并冲突</a>
      - <a href="#1.2.4">变基</a>
   - <a href="#1.3">时光机</a>
      - <a href="#1.3.1">工作区和暂存区</a>
      - <a href="#1.3.2">撤销修改</a>
   - [储藏](#1.4)
   - [日常错误解决](#1.5)

<a name="1">1GIT操作</a>
<a name="1.1">1.1文件</a>
<a name="1.1.1">1.1.1添加</a>

```sh
添加到暂存区
git add file
添加到本地git库
git commit -m "add file"
推送到远程库
git push
```

<a name="1.1.2">1.1.2删除</a>

```sh
本地删除
git rm file
更新到本地git库
git commit -m "delete file"
推送到远程库
git push
```

<a name="1.2">1.2分支</a>
<a name="1.2.1">1.2.1新建</a>

```sh
新建分支
git branch feature_1
切换到分支上
git checkout feature_1
以上两个命令等同于
git checkout -b feature_1
删除一个分支
git branch -d feature_1
```

<a name="1.2.2">1.2.2合并</a>

>将分支feature_1合并到master上

```sh
git checkout master//先切换回master分支
git merge feature_1//将feature_1分支合并到master分支上
```

>fast-forward模式
>当你的master能否顺着提交历史记录到达你分支的最新提交点（master的提交时分支的直接祖先），则**`git`**使用**`fast-forward`**模式直接将master的指向切换到你分支最新的提交版本上。

>master分支的提交版本和分支当前的提交版本无祖先关系
>git会自行决定选择一个作为最优的共同祖先，合并三方提交（一方：master上创建出分支的那次提交（也可以算是分支的祖先提交）；一方：master上最新的那次提交；一方：分支上最新的那次提交）

<a name="1.2.3">1.2.3合并冲突</a>

>当合并发生冲突后，利用**`git status`**命令查看冲突情况
>冲突文件中<<<<<<< 和=======之间包含的是被合并文件内容；=======和>>>>>>>之间包含的是合并过来的文件内容，一般是对同一个文件的同一个部分进行了不同的修改，Git 就没法干净的合并它们。
>解决完冲突后，就要按照add-commit-push的方式将修改后的文件上传

<a name="1.2.4">1.2.4变基</a>

>分叉的历史还有一种方式来合并，叫做变基，最终的目的是将历史记录归集为一条直线，仿佛是串行开发一样。
>操作方式：切换到分支上，执行**`git rebase master`**命令，提取分支**`feature_1`**上的提交存储为临时文件，应用到**`master`**分支上。

```sh
git checkout feature_1
git rebase master
```

>应用到**`master`**后，需要切换到**`master`**分支，执行**`merge`**操作。

```sh
git checkout master
git merge feature_1
```

<a name="1.3">1.3时光机</a>
<a name="1.3.1">1.3.1工作区和暂存区</a>

>工作区：电脑里面的工作目录。
>版本库：隐藏目录`.git`就是版本库。
>暂存区：通过`git add`命令后，文件就被添加到暂存区。

<a name="1.3.2">1.3.2撤销修改</a>

>**场景1**：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时。

```sh
git checkout -- 文件名
```

>**场景2**：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令git reset HEAD <file>，就回到了场景1，第二步按场景1操作。

```sh
git reset HEAD 文件名
git checkout -- 文件名
```

>**场景3**：已经提交了不合适的修改到版本库时，想要撤销本次提交，使用版本回退，不过前提是没有推送到远程库。

```sh
git reset --hard git版本号
```

1.4储藏<a name="1.4"></a>
>就是你有更新代码，但是这时候你又不想提交代码，因为你只工作了一半，可以使用如下命令

```sh
储藏
git stash
查看储藏的列表
git stash list
应用储藏（不带stash@{0}应用最新的）
git stash apply stash@{0}
删除储藏
git stash drop stash@{0}
应用最新储藏，并删除该储藏
git stash pop
```

1.5日常错误解决<a name="1.5"></a>
**清理`Untracked files`文件**
>使用`git clean`命令。可参考[官方git clean](https://git-scm.com/docs/git-clean)
