import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IndexCss {

    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("file:///D:/Downloads/index.html");
    }

    @Test
    public void itemTest(){
        WebElement item1 = wd.findElement(By.cssSelector("#nav ul li:first-child"));
        item1.click();
        String item1Text = item1.getText();

        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        String alertText = alert.getText();

        /*if(alertText.contains(item1Text)){
            System.out.println("Test passed");
        } else{
            System.out.println("Test failed");
        }*/

        Assert.assertTrue(alertText.contains(item1Text));
    }

    @Test
    public void formsTest(){
        WebElement name = wd.findElement(By.name("name"));
        WebElement surename = wd.findElement(By.cssSelector("[name='surename']"));
        name.click();
        name.clear();
        name.sendKeys("Sergey");
        surename.click();
        surename.clear();
        surename.sendKeys("Fridman");
        wd.findElement(By.cssSelector(".btn")).click();

        Assert.assertEquals(wd.findElement(By.cssSelector("#alert")).getText(), "Sergey Fridman");
    }

    @Test
    public void tableTest(){
        List<WebElement> rows = wd.findElements(By.cssSelector("#country-table tr"));
        int numberOfRows = rows.size();
        System.out.println("Rows in table:" + numberOfRows);

        List<WebElement> colunns = wd.findElements(By.cssSelector("tr:first-child td"));
        System.out.println("Colunns in table:" + colunns.size());

        String text = wd.findElement(By.cssSelector("tr:last-child td:nth-child(2)")).getText();
        Assert.assertEquals(text, "Chine");

        List<WebElement> lastRow = wd.findElements(By.cssSelector("tr:last-child td"));
        for(WebElement el : lastRow){
            System.out.print(el.getText() + " ");
        }
    }

    @AfterMethod
    public void postCondition(){
        wd.quit();
    }
}
