package com.example.imdb;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    JavascriptExecutor jse;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.imdb.com/");
        jse = (JavascriptExecutor) driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        mainPage = new MainPage(driver);

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void assertMovie() {

        mainPage.cookieButton.click();
        mainPage.hamburgerMenu.click();
        mainPage.oscarTextButton.click();
        jse.executeScript("window.scrollBy(-400,250)");
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.nextButton));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        mainPage.nextButton.click();
        mainPage.ButtonOfYears1920.click();
        mainPage.ButtonOfYear1929.click();
        jse.executeScript("argument[0].scrollIntoView(true)",mainPage.jazzSingerMovie);
        mainPage.jazzSingerMovie.click();
        jse.executeScript("argument[0].scrollIntoView(true)",mainPage.jazzSingerMovieDirector);
        String firstDirectorName=mainPage.jazzSingerMovieDirector.getText();
        String firstMovieWrites=mainPage.jazzSingerMovieWriters.getText();
        jse.executeScript("window.scrollBy(0,1000)");
        mainPage.imdbLogo.click();
        mainPage.searchInput.sendKeys("Jazz Singer 1927");
        mainPage.jazzSingerMovie.click();
        driver.findElement((By) mainPage.jazzSingerMovie);
        jse.executeScript("argument[0].scrollIntoView(true)",mainPage.jazzSingerMovieDirector);
        String secondDirectorName=mainPage.jazzSingerMovieDirector.getText();
        String secondMovieWrites=mainPage.jazzSingerMovieWriters.getText();

        Assert.assertEquals(firstDirectorName,secondDirectorName);
        Assert.assertEquals(firstMovieWrites,secondMovieWrites);
    }
}
