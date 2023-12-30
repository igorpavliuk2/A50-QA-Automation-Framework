package com.qa.koel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;


public abstract class BaseTest {
    private WebDriver driver;

    protected String url = "https://qa.koel.app/";

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    @BeforeMethod
    @Parameters({"baseUrl"})
    public void setupDriver(String baseUrl) throws MalformedURLException {

        threadDriver.set(pickDriver(System.getProperty("browser"))); //driver = ChromeDriver instance

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// one time
        getDriver().manage().window().fullscreen();
        getDriver().get(url); //open page
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }
    public void allSongPage () {
        WebElement allSongs = getDriver().findElement(By.cssSelector("a[href='#!/songs']"));
        allSongs.click();
    }
    public void dClick (String css){
        Actions action = new Actions(getDriver());

        WebElement link = getDriver().findElement(By.cssSelector(css));
        action.doubleClick(link).perform();

    }
    public void rClick (String css){
        Actions action = new Actions(getDriver());

        WebElement link = getDriver().findElement(By.cssSelector(css));
        action.contextClick(link).perform();
    }
    public void lClick (String xpath){
        Actions action = new Actions(getDriver());

        WebElement link = getDriver().findElement(By.xpath(xpath));
        action.click(link).perform();
    }
    public void deletePlaylist () {
        WebElement deletePlaylistButton = getDriver().findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deletePlaylistButton.click();
        WebElement okButton = getDriver().findElement(By.cssSelector("button[class='ok']"));
        okButton.click();

    }


    @AfterMethod
    //public void closeBrowser() {
       // getDriver().quit();
   // }
public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }
    public WebDriver pickDriver(String browserName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridUrl = "http://10.0.0.102:4444/";
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions);
            case "grid-chrome":
                capabilities.setCapability("browser", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
            case "lambda-driver":
                return getLambdaDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new SafariDriver();
        }




    }
    public WebDriver getLambdaDriver () throws MalformedURLException {
        String userName = "igor.pavliuk";
        String authKey = "gcHjMzOxMR88LvKDJOIBwdQhgg6103wfCBDOsaMobzhDBt4M4V";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "121.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", authKey);
        ltOptions.put("video", true);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("project", "Koel");
        capabilities.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(URI.create("https://" + userName + ":" + authKey + hub).toURL(),capabilities);
    }
}