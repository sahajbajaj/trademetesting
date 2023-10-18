package pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.Helpers;
import pageobjects.homepage.enums.HomePageLinks;
import pageobjects.shared.BasePageObject;

public class HomePageObject extends BasePageObject {
    
    public HomePageObject() {
        super(new ChromeDriver());        
        this.driver.get("https://www.trademe.co.nz");
    }
   
    public void clickPageOptionLink(HomePageLinks hyperlink){
        WebElement pageLink = Helpers.findElementAwait(driver, By.cssSelector(hyperlink.getId()));
        pageLink.click();
    }
}