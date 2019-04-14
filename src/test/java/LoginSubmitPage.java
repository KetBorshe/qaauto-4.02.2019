import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSubmitPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='error-for-password']")
    private WebElement userPasswordValidationmessage;

    @FindBy(xpath = "//div[@id='error-for-password']")
    private WebElement userEmailValidationMessage;

    @FindBy(xpath = "//form[@action='checkpoint/lg/login-submit']")
    private WebElement loginSubmitForm;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return loginSubmitForm.isDisplayed();
    }

    public String getUserEmailValidationMessage() {
        return userEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationmessage() {
        return userPasswordValidationmessage.getText();
    }
}