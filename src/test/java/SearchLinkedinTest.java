import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] DataProvider() {
        return new Object[][]{
                {"ketborshe@gmail.com", "2512Kate"}
        };
    }
    @Test(dataProvider = "DataProvider")
    public void searchTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded.");
        HomePage homePage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
        SearchResultPage searchResultPage = homePage.searchByWord();
        Assert.assertTrue(searchResultPage.isPageLoaded(), "Login page was not loaded.");

//
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='search-result__wrapper']"));
        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults) {
            String searchResultString = searchResult.getText();
            System.out.println(searchResult.getText());
            if (searchResultString.toLowerCase().contains(homePage.searchTerm.toLowerCase())) {
                System.out.println("SearchTerm found");
            } else {
                System.out.println("SearchTerm No Found");
            }
        }
    }
}

