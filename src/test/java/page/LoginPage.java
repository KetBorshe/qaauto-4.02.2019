package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//input[@id='login-email']")
    private WebElement emailField;

    @FindBy (xpath = "//input[@id='login-password']")
    private WebElement passwordField;

    @FindBy (xpath = "//input[@id='login-submit']")
    private WebElement singInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <GenericPage> GenericPage login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        singInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) PageFactory.initElements(driver, HomePage.class);
        }
        if (driver.getCurrentUrl().contains("/login-submit")) {
            return (GenericPage) new LoginSubmitPage(driver);
        }
        else {
            return (GenericPage) new LoginPage(driver);
        }

    }

    public boolean isPageLoaded() {
        return singInButton.isDisplayed();
    }

    public boolean isTitleDisplayed() {
        return  driver.getTitle().equals("LinkedIn: Войти или зарегистрироваться");
    }

    public RequestPasswordResetPage changePassword(){
        forgotPasswordButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new RequestPasswordResetPage(driver);
    }


}
