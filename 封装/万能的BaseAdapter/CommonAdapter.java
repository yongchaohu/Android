
import java.util.List;

import com.liuguilin.commonjar.viewholder.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * FileName: EncodingUtils
 * Founder: LiuGuiLin
 * Create Date: 2017/11/22 13:49
 * Email: lgl@szokl.com.cn
 * Profile:万能适配器
 */
 
public abstract class CommonAdapter<T> extends BaseAdapter {

	protected Context mContext;
	protected List<T> mList;
	protected LayoutInflater inflater;
	private int layoutId;

	public CommonAdapter(Context mContext, List<T> mList, int layoutId) {
		this.mContext = mContext;
		this.mList = mList;
		this.layoutId = layoutId;
		inflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = ViewHolder.get(mContext, convertView, parent,position, layoutId);
		convert(viewHolder, getItem(position));
		return viewHolder.getConvertView();
	}

	public abstract void convert(ViewHolder holder, T t);
}
