package Stepdefs;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentreportearn {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public void beforesuite(){
		extent = new ExtentReports("D://reports//myreport.html",true);
		extent.loadConfig(new File("D//com.learnautomation.cucumber//config files//extent-config.xml"));
	}
	@BeforeMethod
	public void beforemethod(Method method){
		test= extent.startTest((this.getClass().getName()+"::"+ method.getName()),method.getName());
		test.assignAuthor("Santhoshi");
		test.assignCategory("Learning the extent reporting");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:/Users/DELL/drivers/new chrome/chromedriver.exe");
	}
	@Test
	public void test() {
		driver.get("https://www.google.com/");
		String currenturl = driver.getCurrentUrl();
		test.log(LogStatus.PASS, "the current page i am on is "+currenturl);
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
		driver.quit();
		test.log(LogStatus.PASS, "closed the browser");
		extent.endTest(test);
	}
	@AfterSuite
	public void aftersuite() {
		extent.flush();
		extent.close();
	}
	
	

}
