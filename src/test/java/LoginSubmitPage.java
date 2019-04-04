import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {

    WebDriver driver;
    WebElement errorMessageEmail;
    WebElement errorMessagePassword;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        errorMessageEmail =
                driver.findElement(By.xpath("//div[@id='error-for-username']"));
        errorMessagePassword =
                driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isTextErrorMessage(String errorText){
        return  errorMessageEmail.getText().equals(errorText) ||
                errorMessagePassword.getText().equals(errorText);
    }
}