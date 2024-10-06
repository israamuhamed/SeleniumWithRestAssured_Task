package API;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Personal_Details {
	Add_Employee employee = new Add_Employee();
    Faker fakeData = new Faker();
    String First_Name = fakeData.name().firstName();
    String Last_Name = fakeData.name().lastName();
    String Middle_Name = fakeData.name().name();
    Integer ID = 8881;
    Response UpdateEmployee;
    public Integer EmpID;


	@Test

    public void Update_Employee(){
		
	    employee.Create_New_Employee();
	    employee.validate_Employee_Created();
	     
	     String Body_Request ="{\"lastName\":\""+Last_Name+"\","
	     		+ "\"firstName\":\""+First_Name+"\","
	     		+ "\"middleName\":\""+Middle_Name+"\","
	     		+ "\"employeeId\":\""+ID+"\","
	     		+ "\"otherId\":\"\","
	     		+ "\"drivingLicenseNo\":\"\","
	     		+ "\"drivingLicenseExpiredDate\":\"\","
	     		+ "\"gender\":1,"
	     		+ "\"maritalStatus\":\"Single\","
	     		+ "\"birthday\":\"1998-11-30\""
	     		+ "}";

        UpdateEmployee = RestAssured.given()
                .baseUri("https://opensource-demo.orangehrmlive.com")
                .basePath("/api/v2/")
                .header("Content-Type","application/json")
                .header("Cookie","orangehrm=r81l5p82bnuhn77ck5ije57kki")
                .header("Accept","application/json")
                .body(Body_Request)
                .when()
                .put("pim/employees/"+employee.EmpNumber+"/personal-details");
        
        System.out.println(employee.EmpNumber);
        System.out.println(Body_Request);
        System.out.println(UpdateEmployee.getStatusCode());
        System.out.println(UpdateEmployee.getStatusLine());
    }
	
@Test
    public void validate_Employee_Updated(){
        UpdateEmployee.prettyPrint();
        UpdateEmployee.then()
                .statusCode(HttpStatus.SC_OK);
        Response response = 
                UpdateEmployee
                .then()
                    .statusCode(200) 
                    .extract().response();
             EmpID = response.jsonPath().get("data.employeeId");
             System.out.println("empNumber"  +EmpID);
             
    }

}
