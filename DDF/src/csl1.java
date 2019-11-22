
import com.thoughtworks.selenium.*;
import org.junit.Test;

public class csl1 extends SeleneseTestCase {
	
	//@SuppressWarnings("deprecation")
	public void setUp() throws  Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://chasestudent loans.com/");
		selenium.start();
		
	}
	
		@Test
	public void testCsl1() throws Exception {
		selenium.open("/");
		selenium.click("link=Budget calculator");
		selenium.waitForPageToLoad("15000");
		selenium.type("//input[@type='text' and @name= 'tuition']", "400");
		selenium.type("tuition" , "350");
		selenium.type("food" , "200");
		selenium.type("creditcards", "400");
		selenium.type("job" , "550");
		selenium.type("grants" , "350");
		selenium.click("//input[@class='calcbutton1']");
		//String vExp = selenium.getvalue("totexp");
		//System.out.println("Expense total is " + vExp);
		//String vInc = selenium.getvalue("totInc");
		//System.out.println("Income total is " + vInc);
		String vLoan = selenium.getValue("balance");
		System.out.println("Loan required is" + vLoan);
		String vText = selenium.getText("//html/body/form/div/div[3]/div/div/div/h2");
		System.out.println(vText);		
		
	}
	
	public void tearDown() throws Exception {
		selenium.stop();
	}
	

}
 