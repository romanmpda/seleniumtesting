package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.SearchPage;
import static ru.yandex.tests.SearchTest.searchPage;

public class NavigationTest extends WebDriverSettings {
    private static String videoUrl = "https://yandex.ru/video/";
    private static String imagesUrl = "https://yandex.ru/images/";
    private static String newsUrl = "https://news.yandex.ru/";
    private static String mapsTitle = "Яндекс.Карты — выбирайте, где поесть, куда сходить, чем заняться";
    private static String marketTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";
    private static String translateUrl = "https://translate.yandex.ru/";
    private static String musicUrl = "https://music.yandex.ru/";


    @Test
    public void navigationTest() {
        searchPage = new SearchPage(driver);
        basePage.openPage(YANDEXHOMEURL);
        basePage.clickList(searchPage.allLinks , 0);
        Assert.assertEquals(videoUrl, basePage.getCurrentUrl());
        Assert.assertNotNull(searchPage.videoPagaWrapper);
        basePage.clickElement(searchPage.yandexLink);
        basePage.clickList(searchPage.allLinks , 1);
        Assert.assertEquals(imagesUrl, basePage.getCurrentUrl());
        Assert.assertNotNull(searchPage.imagesPagaWrapper);
        basePage.clickElement(searchPage.yandexFullLink);
        basePage.clickList(searchPage.allLinks , 2);
        Assert.assertEquals(newsUrl, basePage.getCurrentUrl());
        Assert.assertNotNull(searchPage.newsStories);
        basePage.clickElement(searchPage.yandexFullLink);
        basePage.clickList(searchPage.allLinks , 3);
        Assert.assertEquals(basePage.getCurrentTitle(), mapsTitle);
        Assert.assertNotNull(searchPage.mapsZoom);
        basePage.clickElement(searchPage.yandexFullLink);
        basePage.clickList(searchPage.allLinks , 4);
        Assert.assertEquals(basePage.getCurrentTitle(), marketTitle);
        Assert.assertNotNull(searchPage.marketNavigation);
        basePage.clickElement(searchPage.yandexFullLink);
        basePage.clickList(searchPage.allLinks , 5);
        Assert.assertEquals(basePage.getCurrentUrl(), translateUrl);
        Assert.assertNotNull(searchPage.translateServoce);
        basePage.clickElement(searchPage.yandexFullLink);
        basePage.clickList(searchPage.allLinks , 6);
        Assert.assertEquals(basePage.getCurrentUrl(), musicUrl);
        Assert.assertNotNull(searchPage.musicTabs);
        }
}
