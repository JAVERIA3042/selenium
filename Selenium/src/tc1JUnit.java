import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tc1JUnit {

	public static void main(String[] args) {
		
		//prepare Test
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("https://swiggy.com/");
		
		//Run Test
		myDriver.findElement(By.linkText("Login")).click();
		myDriver.findElement(By.id("mobile")).sendKeys("1234567777");
		//myDriver.findElement(By.id("password")).sendKeys("asdasdasd");
		
		
		//Clean Test
		myDriver.close();
		myDriver.quit();


	}

}
