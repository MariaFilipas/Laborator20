import org.openqa.selenium.WebElement;
import org.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SearchResultsTests extends BaseTest {

    private String homePageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=common/home";
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + homePageUrl);
        driver.get(homePageUrl);
        driver.manage().window().fullscreen();
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void searchProductSuccessfullTest() throws InterruptedException {
        searchResultsPage.enterTextToSearch("Nikon D300");

        searchResultsPage.clickSearchButton();
        List<WebElement> results = searchResultsPage.getResults("Nikon D300");
        int actualResults = results.size();
        int expectedResults = 2;
        Assert.assertEquals(actualResults, expectedResults);
    }

@Test
public void searchProductUnsuccessfullTest() throws InterruptedException {

    searchResultsPage.enterTextToSearch("Nikon D500");

    searchResultsPage.clickSearchButton();

   List<WebElement> results = searchResultsPage.getResults("Nikon D500");
   int actualResults = results.size();
   int expectedResults = 0;
   Assert.assertEquals(actualResults, expectedResults);
}
}
