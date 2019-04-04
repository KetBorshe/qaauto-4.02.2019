import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver;

    WebElement emailField;
    WebElement passwordField;
    WebElement singInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initElements();

    }
    public void initElements(){
        emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public void login(String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        singInButton.click();

    }

    public boolean isPageLoaded() {
        return singInButton.isDisplayed();
    }

    public boolean isTitleDisplayed() {
        return  driver.getTitle().equals("LinkedIn: Войти или зарегистрироваться");
    }

}
