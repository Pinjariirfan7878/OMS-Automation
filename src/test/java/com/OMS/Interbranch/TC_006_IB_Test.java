package com.OMS.Interbranch;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepo.Create_Inter_Branch_Shipment_OMS_Medikabazaar_Page;
import com.ObjectRepo.Enabled_Products_OMS_Medikabazaar_Page;
import com.ObjectRepo.Getting_Started_OMS_MedikabazaarPage;
import com.ObjectRepo.Inter_Branch_Orders_OMS_Medikabazaar_Page;
import com.ObjectRepo.Logistic_Detail_OMS_Medikabazaar_Page;
import com.ObjectRepo.Update_Finance_Details_OMS_Medikabazaar_Page;
import com.oms.GenericLib.BaseUtilityClass;
import com.oms.GenericLib.WebdriverActionclass;

public class TC_006_IB_Test extends BaseUtilityClass{
	
	@Test
	public void Create_Interbranch_Test() throws InterruptedException
	{
	Getting_Started_OMS_MedikabazaarPage getting_started = new Getting_Started_OMS_MedikabazaarPage(driver);
	Inter_Branch_Orders_OMS_Medikabazaar_Page inter_branch_orders = new Inter_Branch_Orders_OMS_Medikabazaar_Page(driver);
	Create_Inter_Branch_Shipment_OMS_Medikabazaar_Page create_inter_branch_shipment = new Create_Inter_Branch_Shipment_OMS_Medikabazaar_Page(driver);
	Enabled_Products_OMS_Medikabazaar_Page enabled_products = new Enabled_Products_OMS_Medikabazaar_Page(driver);
	Logistic_Detail_OMS_Medikabazaar_Page logistic_detail = new Logistic_Detail_OMS_Medikabazaar_Page(driver);
	Update_Finance_Details_OMS_Medikabazaar_Page update_finance_details = new Update_Finance_Details_OMS_Medikabazaar_Page(driver);
	WebdriverActionclass webaction=new WebdriverActionclass(driver);
	
	getting_started.getOrder_button().click();
	getting_started.getinterbranch_tab().click();
	Thread.sleep(1000);
	inter_branch_orders.getPurchase_tab().click();
	Thread.sleep(1000);
	create_inter_branch_shipment.getSource_Warehouse_dd().click();
	
	Thread.sleep(1000);
	webaction.select_dd_by_value(create_inter_branch_shipment.getSource_Warehouse_dd(),"32");
	create_inter_branch_shipment.getDestination_Warehouse_dd().click();
	Thread.sleep(1000);
	webaction.select_dd_by_value(create_inter_branch_shipment.getDestination_Warehouse_dd(),"17");
	create_inter_branch_shipment.getRecipient_Email_Label().clear();
	Thread.sleep(4000);
	create_inter_branch_shipment.getRecipient_Email_Label().sendKeys("karri.nanajee@medikabazaar.com");
	Thread.sleep(2000);
	create_inter_branch_shipment.getIB_submit_button().click();

	create_inter_branch_shipment.getSuccess_Message_Display().getText();
	System.out.println(create_inter_branch_shipment.getSuccess_Message_Display().getText());
	
	if(create_inter_branch_shipment.getSuccess_Message_Display().isDisplayed())
	{
		Reporter.log("Step:1 Inter Branch Order Information Updated Successfully and Verification Passed",true);
	}
	else
	{
		Reporter.log("Step:1 Inter Branch Order Information  Not Updated and Verification Failed",true);
	}
	
	Thread.sleep(1000);
	create_inter_branch_shipment.getProduct_List_button().click();
	Thread.sleep(1000);
	enabled_products.getProduct_List_search_Label().sendKeys("MedO741");
	Thread.sleep(15000);
	webaction.scrollBy_value("0","1500");
	Thread.sleep(10000);
	enabled_products.getCheck_Box().click();
	Thread.sleep(5000);
	enabled_products.getQty_to_add_Label().clear();
	Thread.sleep(1000);
	enabled_products.getQty_to_add_Label().sendKeys("1");
	Thread.sleep(1000);
	webaction.scrollBy_value("0","-1000");
	Thread.sleep(1000);
	enabled_products.add_to_IB_button().click();
	Thread.sleep(5000);
	webaction.scrollBy_value("0","1000");
	Thread.sleep(2000);
	//Save
	create_inter_branch_shipment.getIB_Save_button().click();
	Thread.sleep(2000);
	//Create
	create_inter_branch_shipment.getIB_Create_button().click();
	Thread.sleep(5000);
	inter_branch_orders.getIB_Created_Suc_Msg().getText();
	System.out.println(inter_branch_orders.getIB_Created_Suc_Msg());
	
	if(inter_branch_orders.getIB_Created_Suc_Msg().isDisplayed())
	{
		Reporter.log("Step:2 Inter Branch Order Created Successfully and Verification Passed",true);
	}
	else
	{
		Reporter.log("Step:2 Inter Branch Order Not Created and Verification Failed",true);
	}

	inter_branch_orders.getRecipient_Email_Label().sendKeys("karri.nanajee@medikabazaar.com");
	Thread.sleep(1000);
	inter_branch_orders.getSubmit_button().click();
	Thread.sleep(1000);
	inter_branch_orders.getIB_ID_field().click();
	Thread.sleep(1000);
	logistic_detail.getCourier_Type_dd().click();
	webaction.select_dd_by_value(logistic_detail.getCourier_Type_dd(),"2");
	Thread.sleep(1000);
	logistic_detail.getGST_Available_dd().click();
	webaction.select_dd_by_value(logistic_detail.getGST_Available_dd(),"Yes");
	Thread.sleep(1000);
	logistic_detail.getEst_TAT_Label().sendKeys("5");
	logistic_detail.getDistance_Label().sendKeys("100");
	logistic_detail.getDatepicker_Label().sendKeys(Keys.ENTER);
	logistic_detail.getOrder_Status_dd().click();
	Thread.sleep(1000);
	webaction.select_dd_by_value(logistic_detail.getOrder_Status_dd(),"22");
	Thread.sleep(1000);
	logistic_detail.getComment_Label().sendKeys("IB Invoice Generated");
	logistic_detail.getGST_Invoice_No_Label().sendKeys("22AAAAA0000A1Z5");
	logistic_detail.getTransporter_Name_Label().sendKeys("Tata Logistics");
	logistic_detail.getLogistic_submit_button().click();
	Thread.sleep(1000);
	logistic_detail.getupdate_finance_info_button().click();
	Thread.sleep(1000);
	update_finance_details.getInvoice_Number_Label().sendKeys("23456576");
	update_finance_details.getInvoice_Date_label().sendKeys(Keys.ENTER);

	update_finance_details.getInvoice_Attachmente_label().sendKeys("C:\\Users\\karri.nanajee\\Desktop\\dummy.pdf");
	update_finance_details.geteway_Bill_No_label().sendKeys("8546846");
	update_finance_details.getSave_button().click();
	Thread.sleep(1000);
	update_finance_details.getBack_button().click();
	Thread.sleep(1000);
	logistic_detail.getOrder_Status_dd().click();
	Thread.sleep(1000);
	webaction.select_dd_by_value(logistic_detail.getOrder_Status_dd(),"1");
	logistic_detail.getComment_Label().sendKeys("Dispatched Successfully");
	Thread.sleep(1000);
	logistic_detail.getLogistic_submit_button().click();
	Thread.sleep(1000);
	logistic_detail.getOrder_Status_dd().click();
	Thread.sleep(1000);
	webaction.select_dd_by_value(logistic_detail.getOrder_Status_dd(),"2");
	logistic_detail.getComment_Label().sendKeys("Delivered Successfully");
	Thread.sleep(1000);
	logistic_detail.getLogistic_submit_button().click();
	logistic_detail.getComment_Label().sendKeys("Inward Successfully");
	Thread.sleep(1000);
	webaction.scrollBy_value("0","500");
	Thread.sleep(1000);
	logistic_detail.getSelect_All().click();
	logistic_detail.getInward_Stock_button().click();
	Thread.sleep(1000);
	logistic_detail.getInwarded_Successfully_Message().getText();
	System.out.println(logistic_detail.getInwarded_Successfully_Message().getText());
	Thread.sleep(1000);
	System.out.println("The Automation Testing On Inter Branch Module Is Done Successfully");

}

}
