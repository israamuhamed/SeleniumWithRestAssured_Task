package API;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
 @Test
public class Add_Employee {
	
    public String EmployeeName;
    public Integer EmpNumber;
    
    Faker fakeData = new Faker();
    String First_Name = fakeData.name().firstName();
    String Last_Name = fakeData.name().lastName();
    String Middle_Name = fakeData.name().name();
//    public Integer Employee_Id = Integer.valueOf(fakeData.number().digits(4));
    Response Create_Employee;
    
    String Body_Request ="{\"firstName\":\""+First_Name+"\"," +
            "\"middleName\":\""+Middle_Name+"\"," +
            "\"lastName\":\""+Last_Name+"\"," +
            "\"empPicture\":null," +
            "\"employeeId\":\"8881\"}";
    @Test
    public void Create_New_Employee(){
        Create_Employee = RestAssured.given()
               .baseUri("https://opensource-demo.orangehrmlive.com")
               .basePath("/api/v2/")
               .header("Content-Type","application/json")
               .header("Cookie","orangehrm=r81l5p82bnuhn77ck5ije57kki")
               .header("Accept","application/json")
               .body(Body_Request)
               .when()
               .post("pim/employees");
        System.out.println(Create_Employee.getStatusCode());
        System.out.println(Create_Employee.getStatusLine());
        System.out.println(Body_Request);
//        System.out.println("EmpID"   +Employee_Id);
       
   }
  
    public void validate_Employee_Created(){
        Create_Employee.prettyPrint();
        Create_Employee.then()
                .statusCode(HttpStatus.SC_OK);
        Response response = 
            Create_Employee
            .then()
                .statusCode(200) 
                .extract().response();
         EmpNumber = response.jsonPath().get("data.empNumber");
         System.out.println("empNumber"  +EmpNumber);
         

    }
 

}
