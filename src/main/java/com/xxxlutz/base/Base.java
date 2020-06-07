package com.xxxlutz.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() {
		
		
		prop = new Properties();
		FileInputStream fis = null;
		String projPath = System.getProperty("user.dir");
		try {
			fis = new FileInputStream(projPath + "//resources//data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String browserName = prop.getProperty("browser");
		
		switch(browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projPath + "//resources//chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			break;
		case "safari":
			break;
		case "BrowserStack":
			//for BrowserStack Integration
			final String USERNAME = prop.getProperty("userName");
			final String AUTOMATE_KEY = prop.getProperty("automateKey");
			final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			
			DesiredCapabilities caps = new DesiredCapabilities();
	        
			caps.setCapability("os", prop.getProperty("os"));
			caps.setCapability("os_version", prop.getProperty("os_version"));
			caps.setCapability("browser", prop.getProperty("browser_name"));
			caps.setCapability("browser_version", prop.getProperty("browser_version"));
			caps.setCapability("name", "XXXLutz UI Test");
			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//"+ testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
