package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SingInGooglePage extends BasePage{

    String email = "ketborshe@gmail.com";

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement emailGoogleField;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement buttonNextGoogle;


    public SingInGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("/signin");
    }

    public SingInGooglePagePassword fillGoogleForm(String email){
        emailGoogleField.sendKeys(email);
        buttonNextGoogle.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  new SingInGooglePagePassword(driver);
    }
}