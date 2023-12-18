package com.qa.koel;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.UUID;

public class HomeWork21 extends BaseTest {
    HomePage  homePage;

    @Test (testName = "Rename playlist")

    public void renamePlaylist() throws InterruptedException  {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginKoel();
        loginPage.clickSubmit();
        String newName = UUID.randomUUID().toString();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        rClick("#playlists > ul > li:nth-child(4)");
        lClick("//li[contains(text(),'Edit')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        WebElement playlistNameEdit = getDriver().findElement(By.cssSelector("input[data-testid='inline-playlist-name-input']"));
        for (int i=0; i<playlistNameEdit.toString().length(); i++)
        {
        playlistNameEdit.sendKeys(Keys.BACK_SPACE);
        }
        playlistNameEdit.sendKeys(newName);
        playlistNameEdit.sendKeys(Keys.ENTER);
        homePage = new HomePage(getDriver());
        WebElement successShow = homePage.getSuccessShow();
        Assert.assertTrue(successShow.isDisplayed());

    }
}
