package ru.yandex.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ChangeCityTest extends WebDriverSettings {
    @Test
    public void geoTest(){
        geoPage.clickStepsBefore();
        geoPage.inputCity(FIRSTCITY);
        geoPage.clickStepsAfter();
        List<String> firstCityMore = geoPage.getMoreList();
        geoPage.clickStepsBefore();
        geoPage.inputCity(SECONDCITY);
        geoPage.clickStepsAfter();
        List<String> secondCityMore = geoPage.getMoreList();
        Assert.assertEquals(secondCityMore, firstCityMore);
    }
}
