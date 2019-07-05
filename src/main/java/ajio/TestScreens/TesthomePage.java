package ajio.TestScreens;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import ajio.screens.HomePage;
import ajio.utils.ExcelDetails;
import appium.utils.AppiumServerJava;


public class TesthomePage extends HomePage {
	
	public boolean verifyText(String s) {
		String m = driver.findElement(By.id("com.ril.ajio:id/toolbar_title")).getText();
		if(m.contains(s))	{
				System.out.println(s +" verified");
				return true;
		}
		else
			System.out.println("Failed" + m +" "+s);
			return false;
	}
	
	public boolean VerifyCategory(String s) {
		String m = driver.findElement(By.id("com.ril.ajio:id/bt_toolbar_category")).getText();
		if(m.contains(s))	{
				System.out.println(s +" verified");
				return true;

		}
		else
			System.out.println("Failed" + m +" "+s);
			return false;

	}
	
	
	AppiumServerJava obj1;
  @Test
  public void f() throws Exception {
	  obj1 = new AppiumServerJava();
		obj1.startServer();
		//System.out.println("hurayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		Thread.sleep(2000);
		String[] ans = new String[9];
		String[] res = new String[9];
		InitializeDriver();
		Thread.sleep(5000);
		ClickHome();
		
		
		ClickCollections();
		
		if(verifyText("Collections")) {
			ans[0] = "Collections icon verified";
			res[0] = "Passed";
		}
		else {
			ans[0] = "Collections icon verification failed";
			res[0] = "Failed";
		}
		
		
		ClickCloset();
		if(verifyText("My Closet")) {
			ans[1] = "Closet icon verified";
			res[1] = "Passed";
		}
		else {
			ans[1] = "Closet icon verification failed";
			res[1] = "Failed";
		}

		
		ClickBag();
		if(verifyText("My Bag")) {
			ans[2] = "Bag icon verified";
			res[2] = "Passed";
		}
		else {
			ans[2] = "Bag icon verification failed";
			res[2] = "Failed";

		}
		Back();

		
		ClickAccount();
		if(verifyText("My Account")) {
			ans[3] = "Account icon verified";
			res[3] = "Passed";
		}
		else {
			ans[3] = "Account icon verification failed";
			res[3] = "Failed";

		}
		ClickHome();
		
		ClickNotification();
		if(verifyText("Notifications")) {
			ans[4] = "Notifications icon verified";
			res[4] = "Passed";
		}
		else {
			ans[4] = "Notifications icon verification failed";
			res[4] = "Failed";
		}
		Back();
		
		Changecategory();
		ClickCategory("Women");
		if(VerifyCategory("Women")) {
			ans[5] = "Women Category verified";
			res[5] = "Passed";
		}
		else {
			ans[5] = "Women Category verification failed";
			res[5] = "Failed";
		}
		
		Changecategory();
		ClickCategory("Kids");
		if(VerifyCategory("Kids")) {
			ans[6] = "Kids Category verified";
			res[6] = "Passed";
		}
		else {
			ans[6] = "Kids Category verification failed";
			res[6] = "Failed";
		}
		
		Changecategory();
		ClickCategory("Sale");
		if(VerifyCategory("Sale")) {
			ans[7] = "Sale Category verified";
			res[7] = "Passed";
		}else {
			ans[7] = "Sale Category verification failed";
			res[7] = "Failed";
		}
		Thread.sleep(1000);
		
		Changecategory();
		ClickCategory("Men");
		if(VerifyCategory("Men")) {
			ans[8] = "Men Category verified";
			res[8] = "Passed";
		}
		else {
			ans[8] = "Men Category verification failed";
			res[8] = "Failed";
		}
		
		
		ExcelDetails d = new ExcelDetails();
		  for(int i=0;i<ans.length;i++) {
			  System.out.println(ans[i]);
		  }
		  for(int i=0;i<ans.length;i++) {
			  System.out.println(res[i]);
		  }
		  d.writeExcel("C:\\Farmrise\\webp\\src\\test\\java\\com\\Appium", "Book1.xlsx", "Sheet1", ans,res,9 );
		 
		
		
  }
  @AfterTest
  public void g() {
	  obj1.stopServer();
  }
 
  
 
}
