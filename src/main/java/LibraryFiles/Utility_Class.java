package LibraryFiles;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility_Class
{
	public static Cell getTD(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\sampleSheet.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet10");
		Cell value= sh.getRow(rowIndex).getCell(cellIndex);
		return value;
	}
	
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\propertyFile.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}
	
	public static void captureSS(WebDriver driver, int TCID) throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"\\ScreenShots");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
	}
	
}
