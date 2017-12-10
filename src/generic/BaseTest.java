package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{

	public static WebDriver driver;
	
	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@BeforeMethod
	public void openApplication(){
		driver=new FirefoxDriver();
		
		String url=Lib.getProperty(CONFIG_PATH, "URL");//From config.properties file access the key "URL" from its path "CONFIG_PATH".
		driver.get(url);
		
		String ITO=Lib.getProperty(CONFIG_PATH, "ImplicitTimeOut");//From config.properties file access the key "ImplicitTimeOut" from its path "CONFIG_PATH".
		int timeoutperiod=Integer.parseInt(ITO);// As the ImplicitTimeOut wii return int but here it will store in string variable (string representation of int) then change it to int by using parseInt().
		
		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);//Passing the variable here where the timeout time stored i.e.10(which we define in config.properties file)
		
	}
	
	@AfterMethod
	public void closeApplication(){
		driver.close();
	}
	
	public void takeScreenshot(String actualtmethodfail){//passing the value as argument under this method
		Date d=new Date();
		String currentdate=d.toString().replace(":", "_");//giving the timestamp
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(".\\Screenshots\\"+currentdate+"\\"+actualtmethodfail+"_screenshot.png");//format in which we want to show the failed testcases will visible.
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
