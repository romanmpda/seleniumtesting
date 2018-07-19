package ru.yandex.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.pages.GeoPage;
import ru.yandex.pages.SearchPage;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings{
    public static WebDriver driver;
    public static SearchPage searchPage;
    public static GeoPage geoPage;
    public static String BASEURL="https://www.yandex.ru/";
    public static String FIRSTCITY="Пекин";
    public static String SECONDCITY="Кишинев";
    @BeforeClass
    public void  setup(){
        System.setProperty("webdriver.chrome.driver" ,"chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        geoPage = new GeoPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get (BASEURL);
    }
    
   @AfterClass
   public  void  close(){
        driver.quit();
    }
}
