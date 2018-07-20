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
        geoPage.inputCity(FIRSTCITY);
        geoPage.searchMoreElements();
        List<String> firstCityMore = geoPage.getMoreList();
        geoPage.setupCityEnter();
        geoPage.inputCity(SECONDCITY);
        geoPage.searchMoreElements();
        List<String> secondCityMore = geoPage.getMoreList();
        Assert.assertEquals(secondCityMore, firstCityMore);
    }
}
