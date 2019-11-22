import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class tc1JUnit2 {
	
	@Before
	public void myBefore(){
		System.out.println("Before");
		
	}

	@Test
	public void myTest1(){
		System.out.println("Test1");
		
	}
	
	@Test
	public void myTest2(){
		System.out.println("Test2");
		
	}
	
	@After
	public void myAfterTest(){
		System.out.println("After Test");
	}
}