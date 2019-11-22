import org.junit.Test;

public class Test1 {

	 @Test
	public void test1() {
		if (mMultiply(10, 30) == 300) {
			System.out.println("Pass");
		}

		else {
			System.out.println("Fail");
		}
	}

	 
	 @Test
		public void test2() {
			if (madd(10, 30) == 40) {
				System.out.println("Pass");
			}

			else {
				System.out.println("Fail");
			}
		}
	 
	 @Test
		public void test3() {
			if (mdivide(10, 30) == 300) {
				System.out.println("Pass");
			}

			else {
				System.out.println("Fail");
			}
		}
	// Multiply
	public int mMultiply(int x, int y) {
		return x * y;
	}

	// Add
	public int madd(int x, int y) {
		return x + y;
	}

	// Divide
	public double mdivide(int x, int y) {
		return x / y;
	}

}
