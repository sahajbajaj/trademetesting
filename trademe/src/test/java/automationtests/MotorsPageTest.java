package automationtests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.homepage.HomePageObject;
import pageobjects.homepage.enums.HomePageLinks;
import pageobjects.motorspage.MotorsPageObject;
import pageobjects.motorspage.models.Car;

public class MotorsPageTest {
    MotorsPageObject motorsPage;

    @BeforeMethod
    public void openBrowser(){
        HomePageObject homepage = new HomePageObject();
        homepage.clickPageOptionLink(HomePageLinks.MOTORS);
        motorsPage = new MotorsPageObject(homepage.driver);
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
    public void Expect_Number_Of_Cars_To_Be_Eighty_One(){
        int expectedCountOfCars = 81;
        int actualCountOfCars = motorsPage.calculateNumberofOptions();
        Assert.assertEquals(actualCountOfCars, expectedCountOfCars);
    }

    @Test(dataProvider = "carMakes", testName = "Select: {0} displays correctly")
    public void Expect_Selected_Car_make_to_be_Seleted(Car carMake){
        motorsPage.clickCarMake(carMake.name);
        motorsPage.clickSearchButton();
        Integer carNumberResults = motorsPage.numberOfSearchedCarResults();

        Assert.assertTrue(carMake.minResultsNumber <= carNumberResults && carNumberResults <= carMake.maxResultsNumber);
    }
}