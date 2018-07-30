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
        searchPage.openPage(YANDEXHOMEURL);
        searchPage.clearField(searchPage.inputField);
        searchPage.inputText(SEARCHREQUEST, searchPage.inputField);
        searchPage.clickElement(searchPage.searchButton);
        Assert.assertEquals(FIRSTWEATHERLINKTEXT, searchPage.getElementText(searchPage.firstLink));
    }
}
