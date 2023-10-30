package automationtests;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import pageobjects.homepage.HomePageObject;
import pageobjects.homepage.enums.HomePageLinks;
import pageobjects.motorspage.MotorsPageObject;
import pageobjects.motorspage.models.Car;

public class MotorsPageTest {
    MotorsPageObject motorsPage;
    Integer numberOfCarMakesApi;

    @BeforeMethod
    public void openBrowser(ITestResult result){
        HomePageObject homepage = new HomePageObject();
        homepage.clickPageOptionLink(HomePageLinks.MOTORS);
        motorsPage = new MotorsPageObject(homepage.driver);

        String testName = result.getMethod().getMethodName();
        if (testName.equals("Expect_Ui_Number_Of_Cars_To_Match_Api")) {
            Response response = given().when().get("https://api.trademe.co.nz/v1/Categories/UsedCars.json");
            numberOfCarMakesApi = response.jsonPath().getList("Subcategories.Name").size();       
        }
    }

    @AfterMethod
    public void closeBrowser(){
        motorsPage.closeBrowser();
    }

    @DataProvider(name = "carMakes")
    public static Object[] fixtureMakes() {
        return new Object[] {
            new Car("Ferrari", 20, 80),
            new Car("BMW", 2500, 3500),
            new Car("Mazda", 5500, 6500),
            new Car("Honda", 3000, 4000)
        };
    }

    @Test
    public void Expect_Ui_Number_Of_Cars_To_Match_Api(){    
        Integer actualUiCountOfCars = motorsPage.calculateNumberofOptions();
        Assert.assertEquals(actualUiCountOfCars, numberOfCarMakesApi);
    }

    @Test(dataProvider = "carMakes", testName = "Select: {0} displays correctly")
    public void Expect_Selected_Car_Make_To_Be_Seleted_And_Search_Results_Displayed(Car carMake){
        motorsPage.clickCarMake(carMake.name);
        motorsPage.clickSearchButton();
        Integer carNumberResults = motorsPage.numberOfSearchedCarResults();

        Assert.assertTrue(carMake.minResultsNumber <= carNumberResults && carNumberResults <= carMake.maxResultsNumber);
    }
}
