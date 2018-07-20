package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ChangeCityTest extends WebDriverSettings {
    @Test
    public void geoTest(){
        public static GeoPage geoPage;
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
