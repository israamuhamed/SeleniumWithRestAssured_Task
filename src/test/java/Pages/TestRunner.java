package Pages;
import org.testng.annotations.*;
import API.Add_Employee;
import API.Personal_Details;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import java.util.Random;

public class TestRunner {
	
		WebDriver driver;
		private Login loginPage;
		@BeforeTest
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
			
	    	 loginPage =new Login(driver);

	    }
		

	    @Test
	    public void addEmployee() {
	    	Add_Employee new_Employee = new Add_Employee();
	    	new_Employee.Create_New_Employee();
	    }
	    @Test
	    public void addPersonalDetails()  {
	    	Personal_Details Update_Employee = new Personal_Details();
	    	Update_Employee.Update_Employee();
	    }
	    
	    @Test
	    public void login() {
			loginPage.loginScenario();
	    }
	   
//	    @Test
//	    public void addContactDetails() {
//	    	ContactDetails Contact = new ContactDetails(driver);
//	    	Contact.addContactDetails();
//	    }
	    
//	    @Test
//	    public void addJobDetails() {
//	    	JobDetails Job = new JobDetails(driver);
//	    	Job.addJobDetails();
//	       
//	    }


	   
		@AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}