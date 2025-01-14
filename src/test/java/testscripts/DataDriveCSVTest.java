package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class DataDriveCSVTest {

    WebDriver driver;

    @Test(dataProvider = "loginData")
    public void validLogin(String username, String userpass) {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(readObjPath("username"))).sendKeys(username);
        driver.findElement(By.name(readObjPath("password"))).sendKeys(userpass);
        driver.findElement(By.cssSelector(readObjPath("loginBtn"))).click();
        driver.findElement(By.partialLinkText("Elemental")).click();
    }
    
    
    public String readObjPath(String objName) {
    	String objPath = "";
    	  String path = System.getProperty("user.dir") + "//src//test//resources//datafiles//LoginRepo.xlsx";
    	  FileInputStream fin;
    	  //HSSF-->.xls
    	  //XSSF--->.xlsx
    	  XSSFWorkbook workbook = null;
    	  try {
			fin = new FileInputStream(path);
			workbook = new XSSFWorkbook(fin);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  XSSFSheet loginSheet = workbook.getSheet("LoginPage");
    	  int numRows = loginSheet.getLastRowNum();
    	  for(int i=1;i<=numRows;i++) {
    		  XSSFRow row = loginSheet.getRow(i);
    		  //System.out.println(row);
    		  
    		  if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
    			  objPath = row.getCell(1).getStringCellValue();
    		  }
    	  }
    	  return objPath;
    	
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws CsvValidationException, IOException {
        
        // Step 1: Define the file path 
        String path = System.getProperty("user.dir") + "//src//test//resources//datafiles//loginData.csv";
        
        // Step 2: Create a FileReader 
        FileReader fileReader = new FileReader(path); 
        
        // Step 3: Create a CSVReader 
        CSVReader csvReader = new CSVReader(fileReader);

        String cols[];
        ArrayList<Object[]> dataList = new ArrayList<>(); // arrylist to store username and password
        // Print dataList before reading the CSV
        System.out.println("Data list before reading CSV: " + dataList);

        while ((cols = csvReader.readNext()) != null) {
            Object[] record = { cols[0], cols[1] };
            dataList.add(record);
        }

        // Print dataList after reading the CSV
        System.out.println("Data list after reading CSV:");
        dataList.forEach(record -> System.out.println(record[0] + " " + record[1]));

        csvReader.close();
        return dataList.toArray(new Object[dataList.size()][]);
    }
}
