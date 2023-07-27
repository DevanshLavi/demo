package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahilshettyacademy.AbsttactComponent.AbstactComponent;

public class ProductCatalog extends AbstactComponent {
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> product=driver.findElements(By.cssSelector(".mb-3"));
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productBy=By.cssSelector(".mb-3");
	By toastMessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName) 
	
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		waitForElementToAppear(toastMessage);
		waitForElementToDissappear(spinner);
			
		
		
	
	}
			
			
		

	


}
