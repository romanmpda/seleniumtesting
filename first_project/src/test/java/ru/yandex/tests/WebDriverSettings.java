package ru.yandex.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.pages.BasePage;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings{
    public static WebDriver driver;
    public static BasePage basePage;
    public static String YANDEXHOMEURL="https://www.yandex.ru/";
    public static String CHROMEDRIVERLOCATION = "chromedriver.exe";


    @BeforeClass
    public void  setup(){
        System.setProperty("webdriver.chrome.driver" ,CHROMEDRIVERLOCATION);
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    
   @AfterClass
   public  void  close(){
        driver.quit();
    }
}
