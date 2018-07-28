package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
   public SearchPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
        this.driver = driver;
   }
   
   public WebDriver driver;
   
   @FindBy(id = "text")
   public WebElement inputField;
   @FindBy(css = "div .search2__button")
   public WebElement searchButton;
   @FindBy(css = "div  a[href='https://yandex.ru/pogoda/penza?from=serp_title'] .organic__url-text")
   public WebElement firstLink;
   @FindBy(css = ".related-serp__thumb-wrapper")
   public WebElement videoPagaWrapper;
   @FindBy(css = "a[href='//yandex.ru/']")
   public WebElement yandexLink;
   @FindBy(css = "a[href='https://yandex.ru']")
   public WebElement yandexFullLink;
   @FindBy(css = ".views__wrap")
   public WebElement imagesPagaWrapper;
   @FindBy(css = ".stories-set")
   public WebElement newsStories;
   @FindAll(@FindBy(css=".home-arrow__tabs .home-link"))
   public List<WebElement> allLinks;
   @FindBy(css = ".map-controls-view__navigation-controlst")
   public WebElement mapsZoom;
   @FindBy(css = ".link")
   public WebElement marketNavigation;
   @FindBy(css = ".service")
   public WebElement translateServoce;
   @FindBy(css = ".d-tabs__tab")
   public WebElement musicTabs;
}
