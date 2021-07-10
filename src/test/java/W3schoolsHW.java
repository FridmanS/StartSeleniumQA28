import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class W3schoolsHW {

    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void w3SchoolsTest() {
        int numberOfRows = wd.findElements(By.cssSelector("#customers tr")).size();
        int numbersOfColumns = wd.findElements(By.cssSelector("#customers tr:first-child th")).size();
        System.out.printf("Rows: %d \nColumns: %d\n", numberOfRows, numbersOfColumns);
        System.out.println("===========================================================================");

        for(WebElement el : wd.findElements(By.cssSelector("#customers tr:nth-child(3) td"))){
            System.out.print("|" + el.getText() + "|");
        }
        System.out.println("\n===========================================================================");

        for(WebElement el : wd.findElements(By.cssSelector("#customers tr :last-child"))){
            System.out.println(el.getText());
        }
        System.out.println("===========================================================================");

        System.out.println(wd.findElement(By.cssSelector("#customers tr:nth-child(2) td:nth-child(2)")).getText());
    }

    @AfterMethod
    public void postCondition(){
        wd.quit();
    }
}
