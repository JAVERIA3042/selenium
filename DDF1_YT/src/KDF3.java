import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class KDF3 {
	WebDriver myD;
	
	@Ignore
	@Test
	public void myTest1() throws Exception {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test1 Started~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		openBrowser("Chrome");
		navigateBrowser("https://www.youtube.com/");
		typeText("All about the frameworks","//input[@id='search']");
		clickElement("//button[@id='search-icon-legacy']");
		Thread.sleep(2000);
		verifyText("http://www.itelearn.com/ All About Automation Frameworks A free session by ITeLearn.com 0. What is Test automation. Why do we ...","//*[@id='description-text']");
		closeBrowser();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test1 Ended~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
	}
	
	@Test
	public void myTest2() throws Exception {
		try {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test2 Started~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			openBrowser("Chrome");
			navigateBrowser("https://www.youtube.com/");
			typeText("All about the Frameworks","//input[@id='search']");
			clickElement("//button[@id='search-icon-legacy']");
			Thread.sleep(2000);
			verifyText("Blah Blah1 ","//*[@id='description-text']");
			verifyText("Blah Blah2", "(//*[@id='description-text'])[2]");
			verifyText("Blah Blah3", "(//*[@id='description-text'])[3]");
			closeBrowser();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test2 Ended~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" Test Run without any issues ");

		}catch(Exception e) {
			System.out.println(" Error is : " + e);
		}
	}

	//Keyword Functions	
	public void openBrowser(String fTD){
		// Open Browser
		// I/P: TD (Browser Name)
		// O/P: NUll		
		if(fTD.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
			myD = new ChromeDriver();
		} else if(fTD.equals("Edge")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
			myD = new EdgeDriver();
		} else if(fTD.equals("IE")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
			myD = new InternetExplorerDriver();
		} else if(fTD.equals("FF")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
			myD = new FirefoxDriver();
		}
		myD.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		myD.manage().window().maximize();
	}

	public void navigateBrowser (String fTD) {
		// Naviagte the Browser
		// I/P: TD (Browser Name)
		// O/P: NUll
		myD.navigate().to(fTD);
		
	}
	public void typeText(String fTD, String fEID) {
		// Type into Text Field
		// I/P: TD (what to type), EID (Where to type)
		// O/P: NUll
		// Selenium WebDriver setup
		myD.findElement(By.xpath(fEID)).sendKeys(fTD);
	}
	public void clickElement (String fEID) {
		// Click on my Element
		// I/P: TD (where to click)
		// O/P: Nill
		myD.findElement(By.xpath(fEID)).click();
		
	}
	public void verifyText (String fTD,String fEID) {
		// verify Text in an element
		// I/P: TD (what text we are expecting), EID (where to get the text from)
		// O/P: Nill
		String fAcualText;
		fAcualText = myD.findElement(By.xpath(fEID)).getText();
		
		System.out.println("Actual text is " + fAcualText );
		System.out.println("Expexted Text is " + fTD);
		if(fAcualText.equals(fTD)) {
			System.out.println("Text matched");
		}
		else {
			System.out.println("Text DID NOT Matched");
		}
	}
	public void closeBrowser() {
		// Close the Browser
		// I/P: Nill
		// O/P: Nill
		myD.close();
		
	}
	
}
