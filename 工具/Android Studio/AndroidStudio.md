# Android Studio

## 一.配置

- 自动导包

> Settings-Editor-General-Auto Import选项下，勾上以下几个选项

	- XML 
		- show import popup
	- JAVA 
		- insert imports on paste选择none
		- show import popup
		- optimize imports on the fly
		- add unambiguous imports on the fly
	- C/C++ 
		- show import popup
- 代码自动提示

> Settings-Editor-General,把show quick doc on mouse move勾上

- 不区分大小写 

> 在Settings-Editor-General-Code Completion中，Case sensitive completion选择none

- 取消载入

> Systems-System Settings下，把Reopen last project startup的勾去掉

- 显示行号 方法分割线

> Settings-Editor-General-Appearance下，把Show line numbers勾上；把Show method separators勾上

## 二.Settings.Jar

- [点击下载](https://github.com/LiuGuiLinAndroid/Android/raw/master/%E5%B7%A5%E5%85%B7/Android%20Studio/settings.jar)

## 三.技巧

- 1.File Header

```
/**
 * FileName: ${NAME}
 * Founder: LiuGuiLin
 * Create Date: ${DATE} ${HOUR}:${MINUTE}
 * Email: lgl@szokl.com.cn
 * License:http://www.apache.org/licenses/
 * Profile: 
 */
```
 
- 2.加载framework.jar

	- 1.framework.jar放入app/libs/下
	
	- 2.project/build.gradle中加入

```
	allprojects {
    repositories {
        google()
        jcenter()
    }
    gradle.projectsEvaluated {
        tasks.withType(JavaCompile){
            //引入系统framework.jar
            options.compilerArgs.add('-Xbootclasspath/p:app\\libs\\framework.jar')
        }
    }
}
```

- 3.app/build.gradle中加入，并且置顶
	
```
	provided files('libs/framework.jar')
```

- 4.添加本地仓库

```
repositories {
    flatDir {
        dirs 'libs'
    }
}
```

- 5.关于Settings-Editor-Live Templates的使用

    * [使用AndroidStudio优雅的敲代码](http://blog.csdn.net/a_zhon/article/details/52594958)


## 四.插件

- LayoutCreator
- GsonFormat

