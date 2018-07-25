package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    public void openPage(String urlGet){
        driver.get(urlGet);
    }
    public void scroll(By locator) {
     WebElement weblement = driver.findElement(locator);
     Actions actions = new Actions(driver);
     actions.moveToElement(element);
     actions.perform();
    }

}
