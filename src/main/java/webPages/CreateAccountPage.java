package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CreateAccountPage {


    WebDriver driver;
    private By txtYourName = By.xpath("//input[@id='ap_customer_name']");
    private By txtEmail = By.xpath("//input[@id='ap_email']");
    private By txtPassword = By.xpath("//input[@id='ap_password']");
    private By txtReTypePassword = By.xpath("//input[@id='ap_password_check']");
    private By btnCreateAccount = By.xpath("//input[@id='continue']");


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterYourName(String name) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(txtYourName).click();
        driver.findElement(txtYourName).clear();
        driver.findElement(txtYourName).sendKeys(name);

    }

    public void enterEmail(String email) {
        driver.findElement(txtEmail).click();
        driver.findElement(txtEmail).clear();
        driver.findElement(txtEmail).sendKeys(email);

    }


    public void enterPassword(String password) {
        driver.findElement(txtPassword).click();
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);

    }

    public void reEnterPassword(String rePassword) {
        driver.findElement(txtReTypePassword).click();
        driver.findElement(txtReTypePassword).clear();
        driver.findElement(txtReTypePassword).sendKeys(rePassword);

    }
    /*
     *CAPTCHA is present when registering unable to Automate
     */

    public void btnCreateAccount() {
        driver.findElement(btnCreateAccount).click();


    }

}
