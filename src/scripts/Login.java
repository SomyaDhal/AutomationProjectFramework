package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPageobjectRepository;

public class Login extends BaseTest {
	
	
	@Test
	public void testLogin() throws InterruptedException{
		LoginPageobjectRepository lp=new LoginPageobjectRepository(driver);
		String un=Lib.getCellValue(EXCEL_PATH, "Valid Login", 1, 0);
		String pw=Lib.getCellValue(EXCEL_PATH, "Valid Login", 1, 1);
		String expectedTitle=Lib.getCellValue(EXCEL_PATH, "Valid Login", 1, 2);
		
		
		lp.setUsername(un);
		lp.setPassword(pw);
		lp.clickLogin();
		Thread.sleep(2000);
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualTitle, expectedTitle);
		s.assertAll();
	}
	
}
