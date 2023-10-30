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
        return driver.findElement(By.id(allMakeSelectId));
    }
    
    public static WebElement findElementAwait(WebDriver driver, By elementselector){
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(elementselector));
        return driver.findElement(elementselector);        
    }

    public static List<WebElement> findElementsAwait(WebDriver driver, By elementselector){
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementselector));
        return driver.findElements(elementselector);       
    }
}