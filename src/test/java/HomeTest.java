import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest {

    WebDriver wd;

    @BeforeMethod
    public void preCondotion() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test
    public void homeWorkTest() throws InterruptedException {
        List<WebElement> list = wd.findElements(By.tagName("a"));
        WebElement about = list.get(1);
        WebElement home = list.get(0);
        about.click();
        Thread.sleep(3000);
        home.click();
    }

    @Test
    public void locatorTest(){
        List<WebElement> list = wd.findElements(By.tagName("a"));
        list.get(2).click();
        //By.tagName
        wd.findElement(By.tagName("a"));
        wd.findElement(By.tagName("h1"));
        wd.findElement(By.tagName("input"));
        wd.findElement(By.tagName("button"));

        wd.findElement(By.cssSelector("a"));
        wd.findElement(By.cssSelector("button"));

        //By.id
        wd.findElement(By.id("root"));

        wd.findElement(By.cssSelector("#root"));
        wd.findElement(By.cssSelector("[id='root']"));

        //By.className
        wd.findElement(By.className("container"));
        wd.findElement(By.className("active"));

        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector("[class='active']"));

        //By.name
        //wd.findElement(By.name("namename"));
        //wd.findElement(By.cssSelector("[name='namename']"));

        //By.linkText
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));
        wd.findElement(By.partialLinkText("AB"));

        wd.findElement(By.cssSelector("[placeholder='Password']"));
        //начинается ^=
        wd.findElement(By.cssSelector("[placeholder^='Pass']"));
        //заканчивается $=
        wd.findElement(By.cssSelector("[placeholder$='word']"));
        //содержит *=
        wd.findElement(By.cssSelector("[placeholder*='sswo']"));
    }

    @Test
    public void loginTest(){
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> elements = wd.findElements(By.tagName("input"));
        WebElement email = elements.get(0);
        WebElement password = elements.get(1);
        email.click();
        email.clear();
        email.sendKeys("1234@mai.com" + Keys.TAB);

        password.clear();
        password.sendKeys("aA123456$");

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();


    }

    @AfterMethod
    public void postCondotion(){
        //wd.quit();
    }
}

