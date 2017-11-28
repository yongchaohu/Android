
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;

/**
 * FileName: EncodingUtils
 * Founder: LiuGuiLin
 * Create Date: 2017/11/22 13:49
 * Email: lgl@szokl.com.cn
 * Profile:版本判断
 */
 
public class VersionUtils {

	/**
	 * 获取当前的版本
	 * 
	 * @return
	 */
	public static int getSystemVersion() {
		return Build.VERSION.SDK_INT;
	}

	/**
	 * 获取当前应用版本号
	 * @param mContext
	 * @return
	 */
	public static String getAppVersion(Context mContext) {
		String version = "";
		try {
			PackageManager manager = mContext.getPackageManager();
			PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), 0);
			version = info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return version;
	}

	/**
	 * 是否大于5.0
	 * 
	 * @return
	 */
	public static boolean isBigLollipop() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 是否大于6.0
	 * 
	 * @return
	 */
	public static boolean isBigM() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			return true;
		} else {
			return false;
		}
	}
}
