/**
 *
 */
package com.sina.android.weibo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.sina.android.weibo.R;

/**
 * @fileName AuthActivity.java
 * @author SteveGuo
 * @createDate 2012-5-24 下午10:36:00
 */
public class AuthActivity extends Activity{

	private Dialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.auth);
		
		View diaView=View.inflate(this, R.layout.authorize_dialog, null);

		dialog=new Dialog(this,R.style.auth_dialog);
		dialog.setContentView(diaView);
		dialog.show();
	}

	
}
