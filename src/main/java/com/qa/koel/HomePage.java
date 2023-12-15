package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    static final By LOGOUT_BUTTON = By.cssSelector("a[data-testid='btn-logout']>i");
    By SUCCESS_SHOW = By.cssSelector("div[class='success show']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getLogoutButton() {
        return pageDriver.findElement(LOGOUT_BUTTON);
    }
    public WebElement getSuccessShow() {
        return pageDriver.findElement(SUCCESS_SHOW);
    }


}
