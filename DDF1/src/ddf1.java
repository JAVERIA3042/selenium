 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ddf1 {
	WebDriver myDriver;
	String expMontlyPayment, myMonthlyPayment;
	String  vHomevalue, vDownpay, vLoanAmt, vIRate;
	
	
	@Before
	public void myBefore() {
		
		for(int i=0; i<5; i++) {
		System.out.println("Before Test is " + i);
		//prepare Test
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.navigate().to("https://www.mortgagecalculator.org/");
		myDriver.manage().window().maximize();
		
		 expMontlyPayment = "$1,915.58";
		 vHomevalue ="412000";
		 vDownpay = "112000";
		 vLoanAmt= "300000";
		 vIRate = "4";
		}
	}

	@Test 
	public void mytest() {

		myDriver.findElement(By.name("param[homevalue]")).sendKeys(vHomevalue);
		myDriver.findElement(By.name("param[downpayment]")).sendKeys(vDownpay);
		myDriver.findElement(By.id("loanamt")).sendKeys(vLoanAmt);
		myDriver.findElement(By.name("param[interest_rate]")).sendKeys(vIRate);
		
		
		//Calculate the Value
		myDriver.findElement(By.name("cal")).click();
		
		myMonthlyPayment = myDriver.findElement(By.xpath("(//h3)[2]")).getText();
		
		System.out.println("Actual Monthly Payment is " + myMonthlyPayment);
		System.out.println("Expected Monthly payment is " + expMontlyPayment);
		
		//Condition for Morgage Calculator
		if(myMonthlyPayment.equals(expMontlyPayment))
		{
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Failed");
		}

		}
	
	
	@After
	public void myafter() {
	
		System.out.println("My Test Successfully");
		//myDriver.close();
		//myDriver.quit();
	}

}
