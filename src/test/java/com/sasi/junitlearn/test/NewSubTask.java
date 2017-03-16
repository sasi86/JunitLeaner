package com.sasi.junitlearn.test;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.sasi.junitlearn.JiraService;
import com.sasi.junitlearn.SubTask;

public class NewSubTask implements TestRule {
	private JiraService us;

	public JiraService getUserStory() {
		return this.us;
	}

	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				if (us == null) {
					us = new JiraService(1, "Change Title", 4);
					SubTask task1 = new SubTask(1, "Work on Front End", 2, 0);
					us.setTasks(task1);
					base.evaluate();
				}
			}
		};
	}
}
