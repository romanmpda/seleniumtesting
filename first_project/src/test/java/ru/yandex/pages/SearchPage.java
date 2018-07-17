package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {
   public SearchPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
        this.driver = driver;
   }
    public WebDriver driver;
   @FindBy(id = "text")
   private WebElement inputField;

    @FindBy(css = "div .search2__button")
   private WebElement searchButton;

    @FindBy(css = "div  a[href='https://yandex.ru/pogoda/penza?from=serp_title'] .organic__url-text")
    private WebElement firstLink ;

    public void inputSearchText(String request)
    {
        inputField.sendKeys(request);
    }
    public void clearInputField()
    {
        inputField.clear();
    }
    public void clickSearchButton()
    {
        searchButton.click();
    }
    public String grtFirstLinkText()
    {
        String firstLikString = firstLink.getText();
        return firstLikString;
    }


}
