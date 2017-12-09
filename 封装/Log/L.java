
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.liuguilin.commonjar.entity.Constant;
import com.liuguilin.commonjar.utils.VersionUtils;

/**
 * FileName: WindowManager
 * Founder: LiuGuiLin
 * Create Date: 2017/11/22 10:54
 * Email: lgl@szokl.com.cn
 * Profile:Log
 */
 
 public final class L {

 	// 不支持创建
	public static final String NO_NEW = "Can't New!";
	// 没有权限
	public static final String NO_PERMISSIONS = "No WRITE_EXTERNAL_STORAGE Permissions!";
	
	private L() {
		throw new UnsupportedOperationException(L.class.getSimpleName()+ NO_NEW);
	}
	// 开关
	public static boolean DEBUG = true;
	// 所有TAG
	public static String ALLTAG = "AllLog";
	// 团队TAG
	public static String[] mStrLog = { "LGL1", "LGL2", "LGL3", "LGL4" };
	// Log 路径
	public static String PATH = "/sdcard/Log/";

	// Debug
	public static void d1(String d) {
		if (DEBUG) {
			Log.d(mStrLog[0], d);
			Log.d(ALLTAG, d);
		}
	}

	public static void d2(String d) {
		if (DEBUG) {
			Log.d(mStrLog[1], d);
			Log.d(ALLTAG, d);
		}
	}

	public static void d3(String d) {
		if (DEBUG) {
			Log.d(mStrLog[2], d);
			Log.d(ALLTAG, d);
		}
	}

	public static void d4(String d) {
		if (DEBUG) {
			Log.d(mStrLog[3], d);
			Log.d(ALLTAG, d);
		}
	}

	// Info
	public static void i1(String i) {
		if (DEBUG) {
			Log.i(mStrLog[0], i);
			Log.i(ALLTAG, i);
		}
	}

	public static void i2(String i) {
		if (DEBUG) {
			Log.i(mStrLog[1], i);
			Log.i(ALLTAG, i);
		}
	}

	public static void i3(String i) {
		if (DEBUG) {
			Log.i(mStrLog[2], i);
			Log.i(ALLTAG, i);
		}
	}

	public static void i4(String i) {
		if (DEBUG) {
			Log.i(mStrLog[3], i);
			Log.i(ALLTAG, i);
		}
	}

	// Warn
	public static void w1(String w) {
		if (DEBUG) {
			Log.w(mStrLog[0], w);
			Log.w(ALLTAG, w);
		}
	}

	public static void w2(String w) {
		if (DEBUG) {
			Log.w(mStrLog[1], w);
			Log.w(ALLTAG, w);
		}
	}

	public static void w3(String w) {
		if (DEBUG) {
			Log.w(mStrLog[2], w);
			Log.w(ALLTAG, w);
		}
	}

	public static void w4(String w) {
		if (DEBUG) {
			Log.w(mStrLog[3], w);
			Log.w(ALLTAG, w);
		}
	}

	// Error
	public static void e1(String e) {
		if (DEBUG) {
			Log.e(mStrLog[0], e);
			Log.e(ALLTAG, e);
		}
	}

	public static void e2(String e) {
		if (DEBUG) {
			Log.e(mStrLog[1], e);
			Log.e(ALLTAG, e);
		}
	}

	public static void e3(String e) {
		if (DEBUG) {
			Log.e(mStrLog[2], e);
			Log.e(ALLTAG, e);
		}
	}

	public static void e4(String e) {
		if (DEBUG) {
			Log.e(mStrLog[3], e);
			Log.e(ALLTAG, e);
		}
	}

	/**
	 * 日志写入SD卡，支持续写 小于等于5.0调用
	 * 
	 * @param fileName
	 *            文件名
	 * @param log
	 *            日志
	 */
	public static void writeLog(String fileName, String log) {
		File f = new File(PATH);
		if (!f.exists()) {
			f.mkdir();
		}
		File file = new File(PATH + fileName + ".log");
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			fos.write((log + "\n").getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 日志写入SD卡，支持续写 大于等于6.0调用
	 * 
	 * @param mContext
	 *            上下文
	 * @param fileName
	 *            文件名
	 * @param log
	 *            日志
	 */
	public static void writeLog(Context mContext, String fileName, String log) {
		if (VersionUtils.isBigM()) {
			if (ActivityCompat.checkSelfPermission(mContext,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
				throw new UnsupportedOperationException(NO_PERMISSIONS);
			} else {
				writeLog(fileName, log);
			}
		} else {
			writeLog(fileName, log);
		}
	}
}
