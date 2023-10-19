package pageobjects.shared;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

abstract public class BasePageObject {
    public WebDriver driver;

    public BasePageObject(WebDriver driver) {
        super();
        WebDriverManager.chromedriver().setup();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver = driver;
    }

    public final void closeBrowser(){
        driver.quit();
    }   
}