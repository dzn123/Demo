package com.glen.demo;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.ExpectedExceptionsHolder;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Wait {
	
	WebDriver driver=new FirefoxDriver();
	@Before
	public void Setup(){
		driver.navigate().to("https://www.baidu.com");		
	}
	
	@Test
	public void test001_ImplicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	@Test
	public void test002_waitfor(){
		WebElement targetElement = (new WebDriverWait(driver, 10)).until(
				new ExpectedCondition<WebElement>() {
					@Override
					public WebElement apply(WebDriver a){
						return a.findElement(By.id(""));
					}
				});
	}
	
	@Test
	public void test003_waittest2() throws InterruptedException{
		Thread.sleep(2000);
	}
	
	
	
	
	
	@After
	public void close(){
		driver.close();
	}

}
