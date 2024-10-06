package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import API.Add_Employee;

public class JobDetails {
	private WebDriver driver;

    public JobDetails(WebDriver driver) {
        this.driver = driver;
    }

    public void addJobDetails() {
    	Add_Employee employee= new Add_Employee();
    	Integer employeeId= employee.EmpNumber;
    	
        driver.findElement(By.id("joinedDate")).sendKeys("111");
        driver.findElement(By.id("btnSave")).click();        
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("employeeId");
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.xpath("//a[text()='" + employeeId + "']")).click();
        
        driver.findElement(By.id("menu_pim_viewJobHistory")).click();
        driver.findElement(By.id("job_joined")).sendKeys("2015-06-15");
        driver.findElement(By.id("job_job_title")).sendKeys("Software Engineer");
        driver.findElement(By.id("job_emp_status")).sendKeys("Part-Time internship");
        driver.findElement(By.id("job_sub_unit")).sendKeys("Quality Control");
        
        // Contract details
        driver.findElement(By.id("job_contract_start")).sendKeys("2024-10-05"); 
        driver.findElement(By.id("job_contract_end")).sendKeys("2025-10-05"); 
        
        driver.findElement(By.id("btnSave")).click();
        AssertJUnit.assertTrue(driver.findElement(By.className("message success")).isDisplayed());
    }

    public void verifySuccessMessage(String message) {
     
    }

}
