package TestComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDown {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Select dropdown-with select tag
		WebElement staticDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dp= new Select(staticDropdown);
		dp.selectByIndex(3);
		System.out.println(dp.getFirstSelectedOption().getText());
		dp.selectByVisibleText("AED");
		System.out.println(dp.getFirstSelectedOption().getText());
		dp.selectByValue("INR");
		System.out.println(dp.getFirstSelectedOption().getText());
		
	}

}
