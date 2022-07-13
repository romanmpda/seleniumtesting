package ru.yandex.tests;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.BasePage;
import ru.yandex.pages.GeoPage;
import java.util.List;

@Slf4j
public class ChangeCityTest extends WebDriverSettings {
    public static String FIRSTCITY="Пекин";
    public static String SECONDCITY="Кишинев";
    public static GeoPage geoPage;

    @Test
    public void geoTest(){
        log.info("Демо тест поиска города");
        geoPage = new GeoPage(driver);
        BasePage basePage = new BasePage(driver);
        basePage.openPage(YANDEXHOMEURL);
        geoPage.setupCityEnter();
        basePage.inputText(FIRSTCITY, geoPage.inputCity);
        geoPage.searchMoreElements();
        
        geoPage.setupCityEnter();
        basePage.inputText(SECONDCITY, geoPage.inputCity);
        geoPage.searchMoreElements();
        log.info("Демо тест поиска города завершен");

    }
}
