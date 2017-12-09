# WindowManager

## 一.使用方式

- [查看源码](https://github.com/LiuGuiLinAndroid/Android/blob/master/%E5%B0%81%E8%A3%85/WindowManager/WindowManager.java)

```
	//View对象
	View mView = WindowManager.getInstance(this).getView(R.layout.layout);
	//显示Window
	WindowManager.getInstance(this).showWindow(mView);
	//显示Window 并且指定自动消失的时间
	//WindowManager.getInstance(this).showWindow(mView,30*1000);
	//隐藏Window
	WindowManager.getInstance(this).hideWindow(mView);
```

