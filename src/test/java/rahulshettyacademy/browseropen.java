package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browseropen {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("rai.brijendra@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("span[jsname='V67aGc']")).click();
		//JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", element);
		
		
	
		
	}

}
