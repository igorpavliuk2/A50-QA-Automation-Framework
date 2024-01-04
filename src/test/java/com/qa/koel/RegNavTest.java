package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegNavTest extends BaseTest {
    @Test (testName = "Registration navigation test ")
    public void registrationNavigationTest() {
WebElement registrationField = getDriver().findElement(By.cssSelector("a[href='registration']"));
        Assert.assertTrue(registrationField.isDisplayed());
        registrationField.click();
WebElement registrationPostField = getDriver().findElement(By.cssSelector("form[method='POST']"));
        Assert.assertTrue(registrationPostField.isDisplayed());
    }
}
