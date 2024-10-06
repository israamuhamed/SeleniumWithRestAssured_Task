package Pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import API.Personal_Details;

public class Login {
	 public WebDriver driver;
	 
	  public Login(WebDriver driver) {
	        this.driver = driver;
	    }
	    
		@SuppressWarnings("deprecation")
	    public void loginScenario() {
		
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.findElement(By.name("username")).sendKeys("Admin");
	        driver.findElement(By.name("password")).sendKeys("admin123");
	        
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.navigate().to("https://opensource-demo.orangehrmlive.com/pim/viewEmployeeList");
//	        driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item active'])[1]")).click();

	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        Personal_Details employee= new Personal_Details();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        System.out.println(employee.EmpID);
	        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("8881");
	        driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();
	        
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        

	    	driver.findElement(By.xpath("(//div[normalize-space()='8881'])[1]")).click();
	    	
	        driver.findElement(By.xpath("(//a[normalize-space()='Contact Details'])[1]")).click();
	        
	        Random rand = new Random();
	        String street1 = "Street " + rand.nextInt(50);
	        String street2 = "Apt " + rand.nextInt(50);
	        
	        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(street1);
	        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(street2);
	        

	        
	        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]")).click();
	        
	        driver.findElement(By.xpath("(//a[normalize-space()='Job'])[1]")).click();
	        driver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]")).sendKeys("2024-10-31");
	        driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[4]")).click();
	        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[4]")).click();
	        driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
	        
	       
	        
	    }
	

}
