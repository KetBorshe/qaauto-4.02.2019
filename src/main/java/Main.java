import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        WebElement fieldEmail = driver.findElement(By.xpath("//*[@id='login-email']"));
        WebElement fieldPass = driver.findElement(By.xpath("//*[@id='login-password']"));
        fieldEmail.sendKeys("ketborshe@gmail.com");
        fieldPass.sendKeys("2512Kate");
        fieldPass.sendKeys(Keys.ENTER);
        List<WebElement> trueLogin = driver.findElements(By.xpath("//*[@id='emberl']"));
        if (trueLogin.isEmpty()){
            System.out.println("ERROR");
        }
        else {
            trueLogin.get(0).isDisplayed();
            System.out.println(trueLogin.get(0).isDisplayed());
        }
    }
}
