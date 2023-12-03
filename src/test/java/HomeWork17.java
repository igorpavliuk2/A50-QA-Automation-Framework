import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class HomeWork17 extends BaseTest {
    @Test(testName = "Add song to playlist ", groups = "smoke test")
public void addSongToPlaylist() {

// NEED TO REFACTORING
        loginKoel();
        clickSubmit();


        WebElement allSongs = getDriver().findElement(By.cssSelector("a[href='#!/songs']"));
        allSongs.click();

        WebElement songRandom = getDriver().findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[last()]"));
        songRandom.click();

        WebElement addToPlaylist = getDriver().findElement(By.cssSelector("button[class='btn-add-to']"));
        addToPlaylist.click();

        WebElement favorites = getDriver().findElement(By.cssSelector("section[class='existing-playlists']>ul>[class='playlist']"));
        favorites.click();

        WebElement successShow = getDriver().findElement(By.cssSelector("div[class='success show']"));

        Assert.assertTrue(successShow.isDisplayed());




    }

}
