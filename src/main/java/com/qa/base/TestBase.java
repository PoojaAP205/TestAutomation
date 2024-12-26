package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){

		prop = new Properties();
		FileInputStream ip;

		try {

			System.out.println("The path is "+System.getProperty("user.dir"));
			ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.out.println("using chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else  {

			System.out.println("using edge browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
}
