package ru.yandex.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
     actions.moveToElement(weblement);
     actions.perform();
    }
    public  void clickElement(WebElement elementToClick){
        elementToClick.click();
    }
    public String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
    public  String getCurrentTitle(){
        String currentTitle = driver.getTitle();
        return  currentTitle;
    }

}
