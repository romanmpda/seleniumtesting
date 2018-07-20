package ru.yandex.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
	
public class BasePage {
	public BasePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
        this.driver = driver;
   }

	public static BasePage basePage;
	
	public void getUrl{
	Public String urlGet;
	driver.get (urlGet);
	}