package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {
    @Test(testName = "Play Song ")

    public void playSong()  {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginKoel();
        loginPage.clickSubmit();
    allSongPage();
        WebElement song = getDriver().findElement(By.cssSelector("td[class='title']"));
        song.click();
        dClick("td[class='title']");





        WebElement songPlay = getDriver().findElement(By.cssSelector("div[class='plyr plyr--audio plyr--playing']"));
        Assert.assertTrue(songPlay.isDisplayed());

    }
}
