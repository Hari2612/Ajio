package ajio.screens;

import java.util.List;

import org.openqa.selenium.By;

import appium.utils.Capabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends Capabilities{
	protected AppiumDriver<MobileElement> driver;
	
	public void InitializeDriver() throws Exception {
		InitializeCapabilities();
		this.driver = new AndroidDriver<MobileElement>( caps);

	}
	
	public void ClickHome() {
		driver.findElement(By.id("com.ril.ajio:id/icon_ajio_tab")).click();
	}
	
	
	public void ClickCollections() {
		driver.findElement(By.id("com.ril.ajio:id/icon_capsule_tab")).click();
	}
	
	public void ClickCloset() {
		driver.findElement(By.id("com.ril.ajio:id/icon_closet_tab")).click();

	}
	
	public void ClickBag() {
		driver.findElement(By.id("com.ril.ajio:id/icon_cart_tab")).click();

	}
	
	public void ClickAccount() {
		driver.findElement(By.id("com.ril.ajio:id/icon_account_tab")).click();

	}
	
	public void ClickNotification() {
		driver.findElement(By.id("com.ril.ajio:id/notification_menu")).click();

	}
	
	public void Back() {
		driver.findElement(By.xpath("//*[@content-desc = 'Navigate up']")).click();

	}
	
	
	public void Changecategory() {
		driver.findElement(By.id("com.ril.ajio:id/actionbar_category_image")).click();
	}
	
	public void ClickCategory(String s ) throws Exception {
		
		List<MobileElement> elements = driver.findElements(By.id("com.ril.ajio:id/home_category_name"));
		for(MobileElement element : elements) {
			if(element.getAttribute("text").equals(s)) {
				element.click();
				break;
			}
			Thread.sleep(2000);
		}
	}
	
	

}
