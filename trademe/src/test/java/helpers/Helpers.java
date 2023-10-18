package helpers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helpers {
    public static WebElement getDropdownItems(WebDriver driver, Dropdown dropdownSelction){
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        String allMakeSelectId = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(@class, 'o-select__label') and text()='%s']".formatted(dropdownSelction.getId())))).getAttribute("for");
        WebElement allMakeOptionsElement = driver.findElement(By.id(allMakeSelectId));
        return allMakeOptionsElement;
    }
    
    public static WebElement findElementAwait(WebDriver driver, By elementselector){
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webElement = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(elementselector));
        return webElement;        
    }

    public static List<WebElement> findElementsAwait(WebDriver driver, By elementselector){
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> webElements = waitDriver.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementselector));
        return webElements;        
    }
}