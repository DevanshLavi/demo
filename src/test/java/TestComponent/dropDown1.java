package TestComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDown1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		//click 4 times adult + button
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while( i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();//2 adult
			
               i++;
			}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.close();
		
				
	}

}
