
import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuguilin.commonjar.impl.OnAdapterSetImageUrlListener;

/**
 * FileName: EncodingUtils
 * Founder: LiuGuiLin
 * Create Date: 2017/11/22 13:49
 * Email: lgl@szokl.com.cn
 * Profile:ViewHolder
 */
 
public class ViewHolder {

	private SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	private Context mContext;

	public ViewHolder(Context mContext, ViewGroup parent, int position,
			int layoutId) {
		this.mContext = mContext;
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(mContext).inflate(layoutId, parent,false);
		mConvertView.setTag(this);
	}

	// 获取ViewHolder
	public static ViewHolder get(Context mContext, View convertView,ViewGroup parent, int position, int layoutId) {
		if (convertView == null) {
			return new ViewHolder(mContext, parent, position, layoutId);
		} else {
			ViewHolder viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.mPosition = position;
			return viewHolder;
		}
	}

	public View getConvertView() {
		return mConvertView;
	}

	// 获取View
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 设置文本
	 * 
	 * @param viewId
	 *            控件Id
	 * @param text
	 *            文本
	 * @return
	 */
	public ViewHolder setText(int viewId, String text) {
		TextView tView = getView(viewId);
		tView.setText(text);
		return this;
	}

	/**
	 * 设置图片背景本地资源
	 * 
	 * @param viewId
	 *            控件Id
	 * @param resId
	 *            图片Id
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, int resId) {
		ImageView imageView = getView(viewId);
		imageView.setBackgroundResource(resId);
		return this;
	}

	/**
	 * 设置图片背景位图
	 * 
	 * @param viewId
	 *            控件Id
	 * @param bitmap
	 *            位图
	 * @return
	 */
	public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView imageView = getView(viewId);
		imageView.setImageBitmap(bitmap);
		return this;
	}

	/**
	 * 解析网络图片
	 * 
	 * @param viewId
	 *            控件Id
	 * @param listener
	 *            回调
	 * @return
	 */
	public ViewHolder setImageUrl(int viewId,OnAdapterSetImageUrlListener listener) {
		ImageView imageView = getView(viewId);
		listener.setImageUrl(imageView);
		return this;
	}
}
