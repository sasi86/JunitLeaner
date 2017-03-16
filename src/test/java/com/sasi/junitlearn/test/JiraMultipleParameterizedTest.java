package com.sasi.junitlearn.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sasi.junitlearn.EstimateException;
import com.sasi.junitlearn.JiraService;
import com.sasi.junitlearn.SubTask;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
//https://github.com/Pragmatists/JUnitParams/blob/master/src/test/java/junitparams/usage/SamplesOfUsageTest.java
@RunWith(JUnitParamsRunner.class)
public class JiraMultipleParameterizedTest {
	
	private static JiraService us;
	
	@Rule
	public final NewSubTask subtask = new NewSubTask();
	
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("Called Before each Test");
		us = new JiraService(1,"Change Title",4);
		SubTask task1 = new SubTask(1,"Work on Front End",2,0);		
		us.setTasks(task1);
		
	}
	
	@Parameters({
		"1,1","1,0"
	})
	@Test
	public void LogWorkedOnSubTask(int input,int expected) throws EstimateException{
		SubTask task1 = us.getTasks().get(0);
		task1.logWorked(input);
		assertEquals("This task is logged with 1 hr and the remining Hours",expected,task1.getReminingHours());
	}
	
	

}
