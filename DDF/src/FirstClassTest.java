import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class FirstClassTest {
	 
	 public static void main(String[] args) throws Exception {
		
	 // Create a new instance of the Firefox driver
	 WebDriver driver = new FirefoxDriver();
	 
	        //Launch the Online Store Website
	 driver.get("http://google.com");
	 
	        // Print a Log In message to the screen
	        System.out.println("Successfully opened the website www.google.com");
	 
	    }
}
