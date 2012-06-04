package com.sina.android.weibo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.sina.android.weibo.R;
import com.sina.android.weibo.model.Task;
import com.sina.android.weibo.service.MainService;
import com.sina.android.weibo.util.Constants;

public class LoginActivity extends Activity implements IWeiboActivity{

	private static final String TAG = "[LoginActivity]";
	
	private TextView textView;
	private Button btn_login;
	private Button btn_registration;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		Intent intent = new Intent(this, AuthActivity.class);
		startActivity(intent);
		
		/*Intent intent = new Intent(LoginActivity.this, MainService.class);
		startService(intent);
		
		MainService.addActivity(this);
		
		btn_login = (Button) findViewById(R.id.btn_login);
		
		btn_login.setOnClickListener(new LoginOnclickListener());*/
		
	}
	
	class LoginOnclickListener implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			Task task = new Task(Constants.WEIBO_LOGIN, null);
			MainService.newTask(task);
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Object... objects) {
		textView = (TextView) findViewById(R.id.textView);
		textView.setText(objects[0].toString());
	}
}
