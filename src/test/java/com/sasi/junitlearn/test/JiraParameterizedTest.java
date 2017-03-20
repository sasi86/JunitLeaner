package com.sasi.junitlearn.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sasi.junitlearn.EstimateException;
import com.sasi.junitlearn.JiraService;
import com.sasi.junitlearn.SubTask;

@RunWith(Parameterized.class)
public class JiraParameterizedTest {
	//@Parameter(value=0)
	public int input;
	//@Parameter(value=1)
	public int expected;
	private static JiraService us;
	
	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("Called Before each Test");
		us = new JiraService(1,"Change Title",4);
		SubTask task1 = new SubTask(1,"Work on Front End",2,0);		
		us.setTasks(task1);
		
	}
	//@Parameters(name="{index} : logWorked({0}) = {1}")
	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{1,1},
			{1,2}
		});
	}

	public JiraParameterizedTest(int input,int expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void LogWorkedOnSubTask() throws EstimateException{
		SubTask task1 = us.getTasks().get(0);
		task1.logWorked(input);
		assertEquals("This task is logged with 1 hr",expected,task1.getLogWorked());
		/*assertEquals("This task is logged with 1 hr, So the remining Hours expected is",1,task1.getReminingHours());
		task1.logWorked(1);
		assertEquals("This task is already logged with 1 hr and now one more hour added",2,task1.getLogWorked());
		assertEquals("This task is logged with 2 hr expected remining Hours is",0,task1.getReminingHours());*/
	}

}
