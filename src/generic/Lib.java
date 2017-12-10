package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Lib implements IAutoConstant{

	
	public static Workbook wb;
	public static String getProperty(String CONFIG_PATH, String Key){
		String property="";
		Properties prop=new Properties();
		try{
			prop.load(new FileInputStream(CONFIG_PATH));
			property =prop.getProperty(Key);
		}
		catch (Exception e) {
		
		}
		
		
		return property;
	}
	public static int getRowCount(String EXCEL_PATH, String sheet){
		int rowCount=0;
		try{
		Workbook wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		rowCount=wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) {
	
		}
		return rowCount;
	}
	
	public static String getCellValue(String EXCEL_PATH, String sheet, int row, int column){
		
		String value="";
	
		try{
			wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			value=wb.getSheet(sheet).getRow(row).getCell(column).toString();
			}
			catch (Exception e) {
				
			}
			return value;
		}
	}
	
	
	
	
	
	
	
	
	
	
