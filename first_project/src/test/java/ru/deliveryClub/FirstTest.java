package ru.deliveryClub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;



public class FirstTest extends WebDriverSettings{

@Test
    public void simpleTest() {
        driver.get ("https://www.yandex.ru/");
        WebElement inputField = driver.findElement(By.id("text"));
        inputField.clear();
        inputField.sendKeys("погода пенза");
        WebElement submitButton = driver.findElementByCssSelector(".search2__button [data-bem]");
        submitButton.click();
        WebElement firstLink = driver.findElementByCssSelector(".serp-item:nth-child(4) .organic__url-text .needsclick:nth-of-type(1)");
        String firstLikString = firstLink.getText();
        Assert.assertEquals("погода", firstLikString);






    }

}
