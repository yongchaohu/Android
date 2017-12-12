package com.okl.okltxlauncher.manager;

import android.content.Context;

/**
 * FileName: WifiManager
 * Founder: LiuGuiLin
 * Create Date: 2017/11/22 10:54
 * Email: lgl@szokl.com.cn
 * Profile: WIFI控制
 */
 
public class WifiManager {

	private Context mContext;
	private android.net.wifi.WifiManager mWifiManager;
	private static WifiManager mInstance = null;

	private WifiManager(Context mContext) {
		this.mContext = mContext;

		initWifi();
	}

	private void initWifi() {
		mWifiManager = (android.net.wifi.WifiManager) mContext
				.getSystemService(Context.WIFI_SERVICE);
	}

	public static WifiManager getInstance(Context mContext) {
		if (mInstance == null) {
			synchronized (BTManager.class) {
				if (mInstance == null) {
					mInstance = new WifiManager(mContext);
				}
			}
		}
		return mInstance;
	}

	/**
	 * 获取当前的状态
	 * @return
	 */
	public boolean getWifiEnabled(){
		if(mWifiManager != null){
			return mWifiManager.isWifiEnabled();
		}
		return false;
	}
	
	/**
	 * 设置wifi状态
	 * @param enabled
	 */
	public void setWifiEnabled(boolean enabled) {
		if (mWifiManager != null) {
			mWifiManager.setWifiEnabled(enabled);
		}
	}
}
