package com.glen.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dialogbox {
	@Test
	/*
	 ����js�����ֶԻ���alert��confirmation��prompt
	 */
	public void alerttext() {
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("C:\\test.html");
		driver.findElement(By.xpath("html/body/input[1]")).click();
		driver.switchTo().alert().accept();//����ȷ�ϰ�ť
		driver.findElement(By.xpath("html/body/input[2]")).click();
		driver.switchTo().alert().dismiss();//����ȡ����ť
	}
	

}
