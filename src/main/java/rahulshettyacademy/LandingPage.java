package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahilshettyacademy.AbsttactComponent.AbstactComponent;

public class LandingPage extends AbstactComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		//sending driver from child to parent class by super keyword
		super(driver);
		// getting driver from standalonetest.java class via creating the object and once object created constructor will call
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	public ProductCatalog loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalog productCatalog=new ProductCatalog(driver);
		return productCatalog;
		
	}
	
	public void goTo()
	
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	


}
