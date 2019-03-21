import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        String searchTerm ="Selenium";
        //System.out.println("Hello World!!!");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        // new Actions(driver).sendKeys("selenium").sendKeys(Keys.ENTER).perform();
        // driver.quit();
        // WebElement searchField = driver.findElement(By.name("q"));
        WebElement searchField = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println(searchResults.size());

        //For each Webelement in resultsList print Text
        for (WebElement searchResult : searchResults) {
            String searchResultString = searchResult.getText();
            System.out.println(searchResult.getText());
            if (searchResultString.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("SearchTerm found");
            } else {
                System.out.println("SearchTerm No Found");
            }
        }
            /*if (searchResult.getText().contains("Selenium")){
                System.out.println("Result nice");
            }
            else {
                System.out.println("Result NOT FIND");
            }*/
    }
        /*
        for (int i=0; i< searchResults.size(); i++){
            System.out.println("result " + i);
            System.out.println(searchResults.get(i).getText());
        }
        */

}

