## 本地新建一个项目上传到git仓库
```
IEDA新建一个项目springboot-learning
在项目跟目录下，右键git bash项目，输入命令 git init，这时会在项目根目录下生成.git文件夹
git add . 将所有文件添加到git
git commit -m "first commit",提交添加的文件
在github创建远程仓库springboot-learning
git remote add origin https://github.com/Code-Sun/springboot-learning.git
git push -u origin master，推送到远程仓库
git rm -r --cached .idea  删除.idea文件夹
git commit -m "删除.idea文件夹"
git push
```