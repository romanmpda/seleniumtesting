package ru.yandex.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.pages.BasePage;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings{
    public static WebDriver driver;
    public static BasePage basePage;
    public static String YANDEXHOMEURL="https://www.yandex.ru/";
    public static Integer PAGELOADTIMEOUT = 20;


    @BeforeClass
    public void  setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGELOADTIMEOUT, TimeUnit.SECONDS);
    }
    
   @AfterClass
   public  void  close() {
        driver.quit();
    }
}
