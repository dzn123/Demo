package com.glen.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByChromeDriver {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new FirefoxDriver();
		driver.get("https://www.baidu.com/");
	}

}
