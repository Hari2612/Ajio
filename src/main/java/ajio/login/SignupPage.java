package ajio.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import appium.utils.Capabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SignupPage extends Capabilities{
	
protected AppiumDriver<MobileElement> driver;
	
	public void InitializeDriver() throws Exception {
		InitializeCapabilities();
		this.driver = new AndroidDriver<MobileElement>( caps);

	}
	
	public void ClickAccount() {
		driver.findElement(By.id("com.ril.ajio:id/icon_account_tab")).click();
		 System.out.println("Account Verified");

	}
	
	
	public boolean CheckAccount() {
		try {
			 if(driver.findElement(By.id("com.ril.ajio:id/signin_bt_myact")).isDisplayed())
				 return true;
		}catch(Exception e) {
			return 	false;		
		}
		return false;
	}
	
	
	public void ClickSignup() {
		driver.findElement(By.id("com.ril.ajio:id/signin_bt_myact")).click();
		 System.out.println("signup Verified");
	}
	
	public void EnterMobileNo(String s) throws Exception {
		driver.findElement(By.id("com.ril.ajio:id/et_login_mobilenumber_emailid")).sendKeys(s);
		((AndroidDriver<MobileElement>) driver).pressKeyCode(66);
		 System.out.println("Mobile Verified");
		 Thread.sleep(3000);
	}
	
	public void ClickLoginWithOTP() throws Exception {
		Thread.sleep(5000);
		List<MobileElement> elements = driver.findElements(By.id("com.ril.ajio:id/loginpassword_btn_login"));
		for(MobileElement element : elements) {
			if(element.getAttribute("text").contains("LOGIN WITH OTP")) {
				element.click();
				break;
			}
		}
		 System.out.println("OTP Verified");
		Thread.sleep(10000);
		
	}
	
	public boolean VerifyLoginDetails() {
		String a = driver.findElement(By.id("com.ril.ajio:id/tv_signinotp_existinguser_email")).getAttribute("text");
		if(!a.equals("har***********@gmail.com") ) {
			return false;
			
		}
		a = driver.findElement(By.id("com.ril.ajio:id/tv_signinotp_existinguser_mobile")).getAttribute("text");
		if(!a.equals("70XXXXX059") ) {
			return false;
			
		}
		return true;
		
	}
	
	
	public void ClickStartShopping() throws Exception {
		while(driver.findElement(By.id("com.ril.ajio:id/et_otp")).getAttribute("text").equals("Detecting OTP"));
		driver.findElement(By.id("com.ril.ajio:id/btn_signinotp_startshopping")).click();
		 System.out.println("Start shopping Verified");
		 Thread.sleep(5000);
	}
	
	public boolean VerifyAccountDetails() throws Exception {
		String a = driver.findElement(By.id("com.ril.ajio:id/user_name")).getAttribute("text");
		if(!a.equals("Hari") ) {
			return false;
			
		}
		a = driver.findElement(By.id("com.ril.ajio:id/user_email")).getAttribute("text");
		if(!a.equals("hariveeranki66@gmail.com") ) {
			return false;
			
		}
		a = driver.findElement(By.id("com.ril.ajio:id/user_phone_no")).getAttribute("text");
		if(!a.equals("7013802059") ) {
			return false;
			
		}
		
		return true;
		
	}
}
