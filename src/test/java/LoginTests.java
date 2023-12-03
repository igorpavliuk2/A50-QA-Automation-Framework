import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error


        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @Test
    public void loginUserTest() {
        loginKoel();
        clickSubmit();

        WebElement logoutButton = getDriver().findElement(By.cssSelector("a[data-testid='btn-logout']>i"));

        Assert.assertTrue(logoutButton.isDisplayed());

    }
}
