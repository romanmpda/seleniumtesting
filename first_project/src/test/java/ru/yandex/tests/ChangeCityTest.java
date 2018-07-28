package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.GeoPage;
import java.util.List;

public class ChangeCityTest extends WebDriverSettings {
    public static String FIRSTCITY="Пекин";
    public static String SECONDCITY="Кишинев";
    public static GeoPage geoPage;

    @Test
    public void geoTest(){
        geoPage = new GeoPage(driver);
        basePage.openPage(YANDEXHOMEURL);
        geoPage.setupCityEnter();
        basePage.inputText(FIRSTCITY, geoPage.inputCity);
        geoPage.searchMoreElements();
        List<String> firstCityMore = basePage.getTextList(geoPage.moreLink);
        geoPage.setupCityEnter();
        basePage.inputText(SECONDCITY, geoPage.inputCity);
        geoPage.searchMoreElements();
        List<String> secondCityMore = basePage.getTextList(geoPage.moreLink);
        Assert.assertEquals(secondCityMore, firstCityMore);
    }
}
