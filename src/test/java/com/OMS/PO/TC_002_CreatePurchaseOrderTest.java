package com.OMS.PO;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.Create_PO_OMS_MedikabazaarPage;
import com.ObjectRepo.Getting_Started_OMS_MedikabazaarPage;
import com.ObjectRepo.PO_MasterModule_OMS_MedikabazaarPage;
import com.ObjectRepo.PO_OMS_MedikabazaarPage;
import com.ObjectRepo.Purchase_Order_OMS_MedikabazaarPage;
import com.ObjectRepo.loginPage;
import com.oms.GenericLib.BaseUtilityClass;
import com.oms.GenericLib.FileLibClass;
import com.oms.GenericLib.IAutoconstant;
import com.oms.GenericLib.RetryanalyserClass;
import com.oms.GenericLib.WebdriverActionclass;

//@Listeners(com.oms.GenericLib.MylistenerClass.class)
public class TC_002_CreatePurchaseOrderTest extends BaseUtilityClass {

	@Test(retryAnalyzer = RetryanalyserClass.class)	
	public void purchase_order_HappyFlow() throws Exception{
		
		Getting_Started_OMS_MedikabazaarPage homepage=new Getting_Started_OMS_MedikabazaarPage(driver);
		Purchase_Order_OMS_MedikabazaarPage puchase_order=new Purchase_Order_OMS_MedikabazaarPage(driver);
		Create_PO_OMS_MedikabazaarPage create_PO_page=new Create_PO_OMS_MedikabazaarPage(driver);
		WebdriverActionclass webaction=new WebdriverActionclass(driver);
		PO_OMS_MedikabazaarPage PO_created_page=new PO_OMS_MedikabazaarPage(driver);
		PO_MasterModule_OMS_MedikabazaarPage PO_master_page=new PO_MasterModule_OMS_MedikabazaarPage(driver);
		Purchase_Order_OMS_MedikabazaarPage purchase_order=new Purchase_Order_OMS_MedikabazaarPage(driver);
		FileLibClass filclass=new FileLibClass();
		
		
		System.out.println("From Github");
		Reporter.log("Test Case Id: XXXXXX",true);
		homepage.getPurchase_tab().click();
		homepage.getPurchase_order_option().click();
		puchase_order.getCreate_Purchase_Order_button().click();
		String supplier_email=filclass.readData_TestData("PO_Data",1,2);
		create_PO_page.getSupplier_email_textfield().sendKeys(supplier_email);
		create_PO_page.getSubmit_button().click();
		webaction.select_dd_by_index(create_PO_page.getPayment_terms_DD(),3);
		webaction.scrolldown_By_element(create_PO_page.getProduct_sku_textfield());
		String product_sku=filclass.readData_TestData("PO_Data",2,2);
		Thread.sleep(1000);
		create_PO_page.getProduct_sku_textfield().sendKeys(product_sku);
		Thread.sleep(500);
		webaction.scrollBy_value("0","-150");
		Thread.sleep(300);
		String PO_Qty=filclass.readData_TestData("PO_Data",9,2);
		create_PO_page.getQuantity_textfield().clear();
		create_PO_page.getQuantity_textfield().sendKeys(PO_Qty);
		create_PO_page.getAdd_product_button().click();
		Thread.sleep(2000);
		webaction.scrolldown_By_element(create_PO_page.getProduct_sku_textfield());
		String HSN_Code=filclass.readData_TestData("PO_Data",3,2);
		Thread.sleep(1000);
		create_PO_page.getHSN_Code_textfield().sendKeys(HSN_Code);
		create_PO_page.getFirstIteam_check_box().click();
		create_PO_page.getUpdate_cart_button().click();
		webaction.scrollBy_bottom();
		Thread.sleep(4000);
		String shipping_charge=filclass.readData_TestData("PO_Data",4,2);
		create_PO_page.getShipping_charge_textfield().clear();
		create_PO_page.getShipping_charge_textfield().sendKeys(shipping_charge);
		create_PO_page.getShipping_update_button().click();
		webaction.scrollBy_bottom();
		Thread.sleep(500);
		create_PO_page.getCreate_purchase_order_button().click();
		webaction.alert_accept();
		Thread.sleep(2000);
		String PO_number = PO_created_page.getPO_ID().getText();
		Reporter.log(PO_number,true);
		if(PO_created_page.getConfirm_img().isDisplayed())
		{
			Reporter.log("Step:1 P.O Created Successfully And Verification Passed ",true);
		}
		else
		{
			Reporter.log("Step:1 P.O is not created Verification Failed",true);
		}
		
		webaction.screenshot("P.O Created","PO");
		Thread.sleep(500);
		Thread.sleep(2000);
		homepage.getUser_logo().click();
		Thread.sleep(400);
		homepage.getLogout_button().click();
		Thread.sleep(500);
		loginPage log_page=new loginPage(driver);
		log_page.getLogin_app(filclass.readPropertyData(PROP_PATH,"procure_username"),filclass.readPropertyData(PROP_PATH, "procure_password"));
		webaction.maximumWindow();
		webaction.implicitlywait();
		homepage.getPurchase_tab().click();
		homepage.getPurchase_order_option().click();
		Thread.sleep(500);
		purchase_order.getPO_master_item_bucket().click();
		Thread.sleep(500);
		String prepareByDD=filclass.readData_TestData("PO_Data",6,2);
		purchase_order.getPrepared_by_dd().sendKeys(prepareByDD,Keys.ENTER);
		purchase_order.getSearch_button().click();
		Thread.sleep(500);
		purchase_order.getFirst_PO_Id().click();
		Thread.sleep(1000);

		
		
		
		
		
		
		
		
		
		
	
//		PO_created_page.getView_PO_details().click();
//		Thread.sleep(1000);
		webaction.select_dd_by_value(PO_master_page.getVerification_status_dd(),"13");
		String comment_textfield=filclass.readData_TestData("PO_Data",5,2);
		PO_master_page.getComment_textfield().sendKeys(comment_textfield);
		PO_master_page.getSumbit_button().click();	
		Thread.sleep(500);
		PO_master_page.getPO_status_and_comment_bucket().click();
		Thread.sleep(500);
		if(PO_master_page.getProcure_approved_text().isDisplayed())
		{
			Reporter.log("Step:2 P.O Approved By Procurement And Verify Passed ",true);	
		}
		else
		{
			Reporter.log("Step:2 P.O is Not Approve By Procurement And Verify Failed ",true);
		}
		webaction.screenshot("Procure Approved","PO");
		Thread.sleep(2000);
		homepage.getUser_logo().click();
		Thread.sleep(400);
		homepage.getLogout_button().click();
		Thread.sleep(500);
	//	loginPage log_page=new loginPage(driver);
		log_page.getLogin_app(filclass.readPropertyData(PROP_PATH,"finance_username"),filclass.readPropertyData(PROP_PATH, "finance_password"));
		webaction.maximumWindow();
		webaction.implicitlywait();
		homepage.getPurchase_tab().click();
		homepage.getPurchase_order_option().click();
		Thread.sleep(500);
		purchase_order.getPO_master_item_bucket().click();
		Thread.sleep(500);
	//	String prepareByDD=filclass.readData_TestData("PO_Data",6,2);
		purchase_order.getPrepared_by_dd().sendKeys(prepareByDD,Keys.ENTER);
		purchase_order.getSearch_button().click();
		Thread.sleep(500);
		purchase_order.getFirst_PO_Id().click();
		Thread.sleep(1000);
		webaction.select_dd_by_value(PO_master_page.getVerification_status_dd(),"9");
		PO_master_page.getComment_textfield().sendKeys(comment_textfield);
		PO_master_page.getSumbit_button().click();
		Thread.sleep(500);
		PO_master_page.getPO_status_and_comment_bucket().click();
		Thread.sleep(500);
		if(PO_master_page.getFinance_approve_text().isDisplayed())
		{
			Reporter.log("Step:3 P.O Approved By Finance And Verify Passed ",true);	
		}
		else
		{
			Reporter.log("Step:3 P.O is Not Approve By Finance And Verify Failed  ",true);
		}
		webaction.screenshot("Finance Approved","PO");
		Thread.sleep(2000);
		homepage.getUser_logo().click();
		Thread.sleep(400);
		homepage.getLogout_button().click();
		Thread.sleep(500);
		log_page.getLogin_app(filclass.readPropertyData(PROP_PATH, "Username"),filclass.readPropertyData(PROP_PATH, "Password"));
		webaction.maximumWindow();
		webaction.implicitlywait();
        homepage.getPurchase_tab().click();
        homepage.getPurchase_order_option().click();
        Thread.sleep(400);
        puchase_order.getPO_master_item_bucket().click();
        Thread.sleep(500);
        purchase_order.getPrepared_by_dd().sendKeys(prepareByDD,Keys.ENTER);
		purchase_order.getSearch_button().click();
		Thread.sleep(500);
		purchase_order.getFirst_PO_Id().click();
		Thread.sleep(500);
		webaction.scrollBy_value("0","500");
        Thread.sleep(500);
		String invoice_number=filclass.readData_TestData("PO_Data",7,2);
		String invoice_amount=filclass.readData_TestData("PO_Data",8,2);
		PO_master_page.getQa_check_box().click();
		PO_master_page.getInvoice_number_textfield().sendKeys(invoice_number);
		PO_master_page.getInvoice_amount_textfield().clear();
		PO_master_page.getInvoice_amount_textfield().sendKeys(invoice_amount);
		String pdf=IAutoconstant.Pdf_dummy;
		PO_master_page.getInvoice_attachment_textfield().sendKeys(pdf);
		webaction.scrollBy_value("0","500");
		Thread.sleep(400);
		PO_master_page.getSelect_all_checkbox().click();
		PO_master_page.getSumbit_button().click();
		webaction.alert_accept();
		Thread.sleep(500);
		webaction.scrollBy_value("0","500");
		Thread.sleep(300);
		PO_master_page.getSumbit_button().click();
		Thread.sleep(2000);
		PO_master_page.getPO_inward_history_bucket().click();
		Thread.sleep(1000);
		if(PO_master_page.getAccepet_order_text().isDisplayed())
		{
			Reporter.log("Step:4 Stock Inwarded Successfully And Verify Passed ",true);
		}
		else
		{
			Reporter.log("Step:4 Stock Inward is Not Done and Verify Failed ",true);

		}
		String PO_Number = PO_master_page.getPO_number().getText();
		String GRN_Number=PO_master_page.getGRN_number().getText();
		Reporter.log("PO ID : "+PO_Number+" GRN number : "+GRN_Number,true);
		webaction.screenshot("Stock Inwarded & GRN No","PO");
	}
}

