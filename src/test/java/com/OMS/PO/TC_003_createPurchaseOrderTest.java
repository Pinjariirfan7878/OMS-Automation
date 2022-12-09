package com.OMS.PO;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.Create_PO_OMS_MedikabazaarPage;
import com.ObjectRepo.Getting_Started_OMS_MedikabazaarPage;
import com.ObjectRepo.Purchase_Order_OMS_MedikabazaarPage;
import com.oms.GenericLib.BaseUtilityClass;
import com.oms.GenericLib.FileLibClass;
import com.oms.GenericLib.WebdriverActionclass;
//@Listeners(com.oms.GenericLib.MylistenerClass.class)

public class TC_003_createPurchaseOrderTest extends BaseUtilityClass {

	@Test
	public void purchase_order_ErrorFlow() throws Exception{

		Getting_Started_OMS_MedikabazaarPage homepage=new Getting_Started_OMS_MedikabazaarPage(driver);
		Purchase_Order_OMS_MedikabazaarPage puchase_order=new Purchase_Order_OMS_MedikabazaarPage(driver);
		Create_PO_OMS_MedikabazaarPage create_PO_page=new Create_PO_OMS_MedikabazaarPage(driver);
		WebdriverActionclass webaction=new WebdriverActionclass(driver);
		FileLibClass filclass=new FileLibClass();


		Reporter.log("Test Case Id: XXXXXX",true);
		homepage.getPurchase_tab().click();
		homepage.getPurchase_order_option().click();
		puchase_order.getCreate_Purchase_Order_button().click();
	
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
	}
}
