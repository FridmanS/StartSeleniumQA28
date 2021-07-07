import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW {

    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test
    public void loginTest(){
        wd.findElement(By.cssSelector("[href='/login']")).click(); //login

        WebElement email = wd.findElement(By.cssSelector("[placeholder='Email']"));
        WebElement password = wd.findElement(By.cssSelector("[placeholder='Password']"));
        email.click();
        email.clear();
        email.sendKeys("1234@mai.com" + Keys.TAB);
        password.clear();
        password.sendKeys("aA123456$");

        wd.findElement(By.cssSelector(".login_login__3EHKB :nth-child(4)")).click();
    }

    @AfterMethod
    public void postCondition() throws InterruptedException {
        wd.quit();
    }
}
