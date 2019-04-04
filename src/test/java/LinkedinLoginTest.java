import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "linkedin.tst.yanina@gmail.com", "Mykola123" },
                { "linkedin.TST.yanina@gmail.com", "Mykola123" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        loginPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }

    @Test
    public void negativeWithEmptyValuesTest() {
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isTitleDisplayed(),
                "Start page title is wrong.");
    }


    @Test
    public void negativeWithValidUnregictredEmailTest() {
        loginPage.login("qwerty@gmail.com", "qwerty");
        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login pade is not loaded");
        Assert.assertEquals(loginSubmitPage.getUserEmailValidationMessage(), "","userEmail validation is incorect");
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationmessage(), "","userPassword validation message is incorrect");
 //       Assert.assertTrue(loginSubmitPage.isTextErrorMessage("Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку."),
 //               "Incorrect error message with valid unregictred Email");
    }

/*    @Test
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
*/

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



