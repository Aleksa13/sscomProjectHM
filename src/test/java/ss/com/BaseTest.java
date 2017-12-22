package ss.com;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected ChromeDriver driver;
    protected MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void setUp()
    {
        // Open chrome browser
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        // Maximize window
        driver.manage().window().maximize();
        // Set timeouts
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @BeforeMethod(alwaysRun = true)
    public void openMainPage() throws InterruptedException {
        //Open ss.com page
        mainPage = new MainPage(driver);
        mainPage.open("https://www.ss.com/");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        // close Browser
        driver.quit();
    }

}
