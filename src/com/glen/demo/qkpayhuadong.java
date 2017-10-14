package com.glen.demo;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import io.appium.java_client.android.AndroidDriver;

public class qkpayhuadong {

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
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	public static String getcode() throws Exception{
		WebDriver webDriver=new FirefoxDriver();
		webDriver.get("http://203.156.232.24:9082/usercenter/msgCode.html");
		Thread.sleep(2000);
		webDriver.findElement(By.id("verificationCode_txt")).sendKeys("18918723988");
		Thread.sleep(2000);
		return null;
		
	}
	
	
	public static void main(String[] args) throws Exception{
		setup();
		
//		driver.findElement(By.id("com.qk365.qkpay:id/et_username")).clear();
//		driver.findElement(By.id("com.qk365.qkpay:id/et_username")).sendKeys("18918723988");
		driver.findElementById("com.qk365.qkpay:id/et_password").sendKeys("Aa111111");
		driver.findElementById("com.qk365.qkpay:id/btn_login").click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.qk365.qkpay:id/btn_next")).click();
		
		Thread.sleep(2000);
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
//		scrollObject.put("direction", "left");
//		scrollObject.put("element", ((RemoteWebElement)element).getId());
//		js.executeScript("mobile: scroll", scrollObject);
		for(int i=0;i<5;i++){
		driver.swipe(500, 1800, 500, 80, 2000);
		Thread.sleep(2000);
		}
		Thread.sleep(2000);
		driver.findElement(By.id("com.qk365.qkpay:id/cbIsFinish")).click();
		driver.swipe(200, 1200, 700, 1200, 2000);
		
		Thread.sleep(2000);
		try {
			
			driver.findElement(By.id("com.qk365.qkpay:id/btn_next")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='获取验证码']")).click();
			
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
		
	}
}
