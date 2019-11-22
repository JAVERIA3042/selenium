import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForec {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("username")).sendKeys("vdhghs");
		driver.findElement(By.id("password")).sendKeys("324135");
		Thread.sleep(2000);
		driver.findElement(By.id("Login")).click();
		System.out.println(driver.findElement(By.cssSelector("div[id='error']")).getText());
		
	
		
		
	}

}
