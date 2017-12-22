package ss.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends AbstractPage{
    private WebDriver driver;

    MainPage(WebDriver driver){
        super(driver);
        this.driver =driver;
    }


    public CategoryPage clickCategoryLink(String categoryName) throws InterruptedException {
        WebElement link = driver.findElement(By.cssSelector("h2 > a[href*='"+categoryName+"']"));
        // Click link
        link.click();
        //wait page load for 2sec
        Thread.sleep(2000);
        return new CategoryPage(driver);
    }
}
