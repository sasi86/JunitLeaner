package com.sasi.junitlearn;

public class SubTask {
	
	private int id;
	private String description;
	private int estimate;
	private int logWorked;
	private int reminingHours;
	private String assignee;
	private StatusConstant status;
	private JiraService userStory;
	
	public SubTask(int id,String description,int estimate,int logWorked){
		this.id=id;
		this.description = description;
		this.estimate = estimate;
		this.reminingHours = estimate;
		this.logWorked = logWorked;
		
		this.status = StatusConstant.OPEN;
	}
	
	
	public JiraService getUserStory() {
		return userStory;
	}
	public void setUserStory(JiraService userStory) {
		this.userStory = userStory;
	}
	public String getAssignee() {
		return assignee;
	}
	public String getDescription() {
		return description;
	}
	public int getEstimate() {
		return estimate;
	}
	public int getId() {
		return id;
	}
	
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getWorked() {
		return logWorked;
	}
	public void logWorked(int worked) throws EstimateException {
		this.logWorked = this.logWorked + worked;
		if(reminingHours > 0)
			reminingHours = reminingHours - worked;
		if(userStory.getReminingHours() > 0)
			userStory.setReminingHours(this.userStory.getReminingHours() - worked);
	}


	public int getLogWorked() {
		return logWorked;
	}


	public void setLogWorked(int logWorked) {
		this.logWorked = logWorked;
	}


	public StatusConstant getStatus() {
		return status;
	}


	public void setStatus(StatusConstant status) {
		this.status = status;
	}


	public int getReminingHours() {
		return reminingHours;
	}


	public void setReminingHours(int reminingHours) {
		this.reminingHours = reminingHours;
	}
	
	
	
	

}
