package ss.com;

import org.openqa.selenium.WebDriver;

public class CategoryPage extends AbstractPage{
    private WebDriver driver;

    CategoryPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

}
