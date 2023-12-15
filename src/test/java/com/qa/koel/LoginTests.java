package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    @Test
    public void loginEmptyEmailPassword() {



        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @Test
    public void loginUserTest() {
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel();
        loginPage.clickSubmit();
        homePage = new HomePage(getDriver());


        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());

    }
}
