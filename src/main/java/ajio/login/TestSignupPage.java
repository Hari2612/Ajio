package ajio.login;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import ajio.utils.ExcelDetails;
import appium.utils.AppiumServerJava;

public class TestSignupPage extends SignupPage{
	 AppiumServerJava obj1;
  @Test
  public void f() throws Exception {
	   obj1 = new AppiumServerJava();
		obj1.startServer();
		
	  String[] ans = new String[5];
	  String[] res = new String[5];

	  InitializeDriver();
	  
	  ClickAccount();
	  if(CheckAccount()) {
	  ClickSignup();
	  EnterMobileNo("7013802059");
	  ans[0] = "Mobile Number Entered";
	  res[0] = "Passed";
	  ClickLoginWithOTP();
	  ans[1] = "Logging in with OTP";
	  res[1] = "Passed";
	  if(VerifyLoginDetails()) {
		  System.out.println("Login details Verified");
		  ans[2] = "Login details verified";
		  res[2] = "Passed";
	  }
	  else {
		  ans[2] = "Login details  verification failed";
		  res[2] = "failed";
	  }
	  ClickStartShopping();
	  ans[3] = "Signed in";
	  res[3] = "passed";
	  if(VerifyAccountDetails()) {
		  System.out.println("Account details Verified");
		  ans[4] = "Account details Verified";
		  res[4] = "passed";
	  }
	  else {
		  ans[4] = "Account details verification failed";
		  res[4] = "failed";
	  }
	  
	  }
	  else {
		  ans[0] = "Already Signed in";
		  ans[1] = "Already Signed in";
		  ans[2] = "Already Signed in";
		  ans[3] = "Already Signed in";
		  
		  res[0] = "passed";
		  res[1] = "passed";
		  res[2] = "passed";
		  res[3] = "passed";
		  
		  
		  if(VerifyAccountDetails()) {
			  System.out.println("Account details Verified");
			  ans[4] = "Account details Verified";
			  res[4] = "passed";
		  }
		  else {
			  ans[4] = "Account details verification failed";
			  res[4] = "failed";
		  }
		  
	  }
	  ExcelDetails d = new ExcelDetails();
	  for(int i=0;i<ans.length;i++) {
		  System.out.println(ans[i]);
	  }
	  for(int i=0;i<ans.length;i++) {
		  System.out.println(res[i]);
	  }
	  d.writeExcel("C:\\Farmrise\\webp\\src\\test\\java\\com\\Appium", "Book1.xlsx", "Sheet1", ans,res, 2);
	 
		
  }
  
  @AfterTest
  public void g() {
	  obj1.stopServer();
  }
 
}
