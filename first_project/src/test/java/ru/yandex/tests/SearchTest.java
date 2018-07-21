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
        searchPage.clearInputField();
        searchPage.inputSearchText(SEARCHREQUEST);
        searchPage.clickSearchButton();
        String firstLikString = searchPage.getFirstLinkText();
        Assert.assertEquals(FIRSTWEATHERLINKTEXT, firstLikString);
    }
}
