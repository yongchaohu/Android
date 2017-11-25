
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;

/**
 * FileName: WindowManager
 * Founder: LiuGuiLin
 * Create Date: 2017/11/22 10:54
 * Email: lgl@szokl.com.cn
 * Profile:WindowManage的二次封装
 */
 
public class WindowManager {
	
    private static WindowManager mInstance = null;
    private Context mContext;
    private android.view.WindowManager wm;
    private android.view.WindowManager.LayoutParams layoutParams;
	
    private WindowManager(Context mContext) {
        this.mContext = mContext;
        initWindowConfig();
    }
	
    private void initWindowConfig() {
        wm = (android.view.WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        layoutParams = new android.view.WindowManager.LayoutParams();
        layoutParams.width = android.view.WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = android.view.WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.flags = android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | android.view.WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                | android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;//全屏
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.type = android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
    }
	
    public static WindowManager getInstance(Context mContext) {
        if (mInstance == null) {
            synchronized (WindowManager.class) {
                if (mInstance == null) {
                    mInstance = new WindowManager(mContext);
                }
            }
        }
        return mInstance;
    }
	
    public View getView(int layoutId) {
        return View.inflate(mContext, layoutId, null);
    }
	
    public void showWindow(View view) {
        if (view != null) {
            if (view.getParent() == null) {
                wm.addView(view, layoutParams);
            }
        }
    }
	
    /**
     * 设置时间自动退出
     *
     * @param view
     * @param time 单位毫秒
     */
    public void showWindow(final View view, int time) {
        if (time > 0) {
            if (view != null) {
                if (view.getParent() == null) {
                    wm.addView(view, layoutParams);
                    //延时退出
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hideWindow(view);
                        }
                    }, time);
                }
            }
        }
    }
	
    public void hideWindow(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                wm.removeView(view);
            }
        }
    }
}