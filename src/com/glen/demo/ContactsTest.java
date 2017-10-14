package com.glen.demo;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; 
import java.net.URL;  

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ContactsTest {
	private String input1;
	private String input2;
	private String result;
    private AndroidDriver driver; 

    @Before
    public void setUp() throws Exception {        
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");//BROWSER_NAME  需要进行自动化测试的手机 web 浏览器名称。如果是对应用进行自动化测试，这个关键字的值应为空
        capabilities.setCapability("platformName", "Android");//运行系统平台设置为android
        capabilities.setCapability("deviceName", "Android Emulator");//运行设备设置为安卓模拟器       
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.2.2");        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");     
        //初始化
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
    }
    
    @Parameters
    public static Collection prepareDate(){
        // 测试数据
        String[][] string = { { "1", "1", "2" }, { "2", "2", "4"} };
        return Arrays.asList(string);// 将数组转换成集合返回
    }
    
    public ContactsTest(String input1,String input2, String result) {
		// junit会把准备的测试数据传递给构造函数
    	this.input1=input1;
    	this.input2=input2;
    	this.result=result;
	}
    
//    public String a(String input) {
//    	String result;
//		switch (Integer.parseInt(input)) {
//		case 1: result="" break;
//		case 2: result="" break;
//		case 3: result="" break;
//		case 4: result="" break;
//		case 5: result="" break;
//		case 6: result="" break;
//		case 7: result="" break;
//		case 8: result="" break;
//		case 9: result="" break;
//		default: 
//			break;
//		}
//		return result;
//	}
 
    @Test
    public void addContact() throws InterruptedException{

    	
    	driver.findElement(By.id("com.android.calculator2:id/del")).click();
    	driver.findElement(By.name(input1)).click();
    	driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
    	driver.findElement(By.name(input2)).click();

    	driver.findElement(By.id("com.android.calculator2:id/eq")).click();
    	Thread.sleep(5000);
    	String string=driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
//    	System.out.println(string);
    	assertEquals(result,string);
    }    
    
    
    @After
    public void tearDown() throws Exception {
        driver.quit();//退出app
    }
}