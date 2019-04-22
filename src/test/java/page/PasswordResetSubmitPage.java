package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;

import static java.lang.Thread.sleep;

public class PasswordResetSubmitPage extends BasePage{

    @FindBy(xpath = "//button[@id ='reset-password-submit-button']")
    private  WebElement confirmButton;

    public PasswordResetSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage(){
        confirmButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  new HomePage(driver);
    }

    public boolean iaPageLoaded() {
        return driver.getTitle().contains("/password-reset-submit");
    }
}