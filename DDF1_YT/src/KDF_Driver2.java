import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class KDF_Driver2 {
//Read the Excel sheet
//Understand the login
//Execute

static String[][] xTC, xTS;
static int xTC_R, xTS_R;
static String xlPath = "C:\\Users\\Javeria Khaliq\\eclipse-workspace\\EXCEl\\KDF5_YT_HardCoded.xls";
 static WebDriver myD;
public static void main(String[]args) throws Exception {
	String vTCID, vTC_Exe;
	String vTSID, vTS_StepNum, vKeyword, vData, vEID; 
	
	
	// 1. Read the i/p KDF Excel.	
	xTC = readXL(xlPath, "TestCases");
	xTS = readXL(xlPath, "TestSteps"); 
	
	xTC_R = xTC.length;
	xTS_R = xTS.length;
	
	System.out.println("Test Case Rows: " + xTC.length);
	System.out.println("Test steps Rows: " + xTS.length);
	
	
	// Identify Executable Test Cases
	for( int i=1 ; i<xTC_R ; i++) {
		System.out.println("********************TC Start***********************");
		vTCID = xTC[i][0];
		vTC_Exe = xTC[i][2];
		
		if(vTC_Exe.equals("Y")) {
			System.out.println("TCID Ready for execution :::: " + vTCID);
			
			// Go through each row in Test step sheet
			for(int j =1; j< xTS_R; j++) {
				vTSID = xTS[j][0];
				if(vTCID.equals(vTSID)) { // Execute only matching TCID
					System.out.println("********************TC Start***********************");
					
					vTSID = xTS[j][0];
					vTS_StepNum = xTS[j][1];
					vKeyword = xTS[j][3];
					vData = xTS[j][4];
					vEID = xTS[j][5];
					
					System.out.println("Step Number ::::" + vTS_StepNum);
					System.out.println("KW ::::" + vKeyword);
					System.out.println("Data ::::" + vData);
					System.out.println("EID ::::" + vEID);
					
					try {
					executeKW(vKeyword, vData, vEID);
					System.out.println("Step >>>>>>>>>>>Pass");

					}
					catch(Exception e) {
						System.out.println("Step >>>>>>>>> Fail :::: " + e);
					}
				}
				else {
					//Skipping the irrelevant Test step
					 
				}
				
				}	
		}else {
			System.out.println("******************************TCID Skipped :::: " + vTCID);
		}
	
	System.out.println("********************TC Ended ***********************");
	}
}

	// Reusable Component
 	public static void executeKW(String fKW, String fTD, String fEID) {
 	// Execute the Test Steps
		if(fKW.equals("openBrowser")) {
			openBrowser(fTD);
		}
		if(fKW.equals("navigateBrowser")) {
			navigateBrowser(fTD);
		}
		if(fKW.equals("typeText")) {
			typeText(fTD, fEID);
		}
		if(fKW.equals("clickElement")) {
			clickElement( fEID);
		}
		if(fKW.equals("verifyText")) {
			verifyText( fTD, fEID);
		}
		if(fKW.equals("closeBrowser")) {
			closeBrowser();
		}
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

	//Keyword Functions	
	public static void openBrowser(String fTD){
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

	public static void navigateBrowser (String fTD) {
		// Naviagte the Browser
		// I/P: TD (Browser Name)
		// O/P: NUll
		myD.navigate().to(fTD);
		
	}
	public static void typeText(String fTD, String fEID) {
		// Type into Text Field
		// I/P: TD (what to type), EID (Where to type)
		// O/P: NUll
		// Selenium WebDriver setup
		myD.findElement(By.xpath(fEID)).sendKeys(fTD);
	}
	public static void clickElement (String fEID) {
		// Click on my Element
		// I/P: TD (where to click)
		// O/P: Nill
		myD.findElement(By.xpath(fEID)).click();
		
	}
	public static void verifyText (String fTD,String fEID) {
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
	public static void closeBrowser() {
		// Close the Browser
		// I/P: Nill
		// O/P: Nill
		myD.close();
		
	}
}

	

