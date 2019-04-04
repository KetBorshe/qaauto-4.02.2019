import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        loginPage.login("ket@gmail.com", "123456");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");

        driver.quit();
    }

    @Test
    public void negativeWithEmptyValuesTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");
        Assert.assertTrue(loginPage.isTitleDisplayed(),
                "Start page title is wrong.");

        driver.quit();
    }


    @Test
    public void negativeWithValidUnregictredEmailTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("qwerty@gmail.com", "qwerty");
        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);

        Assert.assertTrue(loginSubmitPage.isTextErrorMessage("Этот адрес " +
                        "эл. почты не зарегистрирован в LinkedIn. Повторите попытку."),
                "Incorrect error message with valid unregictred Email");

        driver.quit();

    }

    @Test
    public void negativeWithInvalidPaswwordValuesTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("ket@gmail.com", "qwerty");
        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);

        Assert.assertTrue(loginSubmitPage.isTextErrorMessage("Это неверный пароль." +
                        " Повторите попытку или измените пароль."),
                "Incorrect error message with invalid Password");

        driver.quit();

    }


}

    /*
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

        emailField.sendKeys("qwerty@gmail.com");
        passwordField.sendKeys("qwerty");
        signInButton.click();
        WebElement errorMessage =
driver.findElement(By.xpath("//div[@id='error-for-username']"));
        Assert.assertEquals(errorMessage.getText(), "Укажите
действительный адрес эл. почты.. Повторите попытку.",
                "Incorrect error message with invalid Email");

        driver.quit();

    }
    */



