package ss.com;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "categoryTest")
    public Object[][] createData() {
        return new Object[][] {
                { "real-estate", "Real Estate not opened" },
                { "transport" , "Transpot page not opened"},
        };
    }


}
