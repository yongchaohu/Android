# Linux

## 基础命令

- df -lh ： 查看Liunx存储大小

- find ：列出当前目录下的所有文件

- find ./xx/ ：列出指定目录下的文件

- find -name "xxx" ：查找指定文件

- find ./xx/ -name "xx" ：查找指定目录下的指定文件

- name换成iname :忽略大小写

- tar –xvf file.tar ：解压 tar包

- tar -xzvf file.tar.gz ：解压tar.gz

- tar -xjvf file.tar.bz2 ：解压 tar.bz2

- tar –xZvf file.tar.Z ：解压tar.Z

- unrar e file.rar：解压rar

- unzip file.zip ：解压zip


## 源码编译

```
   //编译前安装
   sudo apt-get install gnupg
   sudo apt-get install flex
   sudo apt-get install bison
   sudo apt-get install gperf
   sudo apt-get install build-essential
   sudo apt-get install zip
   sudo apt-get install curl
   sudo apt-get install libc6-dev
   sudo apt-get install libncurses5-dev:i386
   sudo apt-get install x11proto-core-dev
   sudo apt-get install libx11-dev:i386
   sudo apt-get install libreadline6-dev:i386
   sudo apt-get install g++-multilib
   sudo apt-get install mingw32
   sudo apt-get install tofrodos
   sudo apt-get install python-markdown
   sudo apt-get install libxml2-utils
   sudo apt-get install xsltproc
   sudo apt-get install zlib1g-dev:i386

```

- 1.repo sync ：同步代码

- 2.source build/envsetup.sh ：初始化编译环境

- 3.lunch ： 显示编译版本列表

- 4.luncd aosp_arm64-eng ：编译对应版本

- 5.make -j8 ：开始编译

- 6.source build/envsetup.sh lunch aosp_arm64-eng emulator ：启动虚拟机

- 7.emulator ：启动

- 8.mmm:编译指定目录

- 9.mm:编译当前目录