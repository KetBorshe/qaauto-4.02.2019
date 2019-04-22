package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SingInGooglePagePassword extends BasePage{

    String password = "@@@2512Kate";

    @FindBy(xpath ="//input[@name='password']" )
    private WebElement passwordField;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement buttonNext;

    public SingInGooglePagePassword(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MailPage singInStepPassword(String password){
        passwordField.sendKeys(password);
        buttonNext.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MailPage(driver);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("/signin/v2/sl/pwd");
    }
}
