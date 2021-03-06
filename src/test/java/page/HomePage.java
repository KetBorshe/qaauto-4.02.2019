package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.Thread.sleep;


public class HomePage extends BasePage {

    @FindBy (xpath ="//li[@id='profile-nav-item']" )
    private WebElement profileNavigationItem;

    @FindBy (xpath = "(//form[@id='extended-nav-search']//input)" )
    private  WebElement searchField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return profileNavigationItem.isDisplayed()
                && driver.getTitle().contains("Linked");
    }
    public SearchResultPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchResultPage(driver);
    }


}


