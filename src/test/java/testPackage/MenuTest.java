package testPackage;

import Data.LandingPageData;
import Data.SignInUserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webPages.LandingPage;
import webPages.SignInPage;
import webPages.SignInWithIMDbPage;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class MenuTest {

    String projectPath = System.getProperty("user.dir");
     WebDriver driver;

    @BeforeSuite

    public void setDriver() {
        chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void navigateToURL() {
        driver.navigate().to("https://www.imdb.com/");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void displaySciFiItemsToWatchListFromSearch() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        LandingPage landingPage = new LandingPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        SignInUserData signInUserData = new SignInUserData();
        LandingPageData landingPageData = new LandingPageData();
        SignInWithIMDbPage signInWithIMDbPage = new SignInWithIMDbPage(driver);
        landingPage.clickSignInBtn();
        signInPage.clickSignInWithIMDbBtn();
        signInWithIMDbPage.enterEmail(signInUserData.email);
        signInWithIMDbPage.enterPassword(signInUserData.password);
        signInWithIMDbPage.clickBtnSignIn();
        landingPage.clickMenu();
        landingPage.clickBrowseMoviesByGenre();
        landingPage.clickLnkSciFi();
        landingPage.getMovieList();
        softAssert.assertAll();
    }
}
