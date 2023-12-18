package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "button[type='submit']")
    WebElement submitButon;

    public LoginPage(WebDriver driver) {
        super(driver);

    }
    public void loginKoel () {
        emailField.sendKeys("igor.pavliuk@testpro.io");
        passwordField.sendKeys("1q2w3e4R");
    }
    public void clickSubmit() {
        submitButon.click();
    }
}
