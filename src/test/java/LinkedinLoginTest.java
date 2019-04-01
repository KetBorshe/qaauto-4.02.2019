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
    public void negativeWithEmptyValuesTest(){

    }
}
