package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.SearchPage;

public class SearchTest extends WebDriverSettings {
    public static SearchPage searchPage;
    public static String SEARCHREQUEST = "погода пенза" ;
    public static String FIRSTWEATHERLINKTEXT ="Погода в Пензе";

    @Test
    public void searchTest() {
        searchPage = new SearchPage(driver);
        basePage.openPage(YANDEXHOMEURL);
        basePage.clearField(searchPage.inputField);
        basePage.inputText(SEARCHREQUEST, searchPage.inputField);
        basePage.clickElement(searchPage.searchButton);
        Assert.assertEquals(FIRSTWEATHERLINKTEXT, basePage.getElementText(searchPage.firstLink));
    }
}
