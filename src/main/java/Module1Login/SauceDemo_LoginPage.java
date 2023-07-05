package Module1Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryFiles.Utility_Class;

public class SauceDemo_LoginPage
{
	@FindBy(xpath="//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath="//input[@id='password']") private WebElement PWD;
	@FindBy(xpath="//input[@id='login-button']") private WebElement LoginBTN;
	
	public SauceDemo_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpSauceDemo_LoginPageUN(String UserName) throws IOException
	{
		UN.sendKeys(Utility_Class.getPFdata("UserName"));
	}
	
	public void inpSauceDemo_LoginPagePWD(String PassWord) throws IOException
	{
		PWD.sendKeys(Utility_Class.getPFdata("Password"));
	}
	
	public void clickSauceDemo_LoginPageLoginBTN()
	{
		LoginBTN.click();
	}
	
}
