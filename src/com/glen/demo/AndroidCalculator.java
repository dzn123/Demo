package com.glen.demo;
import io.appium.java_client.android.AndroidDriver;

import org.apache.xpath.operations.Equals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; 

import java.io.File;  
import java.net.URL;  
import java.util.List;

 
public class AndroidCalculator {
    private AndroidDriver driver; 
    @Before
    public void setUp() throws Exception {
        //设置apk的路径
//        File classpathRoot = new File(System.getProperty("user.dir"));//user。dir表示用户的当前工作目录。获取用户当前工作目录赋值给classpathRoot
//        File appDir = new File(classpathRoot, "apps");//把classpathRoot中的apps文件夹目录赋值给appdir
//        File app = new File(appDir, "ContactManager.apk");//把appdir中的ContactManager.apk文件赋值给app
        
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");//BROWSER_NAME  需要进行自动化测试的手机 web 浏览器名称。如果是对应用进行自动化测试，这个关键字的值应为空
        capabilities.setCapability("platformName", "Android");//运行系统平台设置为android
        capabilities.setCapability("deviceName", "Android Emulator");//运行设备设置为安卓模拟器
        
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.2.2");
        //设置apk路径（绝对路径）
//        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        
        //初始化
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
    }
 
    @Test
    public void addContact() throws InterruptedException{
//        List<WebElement> el = driver.findElementsByClassName("android.widget.LinearLayout");
//        el.get(4).click();
//        el.get(8).click();
//        el.get(5).click();
//        el.get(8).click();
//        el.get(21).click();
    	
    	driver.findElement(By.id("com.android.calculator2:id/del")).click();
    	driver.findElement(By.name("7")).click();
    	driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
    	driver.findElement(By.name("7")).click();

    	driver.findElement(By.id("com.android.calculator2:id/eq")).click();
    	Thread.sleep(5000);
    	String string=driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
//    	System.out.println(string);
    	assertEquals("14",string);
    }    
    
    
    @After
    public void tearDown() throws Exception {
        driver.quit();//退出app
    }
}