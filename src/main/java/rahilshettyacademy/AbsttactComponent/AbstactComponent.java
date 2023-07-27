package rahilshettyacademy.AbsttactComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.CartPage;

public class AbstactComponent {
	WebDriver driver;
	
	public AbstactComponent(WebDriver driver) {
		this.driver=driver;
	}

	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }
	
	public WebElement goToCartPage()
	{
		WebElement cart= driver.findElement(By.cssSelector("[routerlink*='cart']"));
		cart.click();
		return cart;
		
		
	}
	public void waitForElementToDissappear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));	
	}
	
}
