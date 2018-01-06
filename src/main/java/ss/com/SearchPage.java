package ss.com;

import org.openqa.selenium.By;
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

    @FindBy(id = "f_o_8_min")
    WebElement minPriceInput;

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

    public SearchPage enterMinPrice(String minPrice) {
        //WebElement minPriceInput = driver.findElement(By.id ("f_o_8_min"));
        minPriceInput.clear();
        minPriceInput.sendKeys(minPrice);
        return this;
    }

    public SearchPage selectSerialFilter(int index) {
        Select SerijaFilter = new Select(driver.findElement(By.id("f_o_6")));
        SerijaFilter.selectByIndex(index);
        return this;
    }

    public SearchPage enterMaxFloor(String maxFloor) {
        WebElement maxFloorInput = driver.findElement(By.id ("f_o_4_max"));
        maxFloorInput.clear();
        maxFloorInput.sendKeys(maxFloor);
        return this;
    }

    public SearchPage enterMinFloor(String minFloor) {
        WebElement minFloorInput = driver.findElement(By.id ("f_o_4_min"));
        minFloorInput.clear();
        minFloorInput.sendKeys(minFloor);
        return this;
    }

    public SearchPage enterMaxSize(String maxSize) {
        WebElement maxSizeInput = driver.findElement(By.id ("f_o_3_max"));
        maxSizeInput.clear();
        maxSizeInput.sendKeys(maxSize);
        return this;
    }

    public SearchPage enterMinSize(String minSize) {
        WebElement minSizeInput = driver.findElement(By.id ("f_o_3_min"));
        minSizeInput.clear();
        minSizeInput.sendKeys(minSize);
        return this;
    }

    public SearchPage selectMaxRoomFilter(int index) {
        Select RoomsFilterMax = new Select(driver.findElement(By.name("topt[1][max]")));
        RoomsFilterMax.selectByIndex(index);
        return this;
    }

    public SearchPage selectMinRoomFilter(int index) {
        Select RoomsFilterMin = new Select(driver.findElement(By.id("f_o_1")));
        RoomsFilterMin.selectByIndex(index);
        return this;
    }

}

