package TestComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		//driver.findElement(By.xpath("//input[@value='Belagavi (IXG)']")).click();
		//a[@value='MAA']-chn
		//a[@value='BLR']-blr
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='BLR'][2]")).click();

	}

}
