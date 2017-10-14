package com.glen.demo;

import java.net.URL;
import java.util.HashMap;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class qkpayPaizhao  {
	private static AndroidDriver driver;
	
	static double heightratio=(double)360/1812;
	static double widthtratio=(double)150/1080;
	
	

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
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
//		int height=driver.manage().window().getSize().height;
//		int width=driver.manage().window().getSize().width;
//		System.out.println(height);
//		System.out.println(width);
//		
		
	}



	public static void main(String[] args)  throws Exception {
		setup();
		
		
		driver.findElement(By.id("com.qk365.qkpay:id/et_username")).clear();
		driver.findElement(By.id("com.qk365.qkpay:id/et_username")).sendKeys("120222000016801");
		driver.findElementById("com.qk365.qkpay:id/et_password").sendKeys("Aa111111");
		driver.findElementById("com.qk365.qkpay:id/btn_login").click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("com.qk365.qkpay:id/iv_click_tip")).click();
		Thread.sleep(3000);
		
		/*
		//从手机相册选取
		driver.findElement(By.id("android:id/content")).findElement(By.name("从手机相册选取")).click();
		driver.findElement(By.id("com.android.documentsui:id/container_roots")).findElement(By.name("图库")).click();
		driver.findElement(By.id("com.android.gallery3d:id/gallery_statelist_view")).findElement(By.id("com.android.gallery3d:id/album_cover_image")).click();
		Thread.sleep(3000);
		
		int height=driver.manage().window().getSize().height;
		int width=driver.manage().window().getSize().width;
		int actualwidth=(int)(width*widthtratio);
		int actualheight=(int)(height*heightratio);
		
		driver.tap(1, actualwidth, actualheight, 200);
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.gallery3d:id/head_select_right")).click();
		
		*/
		
		
		//拍照
		driver.findElement(By.id("android:id/content")).findElement(By.name("拍一张图片")).click();
		
		Thread.sleep(2000);
		driver.pressKeyCode(27);
//		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
//		HashMap keycode = new HashMap();
//		keycode.put("keycode", 82);
//		((JavascriptExecutor)driver).executeScript("mobile: keyevent", keycode);
 
	}
	
	
}