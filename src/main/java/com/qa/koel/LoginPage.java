package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    static final By PASSWORD_FIELD = By.cssSelector("input[type='password']");
    static final By EMAIL_FIELD = By.cssSelector("input[type='email']");
    static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);

    }
    public void loginKoel () {
        WebElement emailField = pageDriver.findElement(EMAIL_FIELD);
        emailField.sendKeys("igor.pavliuk@testpro.io");

        WebElement passwordField = pageDriver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys("1q2w3e4R");
    }
    public void clickSubmit() {
        WebElement loginButton = pageDriver.findElement(SUBMIT_BUTTON);
        loginButton.click();
    }
}
