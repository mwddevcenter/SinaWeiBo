/**
 *
 */
package com.steve.android.weibo.model;

import java.util.Map;

/**
 * @fileName Task.java
 * @author SteveGuo
 * @createDate 2012-3-28 下午9:58:04
 */
public class Task {
	
	/** 任务ID */
	private int taskId;
	/** 任务参数列表 */
	private Map<String, Object> taskParameters;

	public Task(int taskId, Map<String, Object> taskParameters) {
		this.taskId = taskId;
		this.taskParameters = taskParameters;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Map<String, Object> getTaskParameters() {
		return taskParameters;
	}

	public void setTaskParameters(Map<String, Object> taskParameters) {
		this.taskParameters = taskParameters;
	}
	
}
