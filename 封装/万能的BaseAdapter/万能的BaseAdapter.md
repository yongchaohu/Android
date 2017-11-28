# 万能的适配器

## 一.使用方法

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