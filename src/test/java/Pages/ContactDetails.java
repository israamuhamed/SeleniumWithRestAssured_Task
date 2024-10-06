package Pages;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.AssertJUnit;
//
//import API.Add_Employee;

public class ContactDetails {
	private WebDriver driver;

    public ContactDetails(WebDriver driver) {
        this.driver = driver;
    }
    

    @SuppressWarnings("deprecation")
	public void addContactDetails() {

    	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("(//a[normalize-space()='Contact Details'])[1]")).click();
//        
//        Random rand = new Random();
//        String street1 = "Street " + rand.nextInt(50);
//        String street2 = "Apt " + rand.nextInt(50);
//        
//        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(street1);
//        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(street2);
//        
//
//        
//        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]")).click();
//        
//        AssertJUnit.assertTrue(driver.findElement(By.className("message success")).isDisplayed());
//        
//        driver.findElement(By.id("btnAddAttachment")).click();
//        
//        
//        driver.findElement(By.id("btnSave")).click();
//        AssertJUnit.assertTrue(driver.findElement(By.className("message success")).isDisplayed());
//        
//
//    	
//        driver.findElement(By.id("btnSave")).click();
//    }
//
//    public void verifySuccessMessage(String message) {
//        
//    }
//	    private void loadContactDetailsFromJSON(){
	//    
//	        JSONParser parser = new JSONParser();
//	        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/test/resources/Data.json"));
	//
//	        driver.findElement(By.id("contact_city")).sendKeys((String) jsonObject.get("city"));
//	        driver.findElement(By.id("contact_state")).sendKeys((String) jsonObject.get("state"));
//	        driver.findElement(By.id("contact_zipcode")).sendKeys((String) jsonObject.get("zipcode"));
//	        driver.findElement(By.id("contact_mobile")).sendKeys((String) jsonObject.get("mobile"));
//	    }


}}
