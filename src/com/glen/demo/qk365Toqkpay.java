package com.glen.demo;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

//@AndroidFindBy(className ="android.webkit.WebView")
public class qk365Toqkpay {

//	private WebElement webView;
	public static AndroidDriver driver;
	
	public static void setup() throws Exception {
//		 File classpathRoot = new File(System.getProperty("user.dir"));
//		 File appDir = new File(classpathRoot, "apps");
//		 File app = new File(appDir, "huiyuan.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "5.0.2");
		
//		capabilities.setCapability("app", app.getAbsolutePath());
		
		capabilities.setCapability("appPackage", "com.qk365.a");
		capabilities.setCapability("appActivity", "com.qk365.a.SplashActivity");
		capabilities.setCapability("appWaitActivity", "com.qk365.a.MainActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	
	public static void login(){
		
	}
	
	public static void main(String[] args)  {
		try {
			
		
	    setup();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
		driver.findElement(By.id("com.qk365.a:id/onMyQk")).click();
		
//		Thread.sleep(2000);
		
		driver.findElement(By.id("com.qk365.a:id/myqk_middle_btn2")).click();
//		Thread.sleep(2000);
		
		driver.findElementByAccessibilityId("quchongzhi").click();
		Thread.sleep(2000);
		
		driver.swipe(500, 1600, 500, 80, 2000);
//		Thread.sleep(2000);
		driver.findElement(By.id("com.qk365.a:id/submitTx")).click();
//		Thread.sleep(5000);
		
		driver.findElement(By.id("com.qk365.a:id/btn1")).click();
//		Thread.sleep(2000);
		
		driver.findElement(By.id("com.qk365.a:id/rl_qkpay")).click();
		
		driver.startActivity("com.qk365.qkpay", "com.qk365.qkpay.activity.WelcomeActivity");
		
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.qk365.qkpay:id/rl_bank_alipay")).click();
		
		Thread.sleep(5000);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
			
		}
	}
	
}
