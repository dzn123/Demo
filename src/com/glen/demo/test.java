package com.glen.demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;



public class test {

	
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com/");
		
//		Date date=new Date();
		
		driver.findElement(By.linkText("糯米")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;   
		String time =(String)js.executeScript("window.onload=function(){var myDate = new Date();return myDate.toLocaleString();}");
//		String title = (String) js.executeScript(";window.onload=myDate.toLocaleString()");	 
		System.out.println("-------------------------------");
		System.out.println(time);
		
		driver.quit();

	}
	
	
}
