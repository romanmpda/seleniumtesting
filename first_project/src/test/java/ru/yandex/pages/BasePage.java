package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    public void openPage(String urlGet){
        driver.get(urlGet);
    }

    public void scrollToElement(WebElement elementToScroll) {
     Actions actions = new Actions(driver);
     actions.moveToElement(elementToScroll);
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
        public void clickList(List<WebElement> locatorToClick, Integer clickableId){
        locatorToClick.get(clickableId).click();
    }
    public  void  moveToElement(WebElement elementToMove){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToMove).build().perform();
    }
    public Integer getListSize(List<WebElement> locatorToCount){
        Integer listSize = locatorToCount.size();
        return listSize;
    }
    public List getTextList(List <WebElement> textToGetList){
        List<String> textGetedList = new ArrayList<>();
        textToGetList.forEach(WebElement->{textGetedList.add(WebElement.getText());});
        return textGetedList;
    }

}
