package com.xxxlutz.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	
	By headerLabel = By.xpath("//h1");
	By inputTextBox = By.cssSelector("input[type=text]");
	By tabAll = By.xpath("//a[text()='All']");
	By tabActive = By.xpath("//a[text()='Active']");
	By tabCompleted = By.xpath("//a[text()='Completed']");
	By buttonAddNew = By.xpath("//a[@title='Add New']");
	By buttonSearch = By.xpath("//a[@title='Search']");
	By toDoList = By.xpath("//ul[@class='list-unstyled']");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}



	public WebDriver getDriver() {
		return driver;
	}



	public WebElement getHeaderLabel() {
		return driver.findElement(headerLabel);
	}



	public WebElement getInputTextBox() {
		return driver.findElement(inputTextBox);
	}



	public WebElement getTabAll() {
		return driver.findElement(tabAll);
	}



	public WebElement getTabActive() {
		return driver.findElement(tabActive);
	}



	public WebElement getTabCompleted() {
		return driver.findElement(tabCompleted);
	}



	public WebElement getButtonAddNew() {
		return driver.findElement(buttonAddNew);
	}



	public WebElement getButtonSearch() {
		return driver.findElement(buttonSearch);
	}



	public WebElement getToDoList() {
		return driver.findElement(toDoList);
	}	
	
}
