package ajio.TestScreens;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import ajio.screens.MyBagPage;
import ajio.utils.ExcelDetails;
import appium.utils.AppiumServerJava;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class TestMyBag extends MyBagPage{
	AppiumServerJava obj1 = new AppiumServerJava();
  @SuppressWarnings("deprecation")
@Test
  public void f() throws Exception {
	                  
	  AppiumServerJava obj1 = new AppiumServerJava();
		obj1.startServer();
		
		Thread.sleep(2000);
		InitializeDriver();
		Thread.sleep(5000);
		ClickHome();
		ClickBag();
		
		String[] ans = new String[6];
		String[] res = new String[6];

		if(IsBagEmpty()) {
			System.out.println("Bag is Empty");
			ans[0] = "bag is Empty";
			res[0] = "Passed";
			driver.findElement(By.id("com.ril.ajio:id/btn_continue_shopping")).click();
			driver.findElement(By.id("com.ril.ajio:id/row_search_component_tv_search")).click();
			driver.findElement(By.id("com.ril.ajio:id/search_src_text")).sendKeys("Sneakers for men");
			((AndroidDriver<MobileElement>) driver).pressKeyCode(66);
			Thread.sleep(4000);
			while(!IsItemFound())
			verticalSwipeByPercentages();
			
			ans[1] = "Item Found";
			res[1] = "Passed";
			if(VerifyItemDetails()) {
				System.out.println("verified Item Details");
				ans[2] = "Item Verificafied";
				res[2] = "Passed";
				AddToCart();
				ViewBag();
				
				if(VerifyItemDetailsInBag()) {
					ans[3] = "Item Verified after adding to bag";
					res[3] = "Passed";
					ProceedToShipping();
					ans[4] = "Proceeded to shipping";
					res[4] = "Passed";
					Thread.sleep(1000);
					ProceedToPayment();
					ans[5] = "Proceeded to payment";
					res[5] = "Passed";
					System.out.println("verification completed");
				}
				else {
					ans[3] = "Item Verification failed after adding to bag";
					res[3] = "Failed";
					ans[4] = "failed Proceeding to shipping ";
					res[4] = "Failed"; 
					ans[5] = "failed Proceeding to payment ";
					res[5] = "Failed";
				}
			}
			else {
				ans[2] = "Item Verification failed";
				res[2] = "Failed";
				ans[3] = "Item Verification failed after adding to bag";
				res[3] = "Failed";
				
			}
			
			

		}	
		else {
			ans[0] = "bag is not Empty";
			res[0] = "Passed";
			ans[1] = "Item already in the bag";
			res[1] = "Passed";
			Back();
			String s1 = BagCount();
			System.out.println(s1);
			ClickBag();
			String s2 = ItemCount();
			System.out.println(s2);
			if(s2.contains(s1)) {
				System.out.println("Bag Count verified");
				Thread.sleep(2000);
				
						ans[2] = "Item already in bag";
						res[2] = "Passed";
						ans[3] = "Item already in bag";
						res[3] = "Passed";
						ProceedToShipping();
						ans[4] = "Proceeded to shipping";
						res[4] = "Passed";
						ProceedToPayment();
						ans[5] = "Proceeded to payment";
						res[5] = "Passed";
						
					}
				
			
		}
		
		 ExcelDetails d = new ExcelDetails();
		  for(int i=0;i<ans.length;i++) {
			  System.out.println(ans[i]);
		  }
		  for(int i=0;i<ans.length;i++) {
			  System.out.println(res[i]);
		  }
		  d.writeExcel("C:\\Farmrise\\webp\\src\\test\\java\\com\\Appium", "Book1.xlsx", "Sheet1", ans,res, 20);
		 
			
  }
  //Medium  = 17
  //Hard = 3
  //Easy = 41
  //Matrix = 80-85	
  //Tree = 146
  //BST = 46
  //Hepas= 20
  //Hashing = 127
  //Stack = 43
  //queue = 31
  //arrays = 150+
  //Graphs = 64
  //searching = 59
  //sorting -104
  @AfterTest
  public void g() {
	  obj1.stopServer();
  }
}
