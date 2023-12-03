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


WebElement registrationField = getDriver().findElement(By.cssSelector("a[href='registration']"));
        Assert.assertTrue(registrationField.isDisplayed());
        registrationField.click();

WebElement registrationPostField = getDriver().findElement(By.cssSelector("form[method='POST']"));

        Assert.assertTrue(registrationPostField.isDisplayed());

    }

}
