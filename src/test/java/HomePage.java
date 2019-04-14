import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    String searchTerm ="HR";

    @FindBy (xpath ="//li[@id='profile-nav-item']" )
    private WebElement profileNavigationItem;

    @FindBy (xpath = "(//input[@role='combobox'] )" )
    private  WebElement searchImput;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return profileNavigationItem.isDisplayed()
                && driver.getTitle().contains("Linked");
    }
    public SearchResultPage searchByWord(){
        searchImput.sendKeys(searchTerm);
        searchImput.sendKeys(Keys.ENTER);
        return null;
    }
}


