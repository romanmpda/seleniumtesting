package ru.yandex.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class BasePage extends WebDriverSettings{
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
    public void scrollToElementJS(WebElement elementToScrollJS) {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop=arguments[1];",elementToScrollJS);}

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
    public  void  moveToElementList(List<WebElement> elementToMoveList, Integer idToMove){
        Actions actionsList = new Actions(driver);
        actionsList.moveToElement(elementToMoveList.get(idToMove)).build().perform();
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
    public Integer compareTextInList(List<String> stringToComapre, String compareWith){
        Integer idOfEqual = stringToComapre.indexOf(compareWith);
        return idOfEqual;
    }
    public void inputText(String textToinput, WebElement inputField){
        inputField.sendKeys(textToinput);
    }
    public  void clearField(WebElement fieldToClear){
        fieldToClear.clear();
    }
    public String getElementText(WebElement elementToGetText){
        return elementToGetText.getText();
    }

}
