package generic;

public interface IAutoConstant {

	//here we are giving the path for config.properties, excel sheet, gecko driver and chrome driver in this project and all these are constants here)
	String CONFIG_PATH=".\\config.properties";
	String EXCEL_PATH=".\\testdata\\data.xlsx";
	
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VALUE=".\\driver\\geckodriver.exe";
	
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE=".\\driver\\chromedriver.exe";
}
