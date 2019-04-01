import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        WebElement emailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("ketborshe@gmail.com");
        passwordField.sendKeys("2512Kate");
        singInButton.click();

        WebElement profileNavigationItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        profileNavigationItem.isDisplayed();
        Assert.assertTrue(profileNavigationItem.isDisplayed(),
                "ProfileNavigation item is not displayed on Home page");
        Assert.assertEquals(driver.getTitle(),"LinkedIn", "Home page title is wrong");

        driver.quit();
    }

    @Test
    public void negativeWithEmptyValuesTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        WebElement emailField =
                driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField =
                driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton =
                driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("");
        passwordField.sendKeys("");
        signInButton.click();
        Assert.assertEquals(driver.getTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Start page title is wrong.");

        driver.quit();

    }

    @Test
    public void negativeWithInvalidEmailValuesTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        WebElement emailField =
                driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField =
                driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton =
                driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("qwerty");
        passwordField.sendKeys("qwerty");
        signInButton.click();
        WebElement errorMessage =
                driver.findElement(By.xpath("//div[@id='error-for-username']"));
        Assert.assertEquals(errorMessage.getText(), "Укажите действительный адрес эл. почты.",
                "Incorrect error message with invalid Email");

        driver.quit();

    }

    @Test
    public void negativeWithValidUnregictredEmailValuesTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        WebElement emailField =
                driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField =
                driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton =
                driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("qwerty@gmail.com");
        passwordField.sendKeys("qwerty");
        signInButton.click();
        WebElement errorMessage =
                driver.findElement(By.xpath("//div[@id='error-for-username']"));
        Assert.assertEquals(errorMessage.getText(), "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
                "Incorrect error message with valid unregictred Email");

        driver.quit();

    }

    @Test
    public void negativeWithValidInvalidPaswordValuesTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        WebElement emailField =
                driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordField =
                driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton =
                driver.findElement(By.xpath("//input[@id='login-submit']"));

        emailField.sendKeys("linkedin.tst.yanina@gmail.com");
        passwordField.sendKeys("qwerty");
        signInButton.click();
        WebElement errorMessagePassword =
                driver.findElement(By.xpath("//div[@id='error-for-password']"));
        Assert.assertEquals(errorMessagePassword.getText(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Incorrect error message with invalid Password");

        driver.quit();

    }


}


