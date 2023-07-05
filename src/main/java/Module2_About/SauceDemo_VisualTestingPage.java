package Module2_About;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemo_VisualTestingPage
{
	@FindBy(xpath="//h2[contains(text(),'Deliver apps')]") private  WebElement Text;
	
	public SauceDemo_VisualTestingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyText()
	{
		String act_text=Text.getText();
		return act_text;
	}

}
