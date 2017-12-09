# 万能的适配器

## 使用方法

- [查看源码](https://github.com/LiuGuiLinAndroid/Android/tree/master/%E5%B0%81%E8%A3%85/%E4%B8%87%E8%83%BD%E7%9A%84BaseAdapter)

```
	ListView listView = new ListView(this);
	List<Bean> mList = new ArrayList<Bean>();
	Bean bean = new Bean();
	listView.setAdapter(new CommonAdapter<Bean>(this, mList, R.layout.xx) {

		@Override
		public void convert(ViewHolder holder, Bean t) {
			holder.setText(R.id.show1, t.getString());
		}
	});
```