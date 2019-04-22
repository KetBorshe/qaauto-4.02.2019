package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class PasswordResetPage extends BasePage{

    String newPassword = "@@@2512Kate";

    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@id ='reset-password-submit-button']")
    private  WebElement confirmButton;



    public PasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean iaPageLoaded() {
        return driver.getTitle().contains("/checkpoint/rp/password-reset");
    }

    public PasswordResetSubmitPage fillPasswordForm(String newPassword){
        password.sendKeys(newPassword);
        confirmPassword.sendKeys(newPassword);
        confirmButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  new PasswordResetSubmitPage(driver);

    }

}
