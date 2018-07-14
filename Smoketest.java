package Stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Smoketest {
	WebDriver driver;
	

		// TODO Auto-generated method stub
		@Given("^open the facebook in chrome$")
		public void open_the_facebook_in_chrome() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			System.setProperty("webdriver.chrome.driver", "C:/Users/DELL/drivers/new chrome/chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.facebook.com");
		}

		@Given("^Enter the valid \"([^\"]*)\" and \"([^\"]*)\" and click on log in$")
		public void enter_the_valid_creds_and_click_on_log_in(String uname, String password ) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.id("email")).sendKeys(uname);
		    driver.findElement(By.id("pass")).sendKeys(password);
		}

		@Then("^I havee to log in to facebook$")
		public void i_havee_to_log_in_to_facebook() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
		    
		}


	}


