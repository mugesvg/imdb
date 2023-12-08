package com.example.imdb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='icb-btn sc-bcXHqe sc-hLBbgP sc-ftTHYK dcvrLS dufgkr ecppKW']")
    public WebElement cookieButton;

    @FindBy(id = "imdbHeader-navDrawerOpen")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//span[text()=\"Oscars\"]")
    public WebElement oscarTextButton;

    @FindBy(xpath = "(//li)[53]")
    public WebElement nextButton;

    @FindBy(xpath = "//*[contains(text(), '1920')]")
    public WebElement ButtonOfYears1920;

    @FindBy(xpath = "//*[contains(text(), '1929')]")
    public WebElement ButtonOfYear1929;

    @FindBy(xpath = "//*[contains(text(), 'Jazz Singer')]")
    public WebElement jazzSingerMovie;

    @FindBy(xpath = "//*[contains(text(), 'Alan Crosland')]")
    public WebElement jazzSingerMovieDirector;

    @FindBy(xpath = "//*[contains(text(), 'Samson Raphaelson')]")
    public WebElement jazzSingerMovieWriters;

    @FindBy(id = "home_img")
    public WebElement imdbLogo;

    @FindBy(xpath = "//input[@class='imdb-header-search__input searchTypeahead__input react-autosuggest__input']")
    public WebElement searchInput;
}
