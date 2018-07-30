package ru.yandex.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.MarketPage;
import static ru.yandex.tests.SwitchCountTest.marketPage;

public class NavigationTest extends MarketPage {
    marketPage = new MarketPage(driver);


     @Test
    public void navigationTest() {
        
        marketPage.openPage(YANDEXHOMEURL);
		
        marketPage.clickList(searchPage.allLinks , 0);
        Assert.assertEquals(videoUrl, marketPage.getCurrentUrl());
        Assert.assertNotNull(searchPage.videoPagaWrapper);
        marketPage.clickElement(searchPage.yandexLink);
		
        marketPage.clickList(searchPage.allLinks , 1);
        Assert.assertEquals(imagesUrl, marketPage.getCurrentUrl());
        Assert.assertNotNull(searchPage.imagesPagaWrapper);
        marketPage.clickElement(searchPage.yandexFullLink);
		
        marketPage.clickList(searchPage.allLinks , 2);
        Assert.assertEquals(newsUrl, marketPage.getCurrentUrl());
        Assert.assertNotNull(searchPage.newsStories);
        marketPage.clickElement(searchPage.yandexFullLink);
		
        marketPage.clickList(searchPage.allLinks , 3);
        Assert.assertEquals(marketPage.getCurrentTitle(), mapsTitle);
        Assert.assertNotNull(searchPage.mapsZoom);
        marketPage.clickElement(searchPage.yandexFullLink);
		
        marketPage.clickList(searchPage.allLinks , 4);
        Assert.assertEquals(marketPage.getCurrentTitle(), marketTitle);
        Assert.assertNotNull(searchPage.marketNavigation);
        marketPage.clickElement(searchPage.yandexFullLink);
		
        marketPage.clickList(searchPage.allLinks , 5);
        Assert.assertEquals(marketPage.getCurrentUrl(), translateUrl);
        Assert.assertNotNull(searchPage.translateServoce);
        marketPage.clickElement(searchPage.yandexFullLink);
		
        marketPage.clickList(searchPage.allLinks , 6);
        Assert.assertEquals(marketPage.getCurrentUrl(), musicUrl);
        Assert.assertNotNull(searchPage.musicTabs);
        }


    @Test
    public void compareTest(){
        marketPage.goToMobileCategory();
		
        marketPage.moveToElementList(marketPage.goodsToCompare, 0);
        marketPage.clickList(marketPage.goodsToCompare, 0);
        Assert.assertNotNull(marketPage.compareButton);
        marketPage.moveToElementList(marketPage.goodsToCompare, 1);
        marketPage.clickList(marketPage.goodsToCompare, 1);
        Assert.assertNotNull(marketPage.compareButton);
        marketPage.moveToElement(marketPage.compareButton);
        marketPage.clickElement(marketPage.compareButton);
        marketPage.moveToElementList(marketPage.comparebaleGoodsCount, 0);
        marketPage.moveToElementList(marketPage.comparebaleGoodsCount, 1);
		
        marketPage.moveToElement(marketPage.removeButton);
        Assert.assertEquals(marketPage.getListSize(marketPage.comparebaleGoodsCount), GOODSCOUNT);
        marketPage.clickElement(marketPage.removeButton);
        Assert.assertNotNull(marketPage.emptyContent);
    }
	    @Test
    public void sortPriceTest(){
        marketPage.goToMobileCategory();
        marketPage.clickList(marketPage.sorterFilters, 0);
        marketPage.scrollToElement(marketPage.toClick);
        List<String> notSortedPrice =marketPage.getTextList(marketPage.pricesAll);
        List<String> sortedPrice = notSortedPrice;
        Collections.sort(sortedPrice);
        Assert.assertNotNull(marketPage.priceIsSelected);
        Assert.assertEquals(sortedPrice, notSortedPrice);

    }
	    @Test
    public void switchCountTest() {
        marketPage.goToMobileCategory();
        marketPage.scrollToElementJS(marketPage.showBotton);
        marketPage.moveToElement(marketPage.showBotton);
        marketPage.clickElement(marketPage.showBotton);
        List<String> list48=marketPage.getTextList(marketPage.selectText);
        Integer id48=list48.indexOf(SHOW48);
        marketPage.clickList(marketPage.selectText, id48);
        marketPage.scrollToElementJS(searchPage.yandexFullLink);
        Assert.assertEquals(marketPage.getListSize(marketPage.elementsCount),SORTCOUNT48);
        marketPage.scrollToElementJS(marketPage.showBotton);
        marketPage.moveToElement(marketPage.showBotton);
        marketPage.clickElement(marketPage.showBotton);
        List<String> list12=marketPage.getTextList(marketPage.selectText);
        Integer id12=marketPage.compareTextInList(list12,SHOW12);
        marketPage.clickList(marketPage.selectText, id12);
        marketPage.scrollToElementJS(searchPage.yandexFullLink);
        Assert.assertEquals(marketPage.getListSize(marketPage.elementsCount),SORTCOUNT12);

    }
}
