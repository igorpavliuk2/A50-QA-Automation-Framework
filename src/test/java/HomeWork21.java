import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class HomeWork21 extends BaseTest {
    @Test (testName = "Rename playlist")

    public void renamePlaylist() throws InterruptedException  {
        loginKoel();
        clickSubmit();
        String newName = UUID.randomUUID().toString();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        rClick("a[href=\"#!/playlist/79485\"]");
        lClick("li[data-testid=\"playlist-context-menu-edit-79485\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        WebElement playlistNameEdit = getDriver().findElement(By.cssSelector("input[data-testid='inline-playlist-name-input']"));
        for (int i=0; i<playlistNameEdit.toString().length(); i++)
        {
        playlistNameEdit.sendKeys(Keys.BACK_SPACE);
        }
        playlistNameEdit.sendKeys(newName);
        playlistNameEdit.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        WebElement successShow = getDriver().findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(successShow.isDisplayed());

    }
}
