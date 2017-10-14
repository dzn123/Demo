package com.glen.demo;


import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import io.appium.java_client.android.AndroidDriver;

public class qkpayH5 {

	public static AndroidDriver driver;
	
	public static void setup() throws Exception {
		// File classpathRoot = new File(System.getProperty("user.dir"));
		// File appDir = new File(classpathRoot, "apps");
		// File app = new File(appDir, "com.qk365.qkpay.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "5.0.2");
		// capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.qk365.qkpay");
		capabilities.setCapability("appActivity", "com.qk365.qkpay.activity.LoginActivity");
		
//		capabilities.setCapability("automationName","Selendroid");
		
//		 ChromeOptions options = new ChromeOptions();
//				  options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
//				  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	

	
	public static void main(String[] args) throws Exception{
		setup();
		try {
//		driver.findElement(By.id("com.qk365.qkpay:id/et_username")).clear();
//		driver.findElement(By.id("com.qk365.qkpay:id/et_username")).sendKeys("18918723988");
		driver.findElementById("com.qk365.qkpay:id/et_password").sendKeys("Aa111111");
		driver.findElementById("com.qk365.qkpay:id/btn_login").click();
		
		Thread.sleep(2000);
		
		
		
			
			driver.findElement(By.id("com.qk365.qkpay:id/left_menu_iv")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='关于青客宝']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.qk365.qkpay:id/layout_protocol")).click();
			Thread.sleep(5000);
			Set<?> contexts=driver.getContextHandles();
			Iterator<?> it=contexts.iterator();
			while (it.hasNext()) {
				
				System.out.println("?????????????????????????????????????????"+it.next());
				
			}
			String context=driver.getContext();
			System.out.println("------_________________________---"+context);
//	        for (String contextName:context) {
//	        	System.out.println("=================================");
//	            System.out.println("----------"+contextName);
//
//	        }
//			driver.context("WEBVIEW");
//			System.out.println("-----------------"+driver.getCurrentUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
		
	}
}
