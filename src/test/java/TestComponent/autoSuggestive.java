package TestComponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Auto Suggestive
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		Thread.sleep(1000);
		int i=0;
		for(i=1;i<=options.size();i++) {
			
			System.out.println(options.get(i).getText());
		}
		for(WebElement option:options){
			if (option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				
			}
			
			
		}
				

	}

}
