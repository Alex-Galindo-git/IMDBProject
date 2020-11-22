package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    WebDriver driver;
    private By btnCreateNewAccount = By.xpath("//a[text()='Create a New Account']");
    private By btnSignInWithIMDb = By.xpath("//span[text()='Sign in with IMDb']");

    public SignInPage(WebDriver driver){
        this.driver=driver;
    }

    public CreateAccountPage clickCreateNewAccountBtn() {
        driver.findElement(btnCreateNewAccount).click();
        return new CreateAccountPage(driver);
    }

    public SignInWithIMDbPage clickSignInWithIMDbBtn() {
        driver.findElement(btnSignInWithIMDb).click();
        return new SignInWithIMDbPage(driver);
    }
}
