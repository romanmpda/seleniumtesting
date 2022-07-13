package ru.yandex.tests;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.BasePage;
import ru.yandex.pages.SearchPage;

@Slf4j
public class SearchTest extends WebDriverSettings {

    public static String SEARCHREQUEST = "погода пенза" ;
    public static String FIRSTWEATHERLINKTEXT ="Погода в Пензе";

    @Test
    public void searchTest() {
        log.info("Демо тест поиска погоды");
        BasePage basePage = new BasePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        basePage.openPage(YANDEXHOMEURL);
        basePage.clearField(searchPage.inputField);
        basePage.inputText(SEARCHREQUEST, searchPage.inputField);
        basePage.clickElement(searchPage.searchButton);
        Assert.assertEquals(FIRSTWEATHERLINKTEXT, basePage.getElementText(searchPage.firstLink));
        log.info("Демо тест поиска погоды завершен");
    }
}
