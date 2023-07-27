package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahilshettyacademy.AbsttactComponent.AbstactComponent;

public class CartPage extends AbstactComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver){
		//sending driver from child to parent class by super keyword
		super(driver);
		// getting driver from standalonetest.java class via creating the object and once object created constructor will call
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	//List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	public 	Boolean veryfyProductDisplay(String productName)
	{
		Boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().contentEquals("ZARA COAT 3"));
		
		return match;
	}
	

	
	
	public void goToCheckout()
	
	{
		checkoutEle.click();
	
	}
	
	
	Actions a=new Actions(driver);
	a
	
	


}
