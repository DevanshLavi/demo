package TestComponent;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseJava {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String[] items = { "Cucumber", "Brocolli" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String [] name = products.get(i).getText().split("-");
			String format=name[0].trim();
			// check whether name you extracted is present in array or not- convert array to
			// array list
			// convert array to arrayist for easy search as we have contain here
			
			List al= Arrays.asList(items);
			if(al.contains(format)) {

			//if (name.contains("Cucumber")) {

				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
				//div[@class='product-action']
				
			}

		}

	}

}
