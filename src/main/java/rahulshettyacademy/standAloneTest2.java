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

public class standAloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage lp=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("rai.brijendra@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shilpi@15");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		for(int i=0;i<products.size();i++) {
			
			String name=products.get(i).getText();
			if(name.contains("ZARA")) {
				
				driver.findElements(By.xpath("//button[text()=' Add To Cart']")).get(i).click();
				
				System.out.println("product found");
			
			}
		
			else {
				
				System.out.println();
			}
		}
		
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().contentEquals("ZARA COAT 3"));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	Actions a=new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	//india selected in dropdown
	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	Thread.sleep(10);
	//click on place order
	js.executeScript("window.scrollBy(0,1000)");
	boolean placeorder=driver.findElement(By.cssSelector(".action__submit")).isEnabled();
	System.out.println(placeorder);
	
	WebElement element=driver.findElement(By.cssSelector(".action__submit"));
	js.executeScript("arguments[0].click();", element);
	
	//Confirm page and get the message
	String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	System.out.println(confirmMessage);
	Assert.assertEquals(confirmMessage,  "THANKYOU FOR THE ORDER." );
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	

	
	}

}
