package newPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gmail {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://gmail.com");
		driver.findElement(By.id("Email")).sendKeys("saurav.amca@gmail.com");
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).sendKeys("Saurav@1234");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.name("Shine.com"));
		
	}

}
