package ru.yandex.tests;


public class NavigationTest extends WebDriverSettings {

@Test
    public void switchCountTest() {
		searchPage = new SearchPage(driver);
        basePage.openPage(YANDEXHOMEURL);
        searchPage.clickAllLinks(4);
		basePage.clickElement(searchPage.electroniksLink);
		basePage.clickElement(searchPage.buttonListbox);  
		basePage.clickList(.select__text, 0);
		Assert.assertEquals(12, .n-snippet-cell2__header );
	}
}