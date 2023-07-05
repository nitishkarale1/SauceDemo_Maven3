package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemo_HomePage
{
	@FindBy(xpath="//span[text()='Products']") private WebElement Products;
	@FindBy(xpath="//button[text()='Open Menu']") private WebElement OpenMenu;
	@FindBy(xpath="(//img[@class='inventory_item_img'])[1]") private WebElement productImage;
	
	public SauceDemo_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyProductsText()
	{
		String act_Text = Products.getText();
		return act_Text;
	}
	
	public boolean verifySauceDemo_HomePageProductImage()
	{
		boolean result=productImage.isDisplayed();
		return result;
	}
	
	public void clickSauceDemo_HomePageOpenMenu() 
	{
		OpenMenu.click();
	}
	
}
