package com.sasi.junitlearn.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(NetagiveCategory.class)
@Suite.SuiteClasses({JiraServieCreationTest.class})
public class JiraCategorySuite {

}
