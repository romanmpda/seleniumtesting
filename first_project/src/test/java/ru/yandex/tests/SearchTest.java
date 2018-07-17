package ru.yandex.tests;


import org.testng.Assert;
import org.testng.annotations.Test;



public class SearchTest extends WebDriverSettings {


@Test
    public void searchTest() {


        searchPage.clearInputField();
        searchPage.inputSearchText("погода пенза");
        searchPage.clickSearchButton();
        String firstLikString = searchPage.grtFirstLinkText();
        Assert.assertEquals("Погода в Пензе", firstLikString);






    }

}
