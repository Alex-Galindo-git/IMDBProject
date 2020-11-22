package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignInWithIMDbPage {


    WebDriver driver;
    private By txtEmail = By.xpath("//input[@id='ap_email']");
    private By txtPassword = By.xpath("//input[@id='ap_password']");
    private By btnSignIn = By.xpath("//input[@id='signInSubmit']");



    public SignInWithIMDbPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterEmail(String email) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtEmail).click();
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).click();
        driver.findElement(txtPassword).sendKeys(password);
    }


    public LandingPage clickBtnSignIn() {
        driver.findElement(btnSignIn).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LandingPage(driver);
    }
}
