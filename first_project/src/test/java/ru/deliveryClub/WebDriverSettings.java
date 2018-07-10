package ru.deliveryClub;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;




public class WebDriverSettings
{
    public ChromeDriver driver;
@BeforeTest
    public void  setUp()
    {
        System.setProperty("webdriver.chrome.driver" ,"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

   @AfterTest public  void  close()
    {
        driver.quit();
    }
}
