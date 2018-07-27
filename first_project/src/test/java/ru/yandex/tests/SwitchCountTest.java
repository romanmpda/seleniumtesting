package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.MarketPage;
import ru.yandex.pages.SearchPage;
import static ru.yandex.tests.SearchTest.searchPage;

public class SwitchCountTest extends WebDriverSettings {
    public static MarketPage marketPage;
    public static String MARKETURL = "https://market.yandex.ru/";
    public static Integer SORTCOUNT12 = 12;
    public static Integer SORTCOUNT48 = 48;
    @Test
    public void switchCountTest() {
        searchPage = new SearchPage(driver);
        marketPage = new MarketPage(driver);
        basePage.openPage(MARKETURL);
        basePage.clickList(marketPage.electonicsItem, 0);
        basePage.clickList(marketPage.electroniksLink, 0);
        basePage.scrollToElement(marketPage.toClick);
        basePage.clickElement(marketPage.buttonListbox);
        basePage.clickList(marketPage.selectText, 1);
        Assert.assertEquals(basePage.getListSize(marketPage.elementsCount),SORTCOUNT48);
        basePage.clickElement(marketPage.buttonListbox);
        basePage.clickList(marketPage.selectText, 0);
        Assert.assertEquals(basePage.getListSize(marketPage.elementsCount),SORTCOUNT12);

    }
}
