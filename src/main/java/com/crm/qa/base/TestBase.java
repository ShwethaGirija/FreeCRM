package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.logs.Logger;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static org.apache.log4j.Logger log = LogManager.getLogger(TestBase.class);
	
	public TestBase() 
	{
		try {
			prop = readProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void initilaise()
	{
		log.info("Inside Test Initialization of Base class");
		String browserName =prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{ 	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	
	
	public Properties readProperties() throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(new File("/Users/shwetha.mahadeva/eclipse-workspace/FreeCRMPageObjectModel/src/main/java/com/crm/qa/config/config.properties"));
		
		prop.load(fis);
		
		return prop;
	}
}
