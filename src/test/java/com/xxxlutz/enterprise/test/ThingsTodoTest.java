package com.xxxlutz.enterprise.test;

import com.xxxlutz.base.Base;
import com.xxxlutz.helper.ThingsToDoHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ThingsTodoTest extends Base {
  public WebDriver driver;
  public static Logger log = LogManager.getLogger(Base.class.getName());

  @BeforeTest
  public void initialize() {
    driver = initializeDriver();
    driver.get(prop.getProperty("url"));
  }

  @Test
  public void verifyAddThingsToDo() {
    Assert.assertTrue(ThingsToDoHelper.addTaskfunctionality(driver));
  }

  @Test
  public void verifyTaskCompleted() {
    Assert.assertTrue(ThingsToDoHelper.taskDonefunctionality(driver));
  }

  @AfterTest
  public void teardown() {
    driver.close();
  }
}
