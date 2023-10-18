package pageobjects.motorspage;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Dropdown;
import helpers.Helpers;
import pageobjects.shared.BasePageObject;

public class MotorsPageObject extends BasePageObject {   
    public MotorsPageObject(WebDriver driver) {
        super(driver);
    }

    public int calculateNumberofOptions(){
        WebElement dropdown = Helpers.getDropdownItems(this.driver, Dropdown.MAKE);
        List<WebElement> carOptions = dropdown.findElements(By.tagName("option"));
        for (Iterator<WebElement> webElement = carOptions.iterator(); webElement.hasNext();) {
            WebElement option = webElement.next();
            if (option.getText().contains("Any make")) {
                webElement.remove();
            }
        }
        return carOptions.size();
    }   

    public String clickCarMake(String carMake){
        WebElement carMakeDropdown = Helpers.getDropdownItems(driver, Dropdown.MAKE);
        carMakeDropdown.sendKeys(carMake);
        WebElement selectedOption = carMakeDropdown.findElement(By.cssSelector("option:checked"));
        return selectedOption.getText();        
    }

    public void clickSearchButton(){
        WebElement searchButton = driver.findElement(By.xpath("//button[text()=' View 32,000+ listings ']"));

        searchButton.click();
    }
    
    public Integer numberOfSearchedCarResults(){
        String regexPattern = "Showing (?:\\d{1,3},)?\\d+ results";

        for (WebElement h3Element : Helpers.findElementsAwait(driver, By.tagName("h3"))) {
            if (Pattern.matches(regexPattern, h3Element.getText())) {
                return Integer.parseInt(h3Element.getText().replaceAll("[^0-9]", ""));
            }
        }
        return 0;
    }
}