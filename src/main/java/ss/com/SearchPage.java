package ss.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(id = "today_cnt_sl")
    private WebElement dayFilter;

    @FindBy(id = "f_o_8_max")
    private WebElement maxPriceElement;

    @FindBy(css = "#filter_tbl > tbody > tr > td:nth-child(2) > input")
    private WebElement searchButton;

    @FindBy(css = "#filter_frm table:nth-child(3) tr input[type='checkbox']")
    private List<WebElement> checkboxes;

    private WebDriver driver;

    SearchPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public SearchPage selectDaysFilter(int index){
        Select daysFilter = new Select(dayFilter);
        daysFilter.selectByIndex(index);
        return this;
    }

    public SearchPage enterMaxPrice(String price){
        // max price 10
        WebElement maxPriceInput = maxPriceElement;
        maxPriceInput.clear();
        maxPriceInput.sendKeys(price);
        return this;
    }

    public SearchPage search() throws InterruptedException {
        searchButton.click();
        Thread.sleep(2000);
        return this;
    }

    public List<WebElement> getArticles(){
        return checkboxes;
    }

}
