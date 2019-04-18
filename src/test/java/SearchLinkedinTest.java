import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class SearchLinkedinTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void basicSearchTest() {
        String userEmail = "linkedin.TST.yanina@gmail.com";
        String userPassword ="Test123!";
        String searchTerm = "HR";
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

        SearchResultPage searchResultPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultPage.isPageLoaded(), "Search page was not loaded.");

        Assert.assertEquals(searchResultPage.getSearchResultsCount(), 10,
                        "Result count is wrong");
        List<String> searchResults = searchResultPage.getSearchResults();
        for(String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm),"searchTerm: " +searchTerm + " not found in : \n " +searchResult);
        }

    }
}
