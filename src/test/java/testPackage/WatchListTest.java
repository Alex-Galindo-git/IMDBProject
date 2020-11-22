package testPackage;

import Data.LandingPageData;
import Data.SignInUserData;
import Data.SortData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webPages.LandingPage;
import webPages.SignInPage;
import webPages.SignInWithIMDbPage;
import webPages.WatchListPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class WatchListTest {

    String projectPath = System.getProperty("user.dir");
    WebDriver driver;

    @BeforeSuite
    public void setDriver() {
//        System.setProperty("webdriver.chrome.driver",projectPath+"/chromedriver.exe");
        chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void navigateToURL() {
        driver.navigate().to("https://www.imdb.com/");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void addItemToWatchListFromSearch() throws InterruptedException {
        //this method create a new user
        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        SignInUserData signInUserData = new SignInUserData();
        LandingPageData landingPageData = new LandingPageData();
        SignInWithIMDbPage signInWithIMDbPage = new SignInWithIMDbPage(driver);
        WatchListPage watchListPage = new WatchListPage(driver);
        landingPage.clickSignInBtn();
        signInPage.clickSignInWithIMDbBtn();
        signInWithIMDbPage.enterEmail(signInUserData.email);
        signInWithIMDbPage.enterPassword(signInUserData.password);
        signInWithIMDbPage.clickBtnSignIn();
        landingPage.searchTextAndAddToWatchList(landingPageData.movieName);
        landingPage.clickWatchListLink();
        softAssert.assertTrue(landingPage.isDisplayWatchCount(), "Watch count Not Displayed");
        watchListPage.clickEditButton();
        watchListPage.clickChkBox();
        watchListPage.clickDeleteLnk();
        watchListPage.clickDeleteLnkPopup();
        watchListPage.clickDoneBtn();
        landingPage.userSignOut();
        softAssert.assertAll();


    }

    @Test(priority = 2)
    public void removeItemFromWatchList() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        WatchListPage watchListPage = new WatchListPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        SignInUserData signInUserData = new SignInUserData();
        LandingPageData landingPageData = new LandingPageData();
        SignInWithIMDbPage signInWithIMDbPage = new SignInWithIMDbPage(driver);
        landingPage.clickSignInBtn();
        signInPage.clickSignInWithIMDbBtn();
        signInWithIMDbPage.enterEmail(signInUserData.email);
        signInWithIMDbPage.enterPassword(signInUserData.password);
        signInWithIMDbPage.clickBtnSignIn();
        landingPage.searchTextAndAddToWatchList(landingPageData.movieName);
        landingPage.clickWatchListLink();
        softAssert.assertTrue(landingPage.isDisplayWatchCount(), "Watch count Not Display");
        landingPage.clickWatchListLink();
        watchListPage.clickEditButton();
        watchListPage.clickChkBox();
        watchListPage.clickDeleteLnk();
        watchListPage.clickDeleteLnkPopup();
        watchListPage.clickDoneBtn();
        softAssert.assertTrue(watchListPage.isDispayWatchListEmptyText(), "watch list empty text not display");
        landingPage.userSignOut();
        softAssert.assertAll();


    }

    @Test(priority = 3)
    public void sortTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        WatchListPage watchListPage = new WatchListPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        SignInUserData signInUserData = new SignInUserData();
        LandingPageData landingPageData = new LandingPageData();
        SignInWithIMDbPage signInWithIMDbPage = new SignInWithIMDbPage(driver);
        SortData sortData = new SortData();
        landingPage.clickSignInBtn();
        signInPage.clickSignInWithIMDbBtn();
        signInWithIMDbPage.enterEmail(signInUserData.email);
        signInWithIMDbPage.enterPassword(signInUserData.password);
        signInWithIMDbPage.clickBtnSignIn();
        landingPage.searchTextAndAddToWatchList(landingPageData.movieName);
        landingPage.clickWatchListLink();
        softAssert.assertTrue(landingPage.isDisplayWatchCount(), "Watch count Not Display");
        landingPage.clickWatchListLink();
        landingPage.searchTextAndAddToWatchList(landingPageData.movieName1);
        landingPage.clickWatchListLink();
        watchListPage.selectSortOption(sortData.orderAlpha);
        softAssert.assertTrue(watchListPage.isMovieDisplayOnTop(landingPageData.movieName1), "Sorted Movie not display in the top");
        watchListPage.clickEditButton();
        watchListPage.clickChkBox();
        watchListPage.clickDeleteLnk();
        watchListPage.clickDeleteLnkPopup();
        watchListPage.clickDoneBtn();
        landingPage.userSignOut();
        softAssert.assertAll();


    }


}
