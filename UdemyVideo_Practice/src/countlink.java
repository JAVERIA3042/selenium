import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class countlink {
static WebDriver driver;
	 public static void main(String[] args) throws Exception {
		 //1. Give me the count of the link on the page
		 //2. count of the footer section
		 //3. count the link of first table from footer section
		 //4. Click on each link in the coloumn and check if the page are opening
		 WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 //1. Give me the count of the link on the page
		int size = driver.findElements(By.tagName("a")).size();
		System.out.println(size);
		Thread.sleep(2000);
		
		//Limiting WebDriver Scope
		 //2. count of the footer section
		WebElement footer = driver.findElement(By.id("prefooter")); 
		System.out.println(footer.findElements(By.tagName("a")).size());	
		Thread.sleep(2000);
		
		 //3. count the link of first table from footer section
		WebElement link = footer.findElement(By.id("links"));
		System.out.println(link.findElements(By.tagName("a")).size());
		Thread.sleep(2000);
		
	 
		//4. Click on each link in the column and check if the page are opening
			for(int i=0; i<link.findElements(By.tagName("a")).size(); i++) {
				Thread.sleep(2000);
				String clickOnTabLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
				Thread.sleep(2000);
				link.findElements(By.tagName("a")).get(i).sendKeys(clickOnTabLink);
				Thread.sleep(5000L);	
				}
			
			//Getting the titles of child tabs  with optimized
			Set <String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			while (it.hasNext()) {
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
	 
	 }

}
