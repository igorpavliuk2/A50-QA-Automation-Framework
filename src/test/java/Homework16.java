import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigationTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
WebElement registrationField = driver.findElement(By.cssSelector("a[href='registration']"));
        Assert.assertTrue(registrationField.isDisplayed());
        registrationField.click();

WebElement registrationPostField = driver.findElement(By.cssSelector("form[method='POST']"));

        Assert.assertTrue(registrationPostField.isDisplayed());

        driver.quit();
    }

}
