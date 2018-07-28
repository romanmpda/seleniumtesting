package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.MarketPage;
import ru.yandex.pages.SearchPage;
import static ru.yandex.tests.SearchTest.searchPage;
import static ru.yandex.tests.SwitchCountTest.marketPage;

public class CompareTest extends WebDriverSettings{
    public static Integer GOODSCOUNT=2;

    @Test
    public void compareTest(){
        searchPage = new SearchPage(driver);
        marketPage = new MarketPage(driver);
        marketPage.goToMobileCategory();
        basePage.moveToElementList(marketPage.goodsToCompare, 0);
        basePage.clickList(marketPage.goodsToCompare, 0);
        Assert.assertNotNull(marketPage.compareButton);
        basePage.moveToElementList(marketPage.goodsToCompare, 1);
        basePage.clickList(marketPage.goodsToCompare, 1);
        Assert.assertNotNull(marketPage.compareButton);
        basePage.moveToElement(marketPage.compareButton);
        basePage.clickElement(marketPage.compareButton);
        basePage.moveToElementList(marketPage.comparebaleGoodsCount, 0);
        basePage.moveToElementList(marketPage.comparebaleGoodsCount, 1);
        basePage.moveToElement(marketPage.removeButton);
        Assert.assertEquals(basePage.getListSize(marketPage.comparebaleGoodsCount), GOODSCOUNT);
        basePage.clickElement(marketPage.removeButton);
        Assert.assertNotNull(marketPage.emptyContent);
    }
}
