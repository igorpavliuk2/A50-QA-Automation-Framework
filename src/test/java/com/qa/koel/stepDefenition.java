package com.qa.koel;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;

public class stepDefenition {

    protected String url = "https://qa.koel.app/";
    private WebDriver driver;

    @Given("I open koel")
    public void setupDriver()  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// one time
        getDriver().manage().window().fullscreen();
        getDriver().get(url); //open page
    }
public WebDriver getDriver() {return this.driver;}
    @When("I login as user in koel with {string} and {string}")
    public void iLoginAsUserInKoel(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginKoel();
        loginPage.submitButon.click();

    }


    @Then("I should be auth in Home Page")
    public void iShouldBeAuthInHomePage() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }
    @After
    public void closeDriver() {
        getDriver().quit();
    }
}
