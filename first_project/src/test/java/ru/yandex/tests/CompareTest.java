package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.MarketPage;
import ru.yandex.pages.SearchPage;
import static ru.yandex.tests.SearchTest.searchPage;
import static ru.yandex.tests.SwitchCountTest.MARKETURL;
import static ru.yandex.tests.SwitchCountTest.marketPage;

public class CompareTest extends WebDriverSettings{
    public static Integer GOODSCOUNT=2;

    @Test
    public void compareTest(){
        searchPage = new SearchPage(driver);
        marketPage = new MarketPage(driver);
        basePage.openPage(MARKETURL);
        basePage.clickList(marketPage.electonicsItem, 0);
        basePage.clickList(marketPage.electroniksLink, 0);
        basePage.clickList(marketPage.sorterFilters, 0);
        basePage.clickElement(marketPage.compareButton);
        Assert.assertEquals(basePage.getListSize(marketPage.comparebaleGoodsCount), GOODSCOUNT);
        basePage.clickElement(marketPage.removeButton);
        Assert.assertNull(basePage.getListSize(marketPage.comparebaleGoodsCount));
    }
}
