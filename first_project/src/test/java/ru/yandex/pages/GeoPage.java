package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class GeoPage {
    public GeoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    
    @FindBy (css="div .geolink__button ")
    private WebElement geolinkReg;
    @FindBy (css=".input__control")
    private WebElement inputCity;
    @FindBy (css="div .b-autocomplete-item__reg")
    private WebElement firstCityEnter;
    @FindBy (css=".home-tabs__more-switcher")
    private WebElement moreBotton;
    @FindAll(@FindBy(css=".home-tabs__more-link"))
    private List <WebElement> moreLink;
    
    public void clickGeolinkButton(){
        geolinkReg.click();
    }
    public void clearInputField(){
        inputCity.clear();
    }
    
    public void inputCity(String city){
        inputCity.sendKeys(city);
    }
    
     public void clickfFirstCityEnter(){
        firstCityEnter.click();
    }
    
    public void clickfMoreBotton(){
        moreBotton.click();
    }
    
    public List getMoreList(){
        List<String> moreLinkList = new ArrayList<>();
        moreLink.forEach(WebElement->{moreLinkList.add(WebElement.getText());});
        return moreLinkList;
    }
    
    public void setupCityEnter(){
            clickGeolinkButton();
            clearInputField();
        }
    
     public  void searchMoreElements(){
            clickfFirstCityEnter();
            clickfMoreBotton();
     }

}
