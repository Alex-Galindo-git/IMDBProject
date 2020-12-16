package testPackage;

import Data.LandingPageData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webPages.LandingPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class TitleTest {
    String projectPath = System.getProperty("user.dir");
    WebDriver driver;

    @BeforeSuite
    public void setDriver() {
//        System.setProperty("webdriver.chrome.driver", projectPath + "/chromedriver.exe");
        chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void navigateToURL() {
        driver.navigate().to("https://www.imdb.com/");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void verifyAllDropDownElementDisplays() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnAll();
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentAll(), "All label not Displayed");
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentTVEpisodes(), "TV Episodes not Displayed");
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentTitles(), "Titles not Displayed");
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentKeywords(), "Content Keyword not Displayed");
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentCelebs(), "Celebs not Displayed");
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentCompanies(), "Companies not displayed");
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentAdvancedSearch(), "Advance Search Not displayed");
        softAssert.assertAll();

    }

    /* This test we are actually  getting an assert alert to make sure that element is not present and warn us!
     * */
    @Test(priority = 2)
    public void verifyElementIsNotDisplayInDropDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        //landingPage.clickOnAll();
        softAssert.assertTrue(landingPage.isDisplayedDropdownContentMovie(), "Movie Not displayed");
        softAssert.assertAll();

    }


    @Test(priority = 3)
    public void verifyClickOnTitleAndSearchAMovie() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        LandingPageData landingPageData = new LandingPageData();
//        landingPage.clickOnAll();
        landingPage.clickTitlesFromDropdown();
        landingPage.searchMovie(landingPageData.movieName2);
        landingPage.verifyDisplayAllSearchResults();
        softAssert.assertAll();

    }

    /*This test we are failing it on purpose, simulating the element was not found and the test gets a FAIL
     * */
    @Test(priority = 4)
    public void verifyClickOnTitleAndSearchAMovieAndMovieNotInSearchList() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        LandingPageData landingPageData = new LandingPageData();
        landingPage.clickOnAll();
        landingPage.clickTitlesFromDropdown();
        landingPage.searchMovie(landingPageData.movieName2);
        softAssert.assertTrue(landingPage.isMovieInSearchResults(), "Movie is not in search results");
        softAssert.assertAll();

    }

    @Test(priority = 5)
    public void verifyFanFavoritesAsserts() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        LandingPageData landingPageData = new LandingPageData();
        landingPage.scrollToFanFavorites();
        softAssert.assertTrue(landingPage.isDisplayedBookMark(), "Bookmark not displayed");
        softAssert.assertTrue(landingPage.isDisplayedImage(), "Image not displayed");
        softAssert.assertTrue(landingPage.isDisplayedRating(), "Rating not displayed");
        softAssert.assertEquals(landingPage.getTextMovieName(), "The Queen's Gambit", "Movie name not displayed");
        softAssert.assertTrue(landingPage.isDisplayedWatchList(), "WatchList not displayed");
        softAssert.assertTrue(landingPage.isDisplayedTrailer(), "Trailer not displayed");
        landingPage.clickTrailer();
        softAssert.assertTrue(landingPage.isDisplayedVideo(), "Video not displayed");
        softAssert.assertAll();


    }
}