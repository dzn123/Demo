package com.glen.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Executejs {
	@Test
	public void js(){
		WebDriver driver = new FirefoxDriver();   
		driver.get("http://www.baidu.com");   
		JavascriptExecutor js = (JavascriptExecutor) driver;   
		String title = (String) js.executeScript("return document.title"); 
		assertEquals("百度一下，你就知道", title); 
	}
	
}
