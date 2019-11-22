import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ddf1_YT {
	static WebDriver myDriver;
	public static void main(String[] args) throws Exception {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test Started~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		// Setup the webdriver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	
		// Open the Browser	and Maximize the Browser	
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		
		// Go to AUT	https://www.youtube.com/	
		myDriver.navigate().to("https://www.youtube.com/");
		Thread.sleep(1000);
		
		// Type into Search Field	 All about the Framework	//input[@id='search']
		myDriver.findElement(By.xpath("//input[@id='search']")).sendKeys("All about the Framework");
		Thread.sleep(1000);
		
		// Click Search icon	-	//button[@id='search-icon-legacy']
		myDriver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();		
		Thread.sleep(1000);
		
		// Verify 1st Result - //a[@id='video-title']
		System.out.println(" Text is " + myDriver.findElement(By.xpath("//*[@id='description-text']")).getText());
		myDriver.findElement(By.xpath("//*[@id='description-text']")).click();
		Thread.sleep(1000);
		
		myDriver.close();
		myDriver.quit();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test Ended~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		// YT_search_002_viewResult
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test Started~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		// Go to AUT	https://www.youtube.com/	
		myDriver.navigate().to("https://www.youtube.com/");
		Thread.sleep(1000);
				
		// Type into Search Field	 All about the Framework	//input[@id='search']
		myDriver.findElement(By.xpath("//input[@id='search']")).sendKeys("All about the Framework");
		Thread.sleep(1000);
				
		// Click Search icon	-	//button[@id='search-icon-legacy']
		myDriver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();		
		Thread.sleep(1000);
				
		// Verify 1st Result - //a[@id='video-title']
		System.out.println(" Text is " + myDriver.findElement(By.xpath("//*[@id='description-text']")).getText());
		System.out.println(" Text is " + myDriver.findElement(By.xpath("(//*[@id='description-text'])/[2]")).getText());
		System.out.println(" Text is " + myDriver.findElement(By.xpath("(//*[@id='description-text'])/[3]")).getText());
		//myDriver.findElement(By.xpath("//*[@id='description-text']")).click();
		Thread.sleep(1000);
				
		myDriver.close();
		myDriver.quit();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test Ended~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
