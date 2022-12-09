package com.OMS.SO;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepo.Create_Quote_and_Order_OMS_Medikabazaar_Page;
import com.ObjectRepo.Customer_Orders_OMS_Medikabazaar_Page;
import com.ObjectRepo.Getting_Started_OMS_MedikabazaarPage;
import com.ObjectRepo.Sales_Order_Shipment_OMS_Medikabazaar_Page;
import com.ObjectRepo.Success_OMS_Medikabazaar_Page;
import com.ObjectRepo.loginPage;
import com.oms.GenericLib.BaseUtilityClass;
import com.oms.GenericLib.FileLibClass;
import com.oms.GenericLib.WebdriverActionclass;

public class TC_005_Sales_Order_Test extends BaseUtilityClass {
	
	@Test
	public void create_sales_orderTest() throws Exception
	{
		Getting_Started_OMS_MedikabazaarPage getting_started = new Getting_Started_OMS_MedikabazaarPage(driver);
		Customer_Orders_OMS_Medikabazaar_Page sopage = new Customer_Orders_OMS_Medikabazaar_Page(driver);
		Create_Quote_and_Order_OMS_Medikabazaar_Page cqopage = new Create_Quote_and_Order_OMS_Medikabazaar_Page(driver);
		WebdriverActionclass webaction = new WebdriverActionclass(driver);
		Success_OMS_Medikabazaar_Page sosucmsg = new Success_OMS_Medikabazaar_Page(driver);
		loginPage log_page=new loginPage(driver);
		FileLibClass filclass = new FileLibClass();
		Sales_Order_Shipment_OMS_Medikabazaar_Page soapproval = new Sales_Order_Shipment_OMS_Medikabazaar_Page(driver);
		loginPage login_page = new loginPage(driver);
		
		//Sales Order Page
		getting_started.getOrder_button().click();
		Thread.sleep(1000);
		getting_started.getSalesorder_button().click();
		Thread.sleep(1000);
		sopage.getcreate_sales_order_button().click();
		Thread.sleep(2000);
		//Create Quote and Order Page
		Thread.sleep(1000);
		cqopage.getEnter_Customer_Email_ID().sendKeys("drcustomer@gmail.com");
		Thread.sleep(1000);
		cqopage.getSubmit_button().click();
		Thread.sleep(2000);
		
		webaction.scrollBy_value("0", "200");
		Thread.sleep(1000);
		cqopage.getEnter_SKU().sendKeys("MedO741");
		Thread.sleep(1000);
		cqopage.getQuantity_Field().clear();
		Thread.sleep(1000);
		cqopage.getQuantity_Field().sendKeys("3");
		Thread.sleep(1000);
		cqopage.getAdd_Product_button().click();
		Thread.sleep(10000);
		webaction.scrollBy_value("0", "500");
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		//Check_Box
		cqopage.getCheck_Box().click();
		Thread.sleep(2000);
		//Discount
		cqopage.getDisc_Label().clear();
		Thread.sleep(1000);
		cqopage.getDisc_Label().sendKeys("15");
		Thread.sleep(1000);
		//Tax
		//webaction.scrollBy_value("1000","0");
		//cqopage.getTax_Field().click();
		//webaction.select_dd_by_value(cqopage.getTax_Field(), "28");
		//Shipping Price
		cqopage.getShipping_Price().clear();
		Thread.sleep(1000);
		cqopage.getShipping_Price().sendKeys("150");
		Thread.sleep(1000);
		cqopage.getShipping_Update_Button().click();
		Thread.sleep(3000);
		webaction.scrollBy_value("0","1000");
		Thread.sleep(1000);
		cqopage.getPlace_Order_Button().click();
		Thread.sleep(3000);
		
		
		Thread.sleep(5000);
		String suc_message = sosucmsg.getSuccess_message().getText();
		System.out.println(suc_message);
		Thread.sleep(5000);
		
		String SO_ID= suc_message.replaceAll("[^0-9]", "");
		System.out.println(SO_ID);
		
		Thread.sleep(5000);
		String Thanks_message = sosucmsg.getThankyou_message().getText();
		System.out.println(Thanks_message);
		
		Thread.sleep(2000);
		Reporter.log(suc_message,true);
		if(sosucmsg.getSuccess_message().isDisplayed())
		{
			Reporter.log("Step:1 Sales Order Created Successfully",true);
		}
		else
		{
			Reporter.log("Step:1 Sales Order is UNSUCCESSFUL",true);
		}
		
		Thread.sleep(1000);
		getting_started.getUser_logo().click();
		Thread.sleep(1000);
		getting_started.getLogout_button().click();
		Thread.sleep(3000);
		//===========================================OK OK OK===============================================================
		//Procurement Login
		login_page.getLogin_app(filclass.readPropertyData(PROP_PATH, "procure_username"),filclass.readPropertyData(PROP_PATH, "procure_password"));
		Thread.sleep(3000);
		login_page.getLogin_button().click();
		Thread.sleep(3000);
		
		//================UI MIS CATCH ISSUE======================
		
		getting_started.getOrder_button().click();
		Thread.sleep(1000);
		getting_started.getSalesorder_button().click();
		Thread.sleep(1000);
		//Enter SO ID in Procurement level
		sopage.getso_order_id().sendKeys("SO_ID");
		Thread.sleep(1000);
		sopage.getso_search_button().click();
		Thread.sleep(1000);
		sopage.getfirst_so_id().click();
		Thread.sleep(2000);
		//SO Procurement Approval
		
		Thread.sleep(2000);
		soapproval.getLogistic_details().click();
		Thread.sleep(2000);
		soapproval.getVerification_status().click();
		Thread.sleep(2000);
		webaction.select_dd_by_value(soapproval.getVerification_status(),"11");
		Thread.sleep(5000);
		//Enter SO ID Finance level
		login_page.getLogin_app(filclass.readPropertyData(PROP_PATH, "finance_username"),filclass.readPropertyData(PROP_PATH, "finance_password"));
		Thread.sleep(5000);
		sopage.getso_order_id().sendKeys("SO_ID");
		Thread.sleep(3000);
		sopage.getso_search_button().click();
		Thread.sleep(3000);
		sopage.getfirst_so_id().click();
		Thread.sleep(2000);
		//SO Finance Approval
		soapproval.getLogistic_details().click();
		Thread.sleep(2000);
		soapproval.getVerification_status().click();
		Thread.sleep(2000);
		webaction.select_dd_by_value(soapproval.getVerification_status(),"9");
		Thread.sleep(5000);
		soapproval.getApproval_submit().click();	
	
}

}
