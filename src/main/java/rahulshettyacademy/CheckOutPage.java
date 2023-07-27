package rahulshettyacademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahilshettyacademy.AbsttactComponent.AbstactComponent;

public class CheckOutPage extends AbstactComponent {
	WebDriver driver;
	
	public  CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	@FindBy (css=".form-group input")
	WebElement country;
	
	@FindBy (css=".action__submit")
	WebElement submit;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	By result=By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		
		waitForElementToAppear(By.cssSelector(".ta-results"));
		//india selected in dropdown
		selectCountry.click();
				
	}
	
	public ConfirmationPage submitOrder() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		boolean placeorder=submit.isEnabled();
		System.out.println(placeorder);
		js.executeScript("arguments[0].click();", submit);
		return new ConfirmationPage(driver);
		
		
	}
	
}
