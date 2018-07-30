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
        geoPage.openPage(YANDEXHOMEURL);
        geoPage.setupCityEnter();
        geoPage.inputText(FIRSTCITY, geoPage.inputCity);
        geoPage.searchMoreElements();
        List<String> firstCityMore = geoPage.getTextList(geoPage.moreLink);
        
        geoPage.setupCityEnter();
        geoPage.inputText(SECONDCITY, geoPage.inputCity);
        geoPage.searchMoreElements();
        List<String> secondCityMore = geoPage.getTextList(geoPage.moreLink);
        Assert.assertEquals(secondCityMore, firstCityMore);
    }
}
