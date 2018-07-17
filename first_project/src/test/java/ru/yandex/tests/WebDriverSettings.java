package ru.yandex.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.pages.SearchPage;

import java.util.concurrent.TimeUnit;





public class WebDriverSettings
{

   //public ChromeDriver driver;
    public  static WebDriver driver;
    public static SearchPage searchPage;
//@BeforeTest
    @BeforeClass
    public void  setup()
    {

        System.setProperty("webdriver.chrome.driver" ,"chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get ("https://www.yandex.ru/");

    }




   //@AfterTest
   @AfterClass
   public  void  close()
    {
        driver.quit();
    }
}
