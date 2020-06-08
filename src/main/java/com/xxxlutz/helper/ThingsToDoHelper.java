package com.xxxlutz.helper;

import com.xxxlutz.base.Base;
import com.xxxlutz.pageObjects.HomePage;
import com.xxxlutz.utility.RandomStringGenerator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ThingsToDoHelper {
  public static Logger log = LogManager.getLogger(Base.class.getName());

  public static boolean addTaskfunctionality(WebDriver driver) {
    HomePage homepage = new HomePage(driver);
    String task = RandomStringGenerator.generateString();
    homepage.getInputTextBox().sendKeys(task + Keys.ENTER);
    WebElement todoList = homepage.getToDoList();
    List<WebElement> allLi = todoList.findElements(By.tagName("li"));
    for (WebElement element : allLi) {
      if (element.getText().equals(task)) {
        log.info("New task addition verification successfull.");
        return true;
      }
    }
    log.error("New task addition failed.");
    return false;
  }

  public static boolean taskDonefunctionality(WebDriver driver) {
    HomePage homepage = new HomePage(driver);
    String task = RandomStringGenerator.generateString();
    homepage.getInputTextBox().sendKeys(task + Keys.ENTER);
    WebElement todoList = homepage.getToDoList();
    List<WebElement> allLi = todoList.findElements(By.tagName("li"));
    for (WebElement element : allLi) {
      if (element.getText().equals(task)) {
        log.info("New task added successfully.");
        WebElement checkbox = element.findElement(
          By.xpath("//label[text()='" + task + "']//input[@type='checkbox']")
        );
        checkbox.click();
        log.info("Task checked successfully.");
      }
    }
    homepage.getTabActive().click();
    todoList = homepage.getToDoList();
    allLi = todoList.findElements(By.tagName("li"));
    for (WebElement element : allLi) {
      if (element.getText().equals(task)) {
        log.error("Task completed verification failed.");
        return false;
      }
    }

    homepage.getTabCompleted().click();
    todoList = homepage.getToDoList();
    allLi = todoList.findElements(By.tagName("li"));
    for (WebElement element : allLi) {
      if (element.getText().equals(task)) {
        log.info("Task completion verification successfull.");
        return true;
      }
    }

    log.error("Task completed verification failed.");
    return false;
  }
}
