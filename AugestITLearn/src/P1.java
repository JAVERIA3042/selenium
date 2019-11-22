import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1 {
	WebDriver myDriver;
	
	@Before
	public void mybefore(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	myDriver = new ChromeDriver();
	myDriver.navigate().to("https://www.mortgagecalculator.org/");
	myDriver.manage().window().maximize();
}
	
	
}