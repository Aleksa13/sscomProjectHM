package ss.com;

import org.testng.annotations.*;


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

}
