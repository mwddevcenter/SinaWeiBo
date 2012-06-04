/**
 *
 */
package com.steve.android.weibo.activity;

/**
 * @fileName IWeiboActivity.java
 * @author SteveGuo
 * @createDate 2012-3-28 下午10:38:36
 */
public interface IWeiboActivity {
	// 初始化方法
	void init();
	
	// 刷新用户界面UI
	void refresh(Object...objects);
}
