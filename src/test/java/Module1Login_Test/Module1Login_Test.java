package Module1Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import LibraryFiles.Base_Class;
import LibraryFiles.Utility_Class;
import Module1Login.SauceDemo_HomePage;
import Module1Login.SauceDemo_LoginPage;
import Module1Login.SauceDemo_Open_MenuPage;
import Module2_About.SauceDemo_AboutPage;
import Module2_About.SauceDemo_VisualTestingPage;

public class Module1Login_Test extends Base_Class
{
	SauceDemo_LoginPage login;
	SauceDemo_HomePage home;
	SauceDemo_AboutPage abt;
	SauceDemo_Open_MenuPage openMenu;
	SauceDemo_VisualTestingPage vt;
	int TCID;
	
	@Parameters("BrowserName")
	@BeforeClass
	public void openBrowser(String BrowserName) throws IOException
	{
		initializeBrowser(BrowserName);
		
		login=new SauceDemo_LoginPage(driver);
		home=new SauceDemo_HomePage(driver);
		abt=new SauceDemo_AboutPage(driver);
		openMenu=new SauceDemo_Open_MenuPage(driver);
		vt=new SauceDemo_VisualTestingPage(driver);
		
	}
	
	@BeforeMethod
	public void LoginToApp() throws IOException
	{
		login.inpSauceDemo_LoginPageUN(Utility_Class.getPFdata("UserName"));
		login.inpSauceDemo_LoginPagePWD(Utility_Class.getPFdata("Password"));
		login.clickSauceDemo_LoginPageLoginBTN();
	}
	
	@Test(priority=1)
	public void verifyText() throws EncryptedDocumentException, IOException
	{
		String act_text=home.verifyProductsText();
		Cell cellInfo = Utility_Class.getTD(0, 0);
		String exp_text=cellInfo.getStringCellValue();
		Assert.assertEquals(act_text, exp_text, "Failed: both texts are different ");
	}
	
	@Test(priority=2)
	public void verifyImage() throws EncryptedDocumentException, IOException
	{
		boolean act_result=home.verifySauceDemo_HomePageProductImage();
		Cell cellInfo=Utility_Class.getTD(0, 2);
		boolean exp_result=cellInfo.getBooleanCellValue();
		Assert.assertEquals(act_result, exp_result, "Failed: both results are different");
	}
	
	@AfterMethod
	public void LogutFromApp(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureSS(driver, TCID);
		}
	
		home.clickSauceDemo_HomePageOpenMenu();
		openMenu.clickSauceDemo_LogOutPageLogoutBtn();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	
}
