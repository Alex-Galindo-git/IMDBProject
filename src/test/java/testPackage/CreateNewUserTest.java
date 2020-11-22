package testPackage;

import Data.CreateUserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webPages.CreateAccountPage;
import webPages.LandingPage;
import webPages.SignInPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class CreateNewUserTest {

        String projectPath =System.getProperty("user.dir");
        WebDriver driver;

        @BeforeSuite
        public void setDriver() {
          //  System.setProperty("webdriver.chrome.driver",projectPath+"/chromedriver.exe");
            chromedriver().setup();
            driver = new ChromeDriver();
            //Navigate to  automation practice site
            driver.navigate().to("https://www.imdb.com/");
            driver.manage().window().maximize();

        }


        @Test(priority=1)
        public void createNewUserTest() throws InterruptedException {
            //this method creates a new user
            SoftAssert softAssert = new SoftAssert();
            LandingPage landingPage = new LandingPage(driver);
            SignInPage signInPage =new SignInPage(driver);
            CreateUserData createUserData =new CreateUserData();
            CreateAccountPage createAccountPage =new CreateAccountPage(driver);
            landingPage.clickSignInBtn();
            signInPage.clickCreateNewAccountBtn();
            createAccountPage.enterYourName(createUserData.yourName);
            createAccountPage.enterEmail(createUserData.email);
            createAccountPage.enterPassword(createUserData.password);
            createAccountPage.reEnterPassword(createUserData.rePassword);
            createAccountPage.btnCreateAccount();
            softAssert.assertAll();

        }
}
