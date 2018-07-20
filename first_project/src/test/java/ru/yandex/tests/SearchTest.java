package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.SearchPage;

public class SearchTest extends WebDriverSettings {
    public static SearchPage searchPage;
@Test
    public void searchTest() {
        searchPage = new SearchPage(driver);
        basePage.openPage(YANDEXHOMEURL);
        searchPage.clearInputField();
        searchPage.inputSearchText("погода пенза");
        searchPage.clickSearchButton();
        String firstLikString = searchPage.getFirstLinkText();
        Assert.assertEquals("Погода в Пензе", firstLikString);
    }
}
