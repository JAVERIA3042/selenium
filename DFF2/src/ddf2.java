import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ddf2 {
	WebDriver myDriver;
	String expMontlyPayment, myMonthlyPayment;
	String  vHomevalue, vDownpay, vLoanAmt, vIRate;
	
	
	@Before
	public void myBefore() {
	
		//prepare Test
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		
		 expMontlyPayment = "$1,915.58";
		 vHomevalue ="412000";
		 vDownpay = "112000";
		 vLoanAmt= "300000";
		 vIRate = "5.2";
		}
	
	@Test 
	public void mytest() {
		
		for(int i=1; i<5; i = i+1) {
		System.out.println("Running Test # " + i);
		putData(i);
		compareResult();
		}
		}
	
	
	@After
	public void myafter() {
	
		myDriver.quit();
	}
	
	public void putData(int fI) {
		
		vIRate = String.valueOf(fI);
		
		//Got AUT
		myDriver.navigate().to("https://www.mortgagecalculator.org/");

		//Enter i/p value
		myDriver.findElement(By.name("param[homevalue]")).clear();
		myDriver.findElement(By.name("param[homevalue]")).sendKeys(vHomevalue);
		
		myDriver.findElement(By.name("param[downpayment]")).clear();
		myDriver.findElement(By.name("param[downpayment]")).sendKeys(vDownpay);
		
		myDriver.findElement(By.id("loanamt")).clear();
		myDriver.findElement(By.id("loanamt")).sendKeys(vLoanAmt);
		
		myDriver.findElement(By.name("param[interest_rate]")).clear();
		myDriver.findElement(By.name("param[interest_rate]")).sendKeys(vIRate);
		
		//Calculate the Value
		myDriver.findElement(By.name("cal")).click();
		
	}

	public void compareResult() {
			
		myMonthlyPayment = myDriver.findElement(By.xpath("(//h3)[2]")).getText();
		
		
		System.out.println("Actual Monthly Payment is " + myMonthlyPayment);
		System.out.println("Expected Monthly payment is " + expMontlyPayment);
		
		//Condition for Mortgage Calculator
		if(myMonthlyPayment.equals(expMontlyPayment))
		{
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Failed");
		}
		
	}
	
	//read from XL
	// write from XL
}
