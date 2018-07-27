package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import ru.yandex.pages.MarketPage;
import ru.yandex.pages.SearchPage;
import java.util.Collections;
import java.util.List;
import static ru.yandex.tests.SearchTest.searchPage;
import static ru.yandex.tests.SwitchCountTest.MARKETURL;
import static ru.yandex.tests.SwitchCountTest.marketPage;

public class SortPriceTest extends WebDriverSettings{

    @Test
    public void compareTest(){
        searchPage = new SearchPage(driver);
        marketPage = new MarketPage(driver);
        basePage.openPage(MARKETURL);
        basePage.clickList(marketPage.electonicsItem, 0);
        basePage.clickList(marketPage.electroniksLink, 0);
        basePage.clickList(marketPage.sorterFilters, 0);
        basePage.scrollToElement(marketPage.toClick);
        List<String> notSortedPrice =basePage.getTextList(marketPage.pricesAll);
        List<String> sortedPrice = notSortedPrice;
        Collections.sort(sortedPrice);
        Assert.assertNotNull(marketPage.priceIsSelected);
        Assert.assertEquals(sortedPrice, notSortedPrice);

    }
}


