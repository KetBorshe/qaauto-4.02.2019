package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class CheckpointRequestPage extends BasePage {

    public SingInGooglePage openNewMailTab(){
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText("https://mail.google.com")).sendKeys(selectLinkOpeninNewTab);
        ArrayList<String> tabs = new ArrayList<String>
                (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  new SingInGooglePage(driver);
    }

    public CheckpointRequestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("/request-password-reset-submit");
    }

}