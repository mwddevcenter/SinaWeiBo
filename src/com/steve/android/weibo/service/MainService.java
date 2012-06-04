/**
 * 
 */
package com.steve.android.weibo.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.steve.android.weibo.activity.IWeiboActivity;
import com.steve.android.weibo.model.Task;
import com.steve.android.weibo.util.Constants;

/**
 * @author 郭强
 *
 */
public class MainService extends Service implements Runnable {

	private static final String TAG = "[MainService]";
	
	private boolean isRunnable;
	
	private static Queue<Task> taskList = new LinkedList<Task>();
	
	private static List<Activity> activityList = new ArrayList<Activity>();
	
	/**
	 * 新增任务Task
	 * @param task
	 */
	public static void newTask(Task task) {
		taskList.add(task);
	}
	 
	/**
	 * 增加活动Activity
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		activityList.add(activity);
	}
	
	/**
	 * 删除活动Activity
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activityList.remove(activity);
	}
	
	@Override
	public void onCreate() {
		isRunnable = true;
		Thread thread = new Thread(this);
		thread.start();
		super.onCreate();
	}

	@Override
	public void run() {
		while(isRunnable) {
			Task task;
			if(!taskList.isEmpty()) {
				task = taskList.poll();
				if(null != task) {
					doTask(task);
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void doTask(Task task) {
		Message message = handler.obtainMessage();
		message.what = task.getTaskId();
		switch (task.getTaskId()) {
		case Constants.WEIBO_LOGIN:
			Log.v(TAG, "doTask----->> User Login");
			message.obj = "登录成功";
			break;

		default:
			break;
		}
		handler.sendMessage(message);
	}
	
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case Constants.WEIBO_LOGIN:
				IWeiboActivity iWeiboAativity = (IWeiboActivity) getActivityByName("LoginActivity");
				iWeiboAativity.refresh(msg.obj.toString());
				break;

			default:
				break;
			}
		}
	};
	
	/**
	 * 根据Activity的name获取Activity对象
	 * @param name
	 * @return
	 */
	private static Activity getActivityByName(String name) {
		if(!activityList.isEmpty()) {
			for(Activity activity : activityList) {
				if(null != activity) {
					if(activity.getClass().getName().indexOf(name) > 0) {
						return activity;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
