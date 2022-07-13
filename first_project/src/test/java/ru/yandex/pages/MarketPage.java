package ru.yandex.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import ru.yandex.tests.WebDriverSettings;

import static ru.yandex.tests.WebDriverSettings.basePage;


public class MarketPage extends WebDriverSettings {
    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    public static String MARKETURL = "https://market.yandex.ru/";
    private static String videoUrl = "https://yandex.ru/video/";
    private static String imagesUrl = "https://yandex.ru/images/";
    private static String newsUrl = "https://news.yandex.ru/";
    private static String mapsTitle = "Яндекс.Карты — выбирайте, где поесть, куда сходить, чем заняться";
    private static String marketTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";
    private static String translateUrl = "https://translate.yandex.ru/";
    private static String musicUrl = "https://music.yandex.ru/";
    public static Integer GOODSCOUNT=2;
    public static MarketPage marketPage;
    public static Integer SORTCOUNT12 = 12;
    public static Integer SORTCOUNT48 = 48;
    public static String SHOW12 ="Показывать по 12";
    public static String SHOW48 ="Показывать по 48";

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
    @FindAll(@FindBy(css = "[class='image image_name_compare']"))
    public List<WebElement> goodsToCompare;
    @FindBy(css = ".popup-informer__controls [class='button button_size_m button_theme_normal i-bem button_js_inited'] ")//"a[href='/compare?track=rmmbr']")
    public WebElement compareButton;
    @FindAll(@FindBy(css = ".price"))
    public List<WebElement> comparebaleGoodsCount;
    @FindBy(css = "[class='image image_name_remove']")
    public WebElement removeButton;
    @FindAll(@FindBy(css = "[class='n-filter-sorter i-bem n-filter-sorter_js_inited']"))
    public List<WebElement> sorterFilters;
    @FindAll(@FindBy(css = ".n-snippet-cell2__main-price .price"))
    public List<WebElement> pricesAll;
    @FindBy(css = "[class='n-filter-sorter i-bem n-filter-sorter_js_inited n-filter-sorter_sort_asc n-filter-sorter_state_select']")
    public WebElement priceIsSelected;
    @FindBy(css = ".n-compare-empty__content")
    public WebElement emptyContent;
    @FindAll(@FindBy(css = "[class='link topmenu__subitem']"))
    public List<WebElement> topmenuSub;



    public void goToMobileCategory(){
        basePage.openPage(MARKETURL);
        basePage.moveToElementList(electonicsItem, 0);
        basePage.moveToElementList(topmenuSub, 0);
        basePage.clickList(electonicsItem, 0);
        basePage.clickList(electroniksLink, 0);

    }
}
