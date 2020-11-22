package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LandingPage {


    WebDriver driver;
    private By btnSignIn = By.xpath("//div[text()='Sign In']");
    private By txtSearchBox = By.xpath("//input[@id='suggestion-search']");
    private By btnSearchIcon = By.xpath("//button[@id='suggestion-search-button']");
    private By lnkMatrix = By.xpath("//div[@id='findSubHeader']/following-sibling::div[1]/table/tbody/tr[1]/td[2]/a");
    private By btnAddToWatchList = By.xpath("//button[contains(@class,'add watchlist')]/div");
    private By lblAddToWatchList = By.xpath("//div[text()='Add to Watchlist']");
    private By lblStarts = By.xpath("//h4[text()='Stars:']");

    private By linkWatchList = By.xpath("//div[text()='Watchlist']");
    private By btnWatchCount = By.xpath("//div[text()='Watchlist']/span");
    private By lblAddedToWatchList = By.xpath("//div[text()='Added to Watchlist']");
    private By lblMenu = By.xpath("//nav[@id='imdbHeader']");
    private By btnMenu = By.xpath("//label[@id='imdbHeader-navDrawerOpen--desktop']");
    private By lnkBrowseMovieByGenre = By.xpath("//span[text()='Browse Movies by Genre']/parent::a");
    private By lnkSciFi = By.xpath("//img[@title='Sci-Fi']");
    private By lblItemsInWatchList = By.xpath("//div[text()='Watchlist']/span");
    private By btnUserName = By.xpath("//div[contains(@class,'UserMenu')]");
    private By btnSignOut = By.xpath("//span[text()='Sign out']/parent::a");




    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    WatchListPage watchListPage = new WatchListPage(driver);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public SignInPage clickSignInBtn() {
        driver.findElement(btnSignIn).click();
        return new SignInPage(driver);
    }

    public void searchTextAndAddToWatchList(String movieName) {
        driver.findElement(txtSearchBox).click();
        driver.findElement(txtSearchBox).clear();
        driver.findElement(txtSearchBox).sendKeys(movieName);
        driver.findElement(btnSearchIcon).click();
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lnkMatrix));
        wait.until(ExpectedConditions.elementToBeClickable(lnkMatrix));
        driver.findElement(lnkMatrix).click();
        wait = new WebDriverWait(driver, 10);
        WebElement element = driver.findElement(lblStarts);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.presenceOfElementLocated(lblAddToWatchList));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement element2 = driver.findElement(lblAddToWatchList);
        actions.moveToElement(element2).perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToWatchList));
        driver.findElement(btnAddToWatchList).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblAddedToWatchList));
        WebElement element1 = driver.findElement(lblMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

    }

    public WatchListPage clickWatchListLink() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkWatchList));
        driver.findElement(linkWatchList).click();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnWatchCount));
        return new WatchListPage(driver);
    }

    public boolean isDisplayWatchCount() {
        return driver.findElement(btnWatchCount).isDisplayed();
    }


    public void clickMenu(){
        driver.findElement(btnMenu).click();
    }


    public void clickBrowseMoviesByGenre(){
        driver.findElement(lnkBrowseMovieByGenre).click();
    }


    public void clickLnkSciFi(){
        driver.findElement(lnkSciFi).click();
    }

    public ArrayList<String> getMovieList(){
        String a;
        ArrayList <String> movieList =new ArrayList<String>();
        int size=  driver.findElements(By.xpath("//div[@class='lister list detail sub-list']/div/div")).size();

        for(int i=1; i<=size;i++){

           a="//div[@class='lister list detail sub-list']/div/div["+i+"]/div[3]/h3//a";
           String movieName =driver.findElement(By.xpath(a)).getText().toString();
           movieList.add(movieName);
           System.out.println(movieName);
        }
        return movieList;
    }

    public void userSignOut(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(btnUserName));
        driver.findElement(btnUserName).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignOut));
        wait.until(ExpectedConditions.elementToBeClickable(btnSignOut));
        driver.findElement(btnSignOut).click();

    }
}
