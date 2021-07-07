import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CSSTableHW {

    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void tableTest(){
        WebElement italy = wd.findElement(By.cssSelector("table#customers tr:last-child td:last-child"));
        System.out.println(italy.getText());
    }

    @AfterMethod
    public void postCondition(){
        wd.quit();
    }
}
