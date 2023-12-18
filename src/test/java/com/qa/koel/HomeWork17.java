package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class HomeWork17 extends BaseTest {
    @Test(testName = "Add song to playlist ")
public void addSongToPlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginKoel();
        loginPage.clickSubmit();
        allSongPage();
        WebElement songRandom = getDriver().findElement(By.xpath("//td[contains(text(),'M33 Project')]"));
        songRandom.click();
        WebElement addToPlaylist = getDriver().findElement(By.cssSelector("button[class='btn-add-to']"));
        addToPlaylist.click();
        WebElement favorites = getDriver().findElement(By.xpath("//li[contains(text(),'123')]"));
        favorites.click();
            WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
            WebElement successShow = getDriver().findElement(By.cssSelector("div[class='success show']"));
            Assert.assertTrue(successShow.isDisplayed());
    }
}
