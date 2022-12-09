package com.oms.GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepo.Getting_Started_OMS_MedikabazaarPage;
import com.ObjectRepo.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtilityClass implements IAutoconstant {
	
	 public WebDriver driver;
	 WebdriverActionclass webactiondriver;
	 FileLibClass filclass=new FileLibClass();
	 WebdriverActionclass webaction;
	 Getting_Started_OMS_MedikabazaarPage homepage;
	 public static WebDriver sdriver;

	
	@BeforeSuite
	public void connectToDB()
	{
		System.out.println("Connected to DB");
	}
	@AfterSuite
	public void disconnectToDB()
	{
		System.out.println("Disconnected to DB");

	}
	@BeforeClass
	public void launchBrowser() throws Exception
	{
		
		
		String browser=filclass.readPropertyData(PROP_PATH, "Browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please Enter Valid Browser Name");
		}
		String url=filclass.readPropertyData(PROP_PATH, "URL");
		driver.get(url);
		driver.manage().window().maximize();
		webactiondriver=new WebdriverActionclass(driver);
		webactiondriver.implicitlywait();
		sdriver=driver;
	
	}
	@BeforeMethod
	public void login() throws Exception
	{
		loginPage log_page=new loginPage(driver);
		String un=filclass.readPropertyData(PROP_PATH, "Username");
		String pwd=filclass.readPropertyData(PROP_PATH, "Password");
		log_page.getLogin_app(un,pwd);
	
	}
	
	@AfterMethod
	public void logout() throws Exception
	{
	    webaction= new WebdriverActionclass(driver);
		webaction.implicitlywait();
	    homepage=new Getting_Started_OMS_MedikabazaarPage(driver);
		homepage.getUser_logo().click();
		homepage.getLogout_button().click(); 
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}


}
