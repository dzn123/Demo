package com.glen.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dialogbox {
	@Test
	/*
	 处理js的三种对话框alert、confirmation、prompt
	 */
	public void alerttext() {
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("C:\\test.html");
		driver.findElement(By.xpath("html/body/input[1]")).click();
		driver.switchTo().alert().accept();//单击确认按钮
		driver.findElement(By.xpath("html/body/input[2]")).click();
		driver.switchTo().alert().dismiss();//单机取消按钮
	}
	

}
