
public class functionBasic2 {

	//Declare variable
	static int a, b, c, d;
	static int e;
	public static void main(String[] args) {
		
		
		//Initialize variable
		//Round 1
		a = 12;
		b = 13;
		c = 24;
		addNumber();
		
		//Initialize variable
		//Round 2
		
		addNumber2(20,30,30);
		
		//Initialize variable
		//Round 3
		addNumber2(10,40,35);
		
		//Initialize variable
		//Round 4
		addNumber2(35,40,35);
		
		//Initialize variable
		//Round 5
		addNumber2(30,40,70);
		
		//Initialize variable
		//Round 6
		e = addNumber3(12,13,24);
		e = e + 1;
		System.out.println(" e is " + e);
		
	}
		
		public static void addNumber() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		d = a + b;
		System.out.println("Varibale a is " + a);
		System.out.println("Variable b is " + b);
		System.out.println("Variable c is " + c);
		System.out.println("Variable d is " + d);
		
		if(c==d) {
			System.out.println("Result: Same");
		}
		else {
			System.out.println(" Result: Different");
		}
	}
		public static void addNumber2(int fA, int fB, int fC) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("function round 2");
			int fD = fA + fB;
			System.out.println("Varibale a is " + fA);
			System.out.println("Variable b is " + fB);
			System.out.println("Variable c is " + fC);
			System.out.println("Variable d is " + fD);
			
			if(fC==fD) {
				System.out.println("Result: Same");
			}
			else {
				System.out.println(" Result: Different");
			}
		}
		
		public static int addNumber3(int fA, int fB, int fC) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("function round 3");
			int fD = fA + fB;
			System.out.println("Varibale a is " + fA);
			System.out.println("Variable b is " + fB);
			System.out.println("Variable c is " + fC);
			System.out.println("Variable d is " + fD);
			
			if(fC==fD) {
				System.out.println("Result: Same");
			}
			else {
				System.out.println(" Result: Different");
			}
			return fD;
		}
}

