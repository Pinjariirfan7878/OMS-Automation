package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Getting_Started_OMS_MedikabazaarPage {

	@FindBy (xpath="//a[text()=' Purchases ']") private WebElement purchase_tab ;
	@FindBy (xpath="//a[text()=' Purchase Orders ']") private WebElement purchase_order_option;
	@FindBy(xpath="//a[@id=\"navbarDropdown\"]") private WebElement user_logo;
	@FindBy(xpath="(//button[@class=\"dropdown-item\"])[2]") private WebElement logout_button;
	@FindBy(xpath="//a[contains(text(),' Return to Supplier ')]") private WebElement Return_to_supplier_button;
	@FindBy(xpath="//a[text()=' Orders ']") private WebElement Order_tab;
	@FindBy(xpath="//*[@id=\"main_nav\"]/ul/li[2]/ul/li[3]/a") private WebElement Interbranch_tab;
	@FindBy(xpath="//a[text()=' Sales Orders ']") private WebElement Sales_Order_button;


	public Getting_Started_OMS_MedikabazaarPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getPurchase_tab() {
		return purchase_tab;
	}


	public WebElement getPurchase_order_option() {
		return purchase_order_option;
	}


	public WebElement getUser_logo() {
		return user_logo;
	}


	public WebElement getLogout_button() {
		return logout_button;
	}

	public WebElement getReturn_to_supplier_button() {
		return Return_to_supplier_button;
	}
	
	public WebElement getOrder_button() {
		return Order_tab;
	}
	
	public WebElement getinterbranch_tab() {
		return Interbranch_tab;
	}
	
	public WebElement getSalesorder_button() {
		return Sales_Order_button;
	}


}
