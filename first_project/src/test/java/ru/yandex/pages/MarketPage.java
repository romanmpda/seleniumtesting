package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketPage {
    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindAll(@FindBy(css = "[class='link topmenu__link']"))
    public List<WebElement> electonicsItem;
    @FindAll(@FindBy(css = "[class='link catalog-menu__list-item metrika i-bem metrika_js_inited']"))
    public List<WebElement> electroniksLink;
    @FindBy(css = "button[role=listbox]")
    public WebElement buttonListbox;
    @FindAll(@FindBy(css = ".select__text"))
    public List<WebElement> selectText;
    @FindAll(@FindBy(css = ".n-snippet-cell2__header"))
    public List<WebElement> elementsCount;
    @FindBy(css = ".button_theme_normal")
    public WebElement showBotton;
    @FindBy(css = "[class='title title_size_22 title_indent_bottom']")
    public WebElement toClick;
    @FindBy(css = "span [class='button__text']")
    public WebElement secondClick;




}