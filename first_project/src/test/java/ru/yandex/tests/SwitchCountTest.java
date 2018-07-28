package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.MarketPage;
import ru.yandex.pages.SearchPage;
import java.util.List;
import static ru.yandex.tests.SearchTest.searchPage;

public class SwitchCountTest extends WebDriverSettings {
    public static MarketPage marketPage;
    public static Integer SORTCOUNT12 = 12;
    public static Integer SORTCOUNT48 = 48;
    public static String SHOW12 ="Показывать по 12";
    public static String SHOW48 ="Показывать по 48";

    @Test
    public void switchCountTest() {
        searchPage = new SearchPage(driver);
        marketPage = new MarketPage(driver);
        marketPage.goToMobileCategory();
        basePage.scrollToElementJS(marketPage.showBotton);
        basePage.moveToElement(marketPage.showBotton);
        basePage.clickElement(marketPage.showBotton);
        List<String> list48=basePage.getTextList(marketPage.selectText);
        Integer id48=list48.indexOf(SHOW48);
        basePage.clickList(marketPage.selectText, id48);
        basePage.scrollToElementJS(searchPage.yandexFullLink);
        Assert.assertEquals(basePage.getListSize(marketPage.elementsCount),SORTCOUNT48);
        basePage.scrollToElementJS(marketPage.showBotton);
        basePage.moveToElement(marketPage.showBotton);
        basePage.clickElement(marketPage.showBotton);
        List<String> list12=basePage.getTextList(marketPage.selectText);
        Integer id12=basePage.compareTextInList(list12,SHOW12);
        System.out.println(list12);
        System.out.println(id12);
        basePage.clickList(marketPage.selectText, id12);
        basePage.scrollToElementJS(searchPage.yandexFullLink);
        Assert.assertEquals(basePage.getListSize(marketPage.elementsCount),SORTCOUNT12);

    }
}
