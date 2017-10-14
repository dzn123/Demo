package com.glen.demo;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)

public class Qkpay {
    private AndroidDriver driver; 
	private String username;
	private String password;
	
	@Parameters//登录的用户数据
	public static Collection LoginDate(){
		String[][] string={{"13811111101","Aa111111"},{"13811111102","Aa111111"}};
		return Arrays.asList(string);
	}
	
    @Before
    public void setUp() throws Exception {
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        File app = new File(appDir, "com.qk365.qkpay.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "5.0.2");
//      capabilities.setCapability("app", app.getAbsolutePath()); 
        capabilities.setCapability("appPackage", "com.qk365.qkpay");
        capabilities.setCapability("appActivity", "com.qk365.qkpay.activity.LoginActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
    }
 
    public Qkpay(String username,String password) {
    	this.username=username;
    	this.password=password;
    	
	}
    
    @Test//登录
    public void test001_login() throws InterruptedException{
      driver.findElement(By.id("com.qk365.qkpay:id/et_username")).clear();
      driver.findElement(By.id("com.qk365.qkpay:id/et_username")).sendKeys(username);
//      driver.findElement(By.id("com.qk365.qkpay:id/et_password")).clear();
//      driver.findElement(By.id("com.qk365.qkpay:id/et_password")).sendKeys(password);
//      Thread.sleep(5000);
//      driver.findElementById("com.qk365.qkpay:id/btn_login").click();
//      Thread.sleep(5000);
      
//      driver.findElement(By.id("com.qk365.qkpay:id/left_menu_iv"));//判断是否进入首页
      
    }    
    
//    @Test//注册
//    public void test002_register(){
//    	driver.findElementById("com.qk365.qkpay:id/btn_register").click();
//    	driver.findElementById("com.qk365.qkpay:id/et_phone").sendKeys("15812345633");
//    	driver.findElementById("com.qk365.qkpay:id/btn_register").click();
//    }
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    
}