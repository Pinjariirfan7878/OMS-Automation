package com.OMS.Return_To_Supplier;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepo.Getting_Started_OMS_MedikabazaarPage;
import com.ObjectRepo.Product_List_OMS_Medikabazaar_RTS_Page;
import com.ObjectRepo.Return_to_Supplier_List_OMS_Medikabazaar_Page;
import com.ObjectRepo.Return_to_Supplier_OMS_Medikabazaar_Page;
import com.ObjectRepo.Update_Finance_Details_OMS_Medikabazaar_Page;
import com.oms.GenericLib.BaseUtilityClass;
import com.oms.GenericLib.WebdriverActionclass;

public class TC_001_RTS_Test extends BaseUtilityClass  {
	
	@Test
	public void return_to_supplier() throws InterruptedException
	{
		Getting_Started_OMS_MedikabazaarPage getting_started = new Getting_Started_OMS_MedikabazaarPage(driver);
		Return_to_Supplier_List_OMS_Medikabazaar_Page return_to_supplier_list = new Return_to_Supplier_List_OMS_Medikabazaar_Page(driver);
		Return_to_Supplier_OMS_Medikabazaar_Page return_to_supplier_oms = new Return_to_Supplier_OMS_Medikabazaar_Page(driver);
		WebdriverActionclass webaction=new WebdriverActionclass(driver);
		Product_List_OMS_Medikabazaar_RTS_Page product_list = new Product_List_OMS_Medikabazaar_RTS_Page(driver);
		Update_Finance_Details_OMS_Medikabazaar_Page update_finance = new Update_Finance_Details_OMS_Medikabazaar_Page(driver);
		
		getting_started.getPurchase_tab().click();
		Thread.sleep(1000);
		getting_started.getReturn_to_supplier_button().click();
		Thread.sleep(1000);
		return_to_supplier_list.getCreate_RTS_button().click();
		return_to_supplier_oms.getWarehouse_dd().click();
		webaction.select_dd_by_value(return_to_supplier_oms.getWarehouse_dd(),"32");
		return_to_supplier_oms.getSupplier_dd().click();
		Thread.sleep(1000);
		return_to_supplier_oms.getsupplier_search().sendKeys("knseller1@gmail.com");
		Thread.sleep(1000);
		return_to_supplier_oms.getsupplier_search().sendKeys(Keys.ENTER);
		return_to_supplier_oms.getCourier_type_dd().click();
		webaction.select_dd_by_value(return_to_supplier_oms.getCourier_type_dd(),"2");
		return_to_supplier_oms.getEst_tat().clear();
		return_to_supplier_oms.getEst_tat().sendKeys("5");
		Thread.sleep(1000);
		return_to_supplier_oms.getgst_Label().click();
		webaction.select_dd_by_value(return_to_supplier_oms.getgst_Label(),"Yes");
		Thread.sleep(1000);
		return_to_supplier_oms.getDistance_Label().clear();
		return_to_supplier_oms.getDistance_Label().sendKeys("100");
		return_to_supplier_oms.getTransporter_name().clear();
		return_to_supplier_oms.getTransporter_name().sendKeys("TATA Logistics");
		return_to_supplier_oms.getGST_num().clear();
		return_to_supplier_oms.getGST_num().sendKeys("22AAAAA0000A1Z5");
		return_to_supplier_oms.getComment().clear();
		return_to_supplier_oms.getComment().sendKeys("Processing Return To Supplier");
		return_to_supplier_oms.getUpdate_button().click();
		Thread.sleep(3000);
		/*webaction.scrollBy_value("0", "1500");
		Thread.sleep(1000);
		return_to_supplier_oms.getAdd_Product_button().click();
		Thread.sleep(3000);
		product_list.getSelect_Product_Checkbox().click();
		product_list.getpro_qty_Field().clear();
		product_list.getpro_qty_Field().sendKeys("1");
		product_list.getadd_to_RTS_cart().click();
		Thread.sleep(3000);
		webaction.scrollBy_value("0", "1800");
		Thread.sleep(2000);
		return_to_supplier_oms.getCreate_RTS_button().click();
		Thread.sleep(2000);
		return_to_supplier_list.getRTS_created_suc_message().getText();
		System.out.println(return_to_supplier_list.getRTS_created_suc_message().getText());
		if(return_to_supplier_list.getRTS_created_suc_message().isDisplayed())
		{
			Reporter.log("Step:1 Return To Supplier Created Successfully and Verification Passed ",true);
		}
		else
		{
			Reporter.log("Step:1 Return To Supplier Not Created and Verification Failed",true);
		}
		
		return_to_supplier_list.getSearch_RTS_ID_button().click();
		Thread.sleep(2000);
		return_to_supplier_list.getselect_RTS_ID().click();
		Thread.sleep(1000);
		return_to_supplier_oms.getDebit_Note_Num().sendKeys("DNN12345");
		Thread.sleep(1000);
		return_to_supplier_oms.getDebit_Note_Date().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		return_to_supplier_oms.getDebit_Note_Attachment().sendKeys("C:\\Users\\karri.nanajee\\Desktop\\dummy.pdf");
		return_to_supplier_oms.getApproval_Status().click();
		Thread.sleep(1000);
		webaction.select_dd_by_value(return_to_supplier_oms.getApproval_Status(),"approved");
		Thread.sleep(1000);
		return_to_supplier_oms.getApproval_Comment().sendKeys("Approved by K Nanajee");
		Thread.sleep(1000);
		webaction.scrollBy_value("0", "2000");
		Thread.sleep(1000);
		return_to_supplier_oms.getUpdate_button().click();
		Thread.sleep(3000);
		if(return_to_supplier_oms.getPending_Button().isDisplayed())
		{
			Reporter.log("Step:2 Return To Supplier Is Updated and Verification Passed ",true);
		}
		else
		{
			Reporter.log("Step:2 Return To Supplier Details Is Not Updated and Verification Failed",true);
		}
		webaction.scrollBy_value("0", "2000");
		Thread.sleep(1000);
		return_to_supplier_oms.getUdate_Tally_Info().click();
		Thread.sleep(1000);
		update_finance.getInvoice_Number_Label().sendKeys("23456576");
		Thread.sleep(1000);
		update_finance.getInvoice_Date_label().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		update_finance.getInvoice_Attachmente_label().sendKeys("C:\\Users\\karri.nanajee\\Desktop\\dummy.pdf");
		Thread.sleep(1000);
		update_finance.geteway_Bill_No_label().sendKeys("8546846");
		Thread.sleep(1000);
		update_finance.getSave_button().click();
		Thread.sleep(1000);
		update_finance.getBack_button().click();
		Thread.sleep(1000);
		if(return_to_supplier_oms.getApprove_Green().isDisplayed())
		{
			Reporter.log("Step:3 Return To Supplier Is Approved and Verification Passed",true);
		}
		else
		{
			Reporter.log("Step:3 Return To Supplier Is Not Approved and Verification Failed",true);
		}*/
	}
}
