package pageobjects.shared;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

abstract public class BasePageObject {
    public WebDriver driver;

    public BasePageObject(WebDriver driver) {
        super();
        WebDriverManager.chromedriver().setup();
        this.driver = driver;
    }

    public final void closeBrowser(){
        driver.quit();
    }   
}