import org.openqa.selenium.By;
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
    public void precondotion() {
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

    @AfterMethod
    public void postCondotion(){
        wd.quit();
    }
}

