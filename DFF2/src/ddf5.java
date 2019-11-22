import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ddf5 {
	WebDriver myDriver;
	String expMontlyPayment, myMonthlyPayment;
	String  vExecute, vHomevalue, vDownpay, vLoanAmt, vIRate;
	String[][] xTD;
	String xlPath, xlSheet;
	String xlPath_Res;
	int xlRows;
	
	@Before
	public void myBefore() throws Exception {
		//prepare Test
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\Selenium\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		 
		 //Read the Test Data Excel into a 2D array.
		 xlPath = "C:\\Selenium\\DDF2.xls";
		 xlSheet = "TestData";
		 xTD = readXL(xlPath, xlSheet );
		 
		 xlPath_Res = "C:\\Selenium\\DDF2_Res.xls";

		 
		xlRows = xTD.length; //Get number of rows
		System.out.println(" Rows are: " + xlRows);


		}
	
	@Test 
	public void mytest() {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Test is Starting Here ~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// i++; // Increment by 1
		// i= i+1; // Increment by 1
		
		//Go to each row in Test Data
			for(int i=1; i<xlRows; i++) {
			
		//check Execute flag
			vExecute = xTD[i][0];
			if(vExecute.equalsIgnoreCase("Y")) {
				
				System.out.println("Running the TDID:" + xTD[i][1]);
				//Get the TD into local variable
				vHomevalue = xTD[i][2];
				vDownpay = xTD[i][3];
				vLoanAmt= xTD[i][4];
				vIRate = xTD[i][5];
				expMontlyPayment = xTD[i][6];
				
				//putData
				putData();
				
				//compareResult
				xTD[i][8]= compareResult();
				xTD[i][7] = myMonthlyPayment;
				//Update the Actual and Result column in the 2D Array
				// Write the Result back into the Excel.
			}
			else {
				System.out.println("Skinpping the TDID:" +xTD[i][1]);
			}
			
		}
	
	}
		
		
	
	
	@After
	public void myafter() throws Exception {
		writeXL(xlPath_Res, "TestResult", xTD);
		System.out.println(" Closing the browser.	 ");
		myDriver.quit();
	}
	
	public void putData() {
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

	public String compareResult() {
		String fResult;
		myMonthlyPayment = "None"; //Default value
		
		myMonthlyPayment = myDriver.findElement(By.xpath("(//h3)[2]")).getText();
		
		
		System.out.println("Actual Monthly Payment is " + myMonthlyPayment);
		System.out.println("Expected Monthly payment is " + expMontlyPayment);
		
		//Condition for Mortgage Calculator
		if(myMonthlyPayment.equals(expMontlyPayment))
		{
			System.out.println("Test Pass");
			fResult = "Pass";
		}
		else {
			System.out.println("Test Failed");
			fResult = "Fail";
		}
		return fResult;
		
	}
	
	//*********************************** Utility Function**************************
	public static String[][] readXL(String fPath, String fSheet) throws Exception{
		//Input: XL Path and XL Sheet name.
		//output:
		String[][] xData;
		int xRows, xCols;
		DataFormatter dataFormatter = new DataFormatter();
		String cellValue;
		
		//Get the worksheet
		File myxl = new File(fPath);
		FileInputStream myStream = new FileInputStream(myxl);
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myWB.getSheet(fSheet);
		
		//Count rows and Columns. Create empty 2D array.
		xRows = mySheet.getLastRowNum()+1;
		xCols = mySheet.getRow(0).getLastCellNum();
		xData = new String[xRows][xCols];
		System.out.println("rows: " + xRows);
		System.out.println("Column: " + xCols);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~ Test Data Below ~~~~~~~~~~~~~~~~~~~~~~");
		for(int i=0; i<xRows; i++ ) {
			HSSFRow row = mySheet.getRow(i);
			for(int j =0; j<xCols; j++ ){
				cellValue= "-";
				cellValue = dataFormatter.formatCellValue(row.getCell(j));
				if(cellValue!=null) {
					xData[i][j] = cellValue;
				}
				System.out.print(cellValue);
				System.out.print("||||");

				
			}
			System.out.println("");

			
		}
		
		myxl = null;
		return xData;
			
		}
	
	public static void writeXL(String fPath, String fSheet, String[][] xData) throws Exception{
	
		File outFile = new File(fPath);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet osheet = wb.createSheet(fSheet);
		int xR_TS = xData.length;
		int xC_TS = xData[0].length;
		
		for(int myrow=0; myrow<xR_TS; myrow++ ) {
			HSSFRow row = osheet.createRow(myrow);	
			for(int mycol =0; mycol < xC_TS; mycol++ ){
				HSSFCell cell = row.createCell(mycol);	
				//cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(xData[myrow][mycol]);
				}
			FileOutputStream fOut = new FileOutputStream(outFile);
			wb.write(fOut);
			fOut.flush();
			fOut.close();
				
			}
		wb = null;
		osheet = null;
		}
	}

	


	