import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ddf2_Sample {
	WebDriver myDriver;
	
	@Before
	public void myBefore(){
		System.out.println("Before");
		//prepare Test
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.navigate().to("https://swiggy.com/");
	}

	@Test
	public void myTest1(){
		System.out.println("Test1");
		//Run Test
		myDriver.findElement(By.linkText("Login")).click();
		myDriver.findElement(By.id("mobile")).sendKeys("1234567777");
		//myDriver.findElement(By.id("password")).sendKeys("asdasdasd");
		
	}
	@Test
	public void myTest2(){
		System.out.println("Test2");
		//Run Test
		myDriver.findElement(By.linkText("Login")).click();
		myDriver.findElement(By.id("mobile")).sendKeys("1234567777");
		//myDriver.findElement(By.id("password")).sendKeys("asdasdasd");
	}
	
	
	@After
	public void myAfterTest(){
		System.out.println("After Test");
		//Clean Test
		myDriver.close();
		myDriver.quit();

	}
}