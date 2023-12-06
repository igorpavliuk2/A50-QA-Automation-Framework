import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
public class HomeWork18 extends BaseTest {
    @Test(testName = "Play Song ")

    public void playSong() throws InterruptedException {
    loginKoel();
    clickSubmit();
    allSongPage();
        WebElement song = getDriver().findElement(By.cssSelector("td[class='title']"));
        song.click();
        dClick("td[class='title']");





        WebElement songPlay = getDriver().findElement(By.cssSelector("div[class='plyr plyr--audio plyr--playing']"));
        Assert.assertTrue(songPlay.isDisplayed());

    }
}
