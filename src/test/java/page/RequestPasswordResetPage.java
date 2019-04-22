package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CheckpointRequestPage;

import static java.lang.Thread.sleep;

public class RequestPasswordResetPage extends BasePage{

    String email = "ketborshe@gmail.com";

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;

    public RequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("/request-password-reset");
    }

    public CheckpointRequestPage fillForm(String email) {
        emailField.sendKeys(email);
        submitButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckpointRequestPage(driver);

    }

}
