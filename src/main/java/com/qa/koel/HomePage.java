package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[data-testid='btn-logout']>i")
    WebElement logoutButton;
    //static final By LOGOUT_BUTTON = By.cssSelector("a[data-testid='btn-logout']>i");
    @FindBy(css = "div[class='success show']")
    WebElement successShow;
    //By SUCCESS_SHOW = By.cssSelector("div[class='success show']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public  WebElement getSuccessShow() {
        return successShow;
    }


}
