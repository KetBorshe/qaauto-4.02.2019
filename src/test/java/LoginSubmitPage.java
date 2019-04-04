import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {

    private WebDriver driver;
//    WebElement errorMessageEmail;
//    WebElement errorMessagePassword;
    private WebElement userPasswordValidationmessage;
    private WebElement userEmailValidationMessage;
    private WebElement loginSubmitForm;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        userPasswordValidationmessage =  driver.findElement(By.xpath("//div[@id='error-for-password']"));
        userEmailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        loginSubmitForm = driver.findElement(By.xpath("//form[@action='checkpoint/lg/login-submit']"));
 /*       errorMessageEmail =
                driver.findElement(By.xpath("//div[@id='error-for-username']"));
        errorMessagePassword =
                driver.findElement(By.xpath("//div[@id='error-for-password']"));
  */  }

//    public boolean isTextErrorMessage(String errorText){
//        return  errorMessageEmail.getText().equals(errorText) ||
//                errorMessagePassword.getText().equals(errorText);
//    }

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