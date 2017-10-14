package com.glen.demo;

import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.*; 
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import org.apache.commons.io.FileUtils;

//import com.gargoylesoftware.htmlunit.javascript.host.file.File;
public class Screenshot { 
	@Test  
	public void testJavaScriptCalls() throws InterruptedException {   
		WebDriver driver = new FirefoxDriver();   
		driver.get("http://www.baidu.com");   
		JavascriptExecutor js = (JavascriptExecutor) driver;   
		String title = (String) js.executeScript("return document.title"); 
		assertEquals("百度一下，你就知道", title); 
		Thread.sleep(3000);
//		driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("aaa");
//		driver.findElement(By.id("su")).click();
		try {
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile,new File("E:\\png\\1.png"));
		} catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		
//		long links = (Long) js.executeScript("var links = " + "document.getElementsByTagName('A'); " + "return links.length");  
//		assertEquals(26, links);   
		driver.close();  
		} 
	} 