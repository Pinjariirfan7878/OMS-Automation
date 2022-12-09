package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Quote_and_Order_OMS_Medikabazaar_Page {

	@FindBy (id="customer_email") private WebElement Enter_Customer_Email_ID_Label;
	@FindBy(id="change_email") private WebElement submit_button;
	@FindBy(id="shipped_by") private WebElement Enter_Product_SKU_Label;
	@FindBy(id="qty") private WebElement Quantity_Label;
	@FindBy(id="skusubmit") private WebElement Add_Product_button;
	@FindBy(name="updateitemlist[]") private WebElement Check_Box; 
	@FindBy(className="dataTables_scrollBody") private WebElement Item_Details_Scroll_Bar;
	@FindBy(xpath="//*[@id=\"quotetable\"]/tbody/tr/td[11]/input") private WebElement Disc_Label;
	@FindBy(className="form-select") private WebElement Tax_Label;
	@FindBy(name="shipping_price")private WebElement Shipping_Price_Label;
	@FindBy(xpath="//button[text()='UPDATE']")private WebElement Shipping_Update;
	
	@FindBy(xpath="//*[contains(text(),'Place Order')]") private WebElement Place_Order;
	
	
	

	public Create_Quote_and_Order_OMS_Medikabazaar_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getEnter_Customer_Email_ID() {
		return Enter_Customer_Email_ID_Label;
	}
	public WebElement getSubmit_button() {
		return submit_button;
	}
	public WebElement getEnter_SKU() {
		return Enter_Product_SKU_Label;
	}
	public WebElement getQuantity_Field() {
		return Quantity_Label;
	}
	public WebElement getAdd_Product_button() {
		return Add_Product_button;
	}
	public WebElement getCheck_Box() {
		return Check_Box;
	}
	public WebElement getDisc_Label() {
		return Disc_Label;
	}
	public WebElement getScroll_Bar() {
		return Item_Details_Scroll_Bar;
	}
	public WebElement getTax_Field() {
		return Tax_Label;
	}
	public WebElement getShipping_Price() {
		return Shipping_Price_Label;
	}
	public WebElement getShipping_Update_Button() {
		return Shipping_Update;
	}
	public WebElement getPlace_Order_Button() {
		return Place_Order;
	}
}
