package com.sasi.junitlearn;

import java.util.ArrayList;
import java.util.List;

public class JiraService {
	
	private int id;
	private String description;
	private List<SubTask> tasks;
	private int estimate;
	private String owner;
	private StatusConstant status;
	private int reminingHours;
	private boolean assinged;
	
	public JiraService(int id,String description,int estimate){
		this.id = id;
		this.description = description;
		this.estimate = estimate;
		this.reminingHours = estimate;		
		this.status = StatusConstant.OPEN;
		this.assinged = false;
	}
	
	public int getEstimate() {
		return estimate;
	}
	public int getId() {
		return id;
	}
	public String getOwner() {
		return owner;
	}
	public int getReminingHours() {
		return reminingHours;
	}
	
	
	public List<SubTask> getTasks() {
		return tasks;
	}
	public void setEstimate(int estimate)throws EstimateException {
		if(estimate < 0 )
			throw new EstimateException("Estimate hours cannot be negative");
		else
			this.estimate = estimate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setReminingHours(int reminingHours) {
		this.reminingHours = reminingHours;
	}
	
	
	public StatusConstant getStatus() {
		return status;
	}

	public void setStatus(StatusConstant status) {
		this.status = status;
	}

	public void setTasks(List<SubTask> tasks) {
		this.tasks = tasks;
	}

	public void setTasks(SubTask task) {
		if(this.tasks==null)
			this.tasks = new ArrayList<SubTask>();
		task.setUserStory(this);
		tasks.add(task);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAssinged() {
		return assinged;
	}

	public void setAssinged(boolean assinged) {
		this.assinged = assinged;
	}
	
	

}


