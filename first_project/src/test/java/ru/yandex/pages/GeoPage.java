package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.tests.WebDriverSettings;

import java.util.ArrayList;
import java.util.List;


public class GeoPage extends WebDriverSettings {
    public GeoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    @FindBy (css="div .geolink__button ")
    private WebElement geolinkReg;
    @FindBy (css=".input__control")
    public WebElement inputCity;
    @FindBy (css="div .b-autocomplete-item__reg")
    private WebElement firstCityEnter;
    @FindBy (css=".home-tabs__more-switcher")
    private WebElement moreBotton;
    @FindAll(@FindBy(css=".home-tabs__more-link"))
    public List <WebElement> moreLink;

    public void setupCityEnter(){
        basePage.clickElement(geolinkReg);
        basePage.clearField(inputCity);
        }

     public  void searchMoreElements(){
        basePage.clickElement(firstCityEnter);
        basePage.clickElement(moreBotton);
     }

}
