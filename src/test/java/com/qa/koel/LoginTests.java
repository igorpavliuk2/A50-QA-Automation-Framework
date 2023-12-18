package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    @Test (testName = "Login empty email test")
    public void loginEmptyEmailPassword() {



        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @Test (testName = "Login User TEST ")
    public void loginUserTest() {
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel();
        loginPage.clickSubmit();
        homePage = new HomePage(getDriver());


        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());

    }
}
