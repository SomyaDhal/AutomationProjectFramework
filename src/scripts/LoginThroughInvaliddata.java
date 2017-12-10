package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPageobjectRepository;

public class LoginThroughInvaliddata extends BaseTest{

	
	@Test
	public void testInvalidlogin() throws InterruptedException{
	LoginPageobjectRepository plr=new LoginPageobjectRepository(driver);
	
	int rowCount=Lib.getRowCount(EXCEL_PATH, "Invalid Login");//comment
	System.out.println(rowCount);
	
	for (int i = 1; i <= rowCount; i++) {
	String un=	Lib.getCellValue(EXCEL_PATH, "Invalid Login",i , 0);
	String pwd=Lib.getCellValue(EXCEL_PATH, "Invalid Login", i, 1);
	
	plr.setUsername(un);
	plr.setPassword(pwd);
	
	plr.clickLogin();
	Thread.sleep(2000);
		
		
	}
	
	}
	
	
	
	
	
}
