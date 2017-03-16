package com.sasi.junitlearn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sasi.junitlearn.EstimateException;
import com.sasi.junitlearn.JiraService;
import com.sasi.junitlearn.SubTask;

public class JiraInProgressTest {
	
	private JiraService us;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Called Before each Test");
		us = new JiraService(1,"Change Title",4);
		SubTask task1 = new SubTask(1,"Work on Front End",2,0);
		SubTask task2 = new SubTask(1,"JavaScript Changes",2,0);
		SubTask task3 = new SubTask(1,"Unit Testing",1,0);
		SubTask task4 = new SubTask(1,"Work on Front End",1,0);
		us.setTasks(task1);
		us.setTasks(task2);
		us.setTasks(task3);
		us.setTasks(task4);
	}
	
	@Test
	public void LogWorkedOnSubTask() throws EstimateException{
		SubTask task1 = us.getTasks().get(0);
		task1.logWorked(1);
		assertEquals("This task is logged with 1 hr",1,task1.getLogWorked());
		assertEquals("This task is logged with 1 hr, So the remining Hours expected is",1,task1.getReminingHours());
		task1.logWorked(1);
		assertEquals("This task is already logged with 1 hr and now one more hour added",2,task1.getLogWorked());
		assertEquals("This task is logged with 2 hr expected remining Hours is",0,task1.getReminingHours());
	}
	
	

}
