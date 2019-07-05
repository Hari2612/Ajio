package appium.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.remote.DesiredCapabilities;

import ajio.utils.ExcelDetails;
import ajio.utils.Reading_From_TextFile;



public class Capabilities {
	protected DesiredCapabilities caps = new DesiredCapabilities();
	public void InitializeCapabilities() throws Exception {
		  String fileName = "C:\\Farmrise\\webp\\src\\test\\java\\com\\Appium\\property.txt"; 
		  FileReader fr = new FileReader(fileName);
		  BufferedReader br = new BufferedReader(fr);
		  Reading_From_TextFile obj = new Reading_From_TextFile();
		  ExcelDetails obj1 = new ExcelDetails();
		  String[] str = obj.read(br);
	  
	//Set the Desired Capabilities
		  for(int i=0;i <4;i++)
			  System.out.println(str[i]);
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", str[0]); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", str[1]);
		caps.setCapability("appPackage", str[2]);
		caps.setCapability("appActivity", str[3]);
		caps.setCapability("noReset", "true");

		return;
}
}
