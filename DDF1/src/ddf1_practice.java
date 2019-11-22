import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ddf1_practice {
WebDriver myDriver;
String vHomevalue, vDownpay, vLoanAmt, vIRate;
String expMonthlypayment, myMonthlypayment;
	
@Before
public void mybefore() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
	
	myDriver = new ChromeDriver();
	myDriver.navigate().to("https://www.mortgagecalculator.org/");
	myDriver.manage().window().maximize();
	
	
	expMonthlypayment = "$1,715.58";
	 vHomevalue ="412000";
	 vDownpay = "112000";
	 vLoanAmt= "300000";
	 vIRate = "4";
}


@Test
public void myTest(){
	myDriver.findElement(By.name("param[homevalue]")).sendKeys(vHomevalue);
	myDriver.findElement(By.name("param[downpayment]")).sendKeys( vDownpay);
	myDriver.findElement(By.id("loanamt")).sendKeys(vLoanAmt);
	myDriver.findElement(By.name("param[interest_rate]")).sendKeys(vIRate);
	
	// Calculate the value
	myDriver.findElement(By.name("cal")).click();
	myMonthlypayment = myDriver.findElement(By.xpath("(//h3)[2]")).getText();
	
	System.out.println(" My monthly payment is " + myMonthlypayment);
	System.out.println(" My expected expanses are " + expMonthlypayment);
	
	if(myMonthlypayment.equals(expMonthlypayment)) {
		System.out.println(" My test is pass ");
	}
	else {
		System.out.println("My test is fail ");
	}
	

}

@After
public void myAfter() {
	System.out.println("Test Ended");
	//myDriver.close();
	//myDriver.quit();
	
}
}
