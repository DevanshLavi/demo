import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
	    driver.findElement(By.cssSelector(".signInBtn")).click();
	     
	   
	    System.out.println(driver.findElement(By.cssSelector(".error")).getText());
	    driver.findElement(By.linkText("Forgot your password?")).click();
	    //Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rai");
	    driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rai.brijendra@gmail.com");
	    driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
	    driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("rai.brijendra@gmail.com");
	    driver.findElement(By.xpath("//form/input[3]")).sendKeys("9654411407");
	    driver.findElement(By.className("reset-pwd-btn")).click();
	    System.out.println(driver.findElement(By.className("infoMsg")).getText());
	    //driver.close();
	    
	    Actions a=new Actions(driver);
	    

	}

}
