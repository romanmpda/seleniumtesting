package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.MarketPage;
import ru.yandex.pages.SearchPage;
import static ru.yandex.tests.SearchTest.searchPage;
import static ru.yandex.tests.SwitchCountTest.marketPage;

public class NavigationTest extends WebDriverSettings {
    private static String videoUrl = "https://yandex.ru/video/";
    private static String imagesUrl = "https://yandex.ru/images/";
    private static String newsUrl = "https://news.yandex.ru/";
    private static String mapsTitle = "Яндекс.Карты — выбирайте, где поесть, куда сходить, чем заняться";
    private static String marketTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";
    private static String translateUrl = "https://translate.yandex.ru/";
    private static String musicUrl = "https://music.yandex.ru/";
    public static Integer GOODSCOUNT=2;
    public static MarketPage marketPage;
    public static Integer SORTCOUNT12 = 12;
    public static Integer SORTCOUNT48 = 48;
    public static String SHOW12 ="Показывать по 12";
    public static String SHOW48 ="Показывать по 48";
	
	searchPage = new SearchPage(driver);
	marketPage = new MarketPage(driver);


    @Test
    public void navigationTest() {
        
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


    @Test
    public void compareTest(){
        marketPage.goToMobileCategory();
		
        basePage.moveToElementList(marketPage.goodsToCompare, 0);
        basePage.clickList(marketPage.goodsToCompare, 0);
        Assert.assertNotNull(marketPage.compareButton);
        basePage.moveToElementList(marketPage.goodsToCompare, 1);
        basePage.clickList(marketPage.goodsToCompare, 1);
        Assert.assertNotNull(marketPage.compareButton);
        basePage.moveToElement(marketPage.compareButton);
        basePage.clickElement(marketPage.compareButton);
        basePage.moveToElementList(marketPage.comparebaleGoodsCount, 0);
        basePage.moveToElementList(marketPage.comparebaleGoodsCount, 1);
		
        basePage.moveToElement(marketPage.removeButton);
        Assert.assertEquals(basePage.getListSize(marketPage.comparebaleGoodsCount), GOODSCOUNT);
        basePage.clickElement(marketPage.removeButton);
        Assert.assertNotNull(marketPage.emptyContent);
    }
	    @Test
    public void sortPriceTest(){
        marketPage.goToMobileCategory();
        basePage.clickList(marketPage.sorterFilters, 0);
        basePage.scrollToElement(marketPage.toClick);
        List<String> notSortedPrice =basePage.getTextList(marketPage.pricesAll);
        List<String> sortedPrice = notSortedPrice;
        Collections.sort(sortedPrice);
        Assert.assertNotNull(marketPage.priceIsSelected);
        Assert.assertEquals(sortedPrice, notSortedPrice);

    }
	    @Test
    public void switchCountTest() {
        marketPage.goToMobileCategory();
	    
        basePage.scrollToElementJS(marketPage.showBotton);
        basePage.moveToElement(marketPage.showBotton);
        basePage.clickElement(marketPage.showBotton);
        List<String> list48=basePage.getTextList(marketPage.selectText);
        Integer id48=list48.indexOf(SHOW48);
        basePage.clickList(marketPage.selectText, id48);
        basePage.scrollToElementJS(searchPage.yandexFullLink);
        Assert.assertEquals(basePage.getListSize(marketPage.elementsCount),SORTCOUNT48);
	    
        basePage.scrollToElementJS(marketPage.showBotton);
        basePage.moveToElement(marketPage.showBotton);
        basePage.clickElement(marketPage.showBotton);
        List<String> list12=basePage.getTextList(marketPage.selectText);
        Integer id12=basePage.compareTextInList(list12,SHOW12);
        basePage.clickList(marketPage.selectText, id12);
        basePage.scrollToElementJS(searchPage.yandexFullLink);
        Assert.assertEquals(basePage.getListSize(marketPage.elementsCount),SORTCOUNT12);

    }
}
