package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageobjectRepository {

	
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwdTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	
	public LoginPageobjectRepository(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String un){//whatever argument we will provide in this method as an input it well send that same value/arguments to that specific field.
		unTB.sendKeys(un);//utilizing private element(unTB) here within a method.
		}
	
	public void setPassword(String pwd){//setPassword(String pwd):This is the setter/set() of Java(Encapsulation concept).
		pwdTB.sendKeys(pwd);
	}
	
	public void clickLogin(){
			loginBtn.click();
		
		}
}
