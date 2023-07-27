package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        String productName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		ProductCatalog productCatalog=landingPage.loginApplication("rai.brijendra@gmail.com", "Shilpi@15");
		List<WebElement> products=productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		productCatalog.goToCartPage();
		CartPage cartPage=new CartPage(driver);
		boolean match=cartPage.veryfyProductDisplay(productName);
		Assert.assertTrue(match);
		cartPage.goToCheckout();
		CheckOutPage checkOut=new CheckOutPage(driver);
		checkOut.selectCountry("India");
		ConfirmationPage confirmationPage=checkOut.submitOrder();
		String confirmMessage=confirmationPage.getConfirmationMessage();
		System.out.println(confirmMessage);
		Assert.assertEquals(confirmMessage,  "THANKYOU FOR THE ORDER." );
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	


	

	
	}

}
