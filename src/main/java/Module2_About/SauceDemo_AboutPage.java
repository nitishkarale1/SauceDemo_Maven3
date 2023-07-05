package Module2_About;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemo_AboutPage 
{
	@FindBy(xpath="//span[text()='Solutions']") public WebElement Solutions;
	@FindBy(xpath="//span[text()='Visual testing']") private WebElement VisualTesting;
	
	Actions act;
	
	public SauceDemo_AboutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void handleSauceDemo_AboutPageDropdown(WebDriver driver)
	{
		act=new Actions(driver);
		act.moveToElement(Solutions).perform();
	}
	
	public void clickSauceDemo_AboutPageVTLink()
	{
		act.click(VisualTesting).perform();
	}
}
