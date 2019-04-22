package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class MailPage extends BasePage {

    @FindBy(xpath = "//tbody[/tr]")
    private WebElement letterField;

    @FindBy(xpath = "//a[@target ='blank']")
    private WebElement letterLink;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("/mail");
    }
    public MailPage openLetter(){
        letterField.click();
        return new MailPage(driver);
    }

    //Find other title or button in the Letter
    public boolean isLetterOpen() {
        return driver.getTitle().contains("/mail");
    }

    public PasswordResetPage clickLetterLink(){
        letterLink.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new PasswordResetPage(driver);
    }
}
