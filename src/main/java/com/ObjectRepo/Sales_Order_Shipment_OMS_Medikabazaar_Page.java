package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sales_Order_Shipment_OMS_Medikabazaar_Page {
	
	@FindBy(id="logisticDetailNavId") private WebElement Logistic_details;
	@FindBy(id="verification_status") private WebElement Verification_status;
	@FindBy(id="logistic_form_submit") private WebElement Approval_submit;

	
	 public Sales_Order_Shipment_OMS_Medikabazaar_Page(WebDriver driver)
	    {
	    	PageFactory.initElements(driver,this);
	    }

		public WebElement getLogistic_details() {
			return Logistic_details;
		}
		public WebElement getVerification_status() {
			return Verification_status;
		}
		public WebElement getApproval_submit() {
			return Approval_submit;
		}	

}
