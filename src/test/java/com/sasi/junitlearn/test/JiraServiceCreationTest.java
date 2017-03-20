package com.sasi.junitlearn.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.sasi.junitlearn.EstimateException;
import com.sasi.junitlearn.JiraService;
import com.sasi.junitlearn.StatusConstant;

public class JiraServiceCreationTest {

	private JiraService us; 
	
	@BeforeClass
	public static void setUpTest() throws Exception {
		System.out.println("Called Before start of any Test");
		System.out.println();
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Called Before each Test");
		us = new JiraService(1,"Change Title",4);
	}

	
	@Test
	public void InitialJiraStatusCheck() {
		System.out.println("test - InitialJiraStatusCheck");
		assertEquals("When User Story is created the status should be Open", StatusConstant.OPEN, us.getStatus());
	}
	
	@Test
	public void IsTasksEmptyForInitialJira() {
		System.out.println("test - IsTasksEmptyForInitialJira");
		assertNull("When User Story is created the status should be Open",us.getTasks());
	}
	
	@Test(expected=EstimateException.class)
	@Category(NetagiveCategory.class)
	public void EstimateUserStoryWithNegativeValue() throws EstimateException {
		System.out.println("test - EstimateUserStoryWithNegativeValue");
		us.setEstimate(-4);
	}
	
	@Test(timeout=400)
	public void timeoutTest() throws EstimateException {
		
		System.out.println("test - timeoutTest");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void UserStoryIsAssignedFalse() throws EstimateException {
		System.out.println("test - UserStoryIsAssignedFalse");
		assertFalse(us.isAssinged());
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Called After each Test");
		System.out.println();
	}
	
	@AfterClass
	public static void tearDownTest() throws Exception {
		System.out.println();
		System.out.println("Called after all the methods in the test class are executed");
	}


}
