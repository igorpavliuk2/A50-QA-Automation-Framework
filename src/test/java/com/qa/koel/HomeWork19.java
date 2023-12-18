package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork19 extends BaseTest {
    HomePage  homePage;
    @Test(testName = "Delete playlist")

    public void deletePlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginKoel();
        loginPage.clickSubmit();
        WebElement playlists = getDriver().findElement(By.cssSelector("li[class='playlist playlist']"));
        playlists.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        deletePlaylist();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        homePage = new HomePage(getDriver());
        WebElement successShow = homePage.getSuccessShow();
        Assert.assertTrue(successShow.isDisplayed());
    }
}
