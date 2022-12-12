package com.oms.GenericLib;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverActionclass extends BaseUtilityClass {


	public WebdriverActionclass(WebDriver driver)
	{
		this.driver=driver;
	}
	public void maximumWindow()
	{
		driver.manage().window().maximize();
	}

	public void implicitlywait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void explicitywait(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void moveToElement(WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public void select_dd_by_value(WebElement element,String value)
	{
		Select sc=new Select(element);
		sc.selectByValue(value);
	}
	public void select_dd_by_visibletext(String visible_text,WebElement element)
	{
		Select sc=new Select(element);
		sc.selectByValue(visible_text);
	}
	public void select_dd_by_index(WebElement element,int a)
	{
		Select sc=new Select (element);
		sc.selectByIndex(a);
	}

	public void scrolldown_By_element(WebElement element)
	{
		Point loc = element.getLocation();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy"+loc);
	}
	public void scrollBy_value(String x,String y)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");

	}
	public void scrollBy_bottom()
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void alert_accept()
	{
		driver.switchTo().alert().accept(); 
	}
	public void alert_dismiss()
	{
		driver.switchTo().alert().dismiss();
	}

	public String currentDateTime() 
	{
		LocalDateTime obj=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yy");
		String value = dtf.format(obj);
		String value1 = value.replace(" ","_");
		String value2 = value1.replaceAll(":", ".");
		return value2;
	}
	
	public String screenshot_fail(String methodName) 
	{

		TakesScreenshot ts=(TakesScreenshot)sdriver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		String path=IAutoconstant.Screenshot_Failed_PATH+"TC_XXXX"+"_"+methodName+"_"+currentDateTime()+".png";
		File dsn=new File(path);
		try {
			Files.copy(scr, dsn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(path);
		System.out.println(dsn.getAbsolutePath());
		return dsn.getAbsolutePath();
	}

	public String screenshot(String name,String flowname)
	{
		TakesScreenshot ts=(TakesScreenshot)sdriver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+IAutoconstant.Screenshot_PATH_PO+"TC_XXXX"+"_"+flowname+"_"+name+"_"+currentDateTime()+".png";
		File dsn=new File(path);
		try {
			Files.copy(scr, dsn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void thread_sleep(int value) throws Exception
	{
		Thread.sleep(value);
	}


	public String screenshot_URL(String name)
	{
		WebDriver sdriver=driver;
		TakesScreenshot ts=(TakesScreenshot)sdriver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+IAutoconstant.Screenshot_URL_PATH+name+"_"+currentDateTime()+".png";
		File dsn=new File(path);
		try {
			Files.copy(scr, dsn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	














}
