package ss.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SSComTest extends BaseTest{

    @Test
    public void mainPageTest(){
        String url = mainPage.getUrl();
        assertEquals(url, "https://www.ss.com/", "ss.com page opened fail");
    }

    @Test (dataProvider = "categoryTest", dataProviderClass = TestDataProvider.class)
    public void testRealEstateCategory(String categoryName, String errorMsg) throws InterruptedException {
        String url = mainPage
                .clickCategoryLink(categoryName)
                .getUrl();
        assertTrue(url.endsWith(categoryName+"/"), errorMsg);
    }

    @Test
    public void searchTodayFlatTest() throws InterruptedException {
        int size = ((SearchPage) new SearchPage(driver).open("https://www.ss.com/lv/real-estate/flats/riga/centre/"))
                .selectDaysFilter(1)
                .enterMaxPrice("10")
                .search()
                .getArticles()
                .size();

        assertEquals(size, 1, "More than one result found");
    }

    @Test
    public void searchTodayFlatTest2 () throws InterruptedException {
        //open page

         int size= ((SearchPage) new SearchPage(driver).open("https://www.ss.com/lv/real-estate/flats/riga/centre/"))
                .selectDaysFilter(1)
                .enterMaxPrice("100")
                .enterMinPrice("50")
                .selectMinRoomFilter(1)
                .selectMaxRoomFilter(5)
                .enterMinSize("27")
                .enterMaxSize("70")
                .enterMinFloor("3")
                .enterMaxFloor("5")
                .selectSerialFilter(8)
                 .search()
                 .getArticles()
                 .size();


        //check that only 1 is found
        // List<WebElement> searchResults = driver.findElements(By.cssSelector("#filter_frm table:nth-child(3) tr input[type='checkbox']"));
        assertEquals(size,2,"More than 2 were found");



    }




}

