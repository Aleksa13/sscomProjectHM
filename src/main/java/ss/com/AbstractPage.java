package ss.com;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    private WebDriver driver;

    AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public AbstractPage open(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        return this;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
