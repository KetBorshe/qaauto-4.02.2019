package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage{

    String searchTerm = "Human Resources";

    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/search/results/all/");
    }

    public int getSearchResultsCount(){
        return  searchResults.size();
    }

    public List<String> getSearchResults() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResult : searchResults){

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResult);
            String searchResultText = searchResult.getText();
            searchResultList.add(searchResultText);
        }
        return searchResultList;
    }


 /*   public int getValidSearchResultsCount() {
        int validationCount = 0;
        for (WebElement searchResult : searchResults) {
            String searchResultString = searchResult.getText().toLowerCase();
            if (searchResultString.contains(searchTerm.toLowerCase())) {
                validationCount++;
            }
        }
        return validationCount;
    }
*/
}