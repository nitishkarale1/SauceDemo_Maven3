package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemo_Open_MenuPage
{
	@FindBy(xpath="//a[text()='About']") private WebElement About;
	@FindBy(xpath="//a[text()='Logout']") private WebElement logoutBTN;
	
	public SauceDemo_Open_MenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSauceDemo_AboutPageAboutbtn()
	{
		About.click();
	}
	
	
	public void clickSauceDemo_LogOutPageLogoutBtn()
	{
		logoutBTN.click();
	}
}
