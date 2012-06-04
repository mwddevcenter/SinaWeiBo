package com.sina.android.weibo.activity;

import com.sina.android.weibo.R;
import com.sina.android.weibo.R.id;
import com.sina.android.weibo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class LogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.logo);
		ImageView logo_content = (ImageView) findViewById(R.id.logo_content);
		AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
		animation.setDuration(3000);
		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(LogoActivity.this, LoginActivity.class);
				startActivity(intent);
				
			}
		});
		logo_content.setAnimation(animation);
		ImageView logo = (ImageView) findViewById(R.id.logo);
		AlphaAnimation logoAnimation = new AlphaAnimation(0.1f, 1.0f);
		logoAnimation.setDuration(3000);
		logo.setAnimation(logoAnimation);
		
		ImageView logocopyright = (ImageView) findViewById(R.id.logo_copyright);
		AlphaAnimation copyrightAnimation = new AlphaAnimation(0.1f, 1.0f);
		copyrightAnimation.setDuration(3000);
		logocopyright.setAnimation(copyrightAnimation);
	}
	
}
