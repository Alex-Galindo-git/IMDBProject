package webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.NoSuchElementException;
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
    private By btnUserName = By.xpath("//div[contains(@class,'UserMenu')]/div");
    private By btnSignOut = By.xpath("//span[text()='Sign out']/parent::a");
    private By btnAll = By.xpath("//form[@id='nav-search-form']//div[@class='ipc-button__text']");
    private By btnTitle = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='Titles']/parent::a");
   // private By btnTitle = By.xpath("//span[@id='navbar-search-category-select-contents']/ul[@role='menu']/a[2]");

    private By lblAll = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='All']");
    private By lblTitles = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='Titles']");
    private By lblTVEpisodes = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='TV Episodes']");
    private By lblCelebs = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='Celebs']");
    private By lblCompanies = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='Companies']");
    private By lblKeywords = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='Keywords']");
    private By lblAdvancedSearch = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='Advanced Search']");
    private By lblMovie = By.xpath("//form[@id='nav-search-form']/div/div/div//ul[@role='menu']/a/span[text()='Movie]");
    private By lblSearchResults1 = By.xpath("//input[@value='Avengers']/parent::div//ul/li//div[2]/div[text()='Avengers: Endgame']");

    private By lblSearchResults2 = By.xpath("//input[@value='Home']/parent::div//ul/li[1]//div[2]/div");

    private By lblFanFavorites = By.xpath("//div[@class='fan-picks']");


    private By btnBookMark = By.xpath("//div[@class='fan-picks']/div[2]/div/div[1]/div[1]/div[1]");
    private By btnImage = By.xpath("//div[@class='fan-picks']/div[2]/div/div[1]/div[1]/div[2]");
    private By lblRating = By.xpath("//div[@class='fan-picks']/div[2]/div/div[1]/div[2]");
    private By btnMovieName = By.xpath("//div[@class='fan-picks']/div[2]/div/div[1]/a");
    private By btnWatchList = By.xpath("//div[@class='fan-picks']/div[2]/div/div[1]/div[3]/button");
    private By btnTrailer = By.xpath("//div[@class='fan-picks']/div[2]/div/div[1]/div[4]/div");
    private By video = By.xpath("//div[@class='video-player__video']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }


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
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement element2 = driver.findElement(lblAddToWatchList);
        actions.moveToElement(element2).perform();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToWatchList));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToWatchList));
        driver.findElement(btnAddToWatchList).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblAddedToWatchList));
        WebElement element1 = driver.findElement(lblMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

    }

    public void searchMovie(String movieName) {
        driver.findElement(txtSearchBox).click();
        driver.findElement(txtSearchBox).clear();
        driver.findElement(txtSearchBox).sendKeys(movieName);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblSearchResults1));
        wait.until(ExpectedConditions.elementToBeClickable(lblSearchResults1));
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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(btnUserName));
        wait.until(ExpectedConditions.elementToBeClickable(btnUserName));
        driver.findElement(btnUserName).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignOut));
        wait.until(ExpectedConditions.elementToBeClickable(btnSignOut));
        driver.findElement(btnSignOut).click();

    }

    public void clickOnAll(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(btnAll));
        wait.until(ExpectedConditions.elementToBeClickable(btnAll));
        driver.findElement(btnAll).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblAll));
    }



    public boolean isDisplayedDropdownContentAll(){
        boolean x= driver.findElement(lblAll).isDisplayed();
        if(x==true){
            System.out.println("All - Displays in the dropdown");
        }else {
            System.out.println("All - Does not display in the dropdown");
        }
        return x;
    }


    public boolean isDisplayedDropdownContentTitles(){
        boolean x= driver.findElement(lblTitles).isDisplayed();
        if(x==true){
            System.out.println("Titles - Displays in the dropdown");
        }else {
            System.out.println("Titles - Does not display in the dropdown");
        }
        return x;
    }

    public boolean isDisplayedDropdownContentTVEpisodes(){
        boolean x= driver.findElement(lblTVEpisodes).isDisplayed();
        if(x==true){
            System.out.println("TVEpisodes - Displays in the dropdown");
        }else {
            System.out.println("TVEpisodes - Does not display in the dropdown");
        }
        return x;
    }
    public boolean isDisplayedDropdownContentCelebs(){
        boolean x= driver.findElement(lblCelebs).isDisplayed();
        if(x==true){
            System.out.println("Celebs - Displays in the dropdown");
        }else {
            System.out.println("Celebs - Does not display in the dropdown");
        }
        return x;

    }

    public boolean isDisplayedDropdownContentCompanies(){
        boolean x= driver.findElement(lblCompanies).isDisplayed();
        if(x==true){
            System.out.println("Companies - Displays in the dropdown");
        }else {
            System.out.println("Companies - Does not display in the dropdown");
        }
        return x;

    }
    public boolean isDisplayedDropdownContentKeywords(){
        boolean x= driver.findElement(lblKeywords).isDisplayed();
        if(x==true){
            System.out.println("Keywords - Displays in the dropdown");
        }else {
            System.out.println("Keywords - Does not display in the dropdown");
        }
        return x;

    }

    public boolean isDisplayedDropdownContentAdvancedSearch() {
        boolean x= driver.findElement(lblAdvancedSearch).isDisplayed();
        if(x==true){
            System.out.println("Advanced Search - Displays in the dropdown");
        }else {
            System.out.println("Advanced Search - Does not display in the dropdown");
        }
        return x;
    }

    public boolean isDisplayedDropdownContentMovie()throws InvalidSelectorException {
        try{
            driver.findElement(lblMovie).isDisplayed();
            System.out.println("Movie - Displays in the dropdown");
            return true;
        }catch(Exception e){
            System.out.println("Movie - Does not display in the dropdown");
            return false;

        }
    }


    public void clickTitlesFromDropdown(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnTitle));
        driver.findElement(btnTitle).click();
    }

    public void verifyDisplayAllSearchResults(){
        int a= driver.findElements(By.xpath("//input[@value='Avengers']/parent::div//ul/li")).size();

        for(int x=1;x<a;x++){
            if(x==2||x==3||x==5||x==6){

            }else {
                String b = "//input[@value='Avengers']/parent::div//ul/li[" + x + "]//div[2]/div";
                WebElement element = driver.findElement(By.xpath(b));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                String w = driver.findElement(By.xpath(b)).getText();

                System.out.println("Search Results: " + w);
            }
        }
    }

    public boolean isMovieInSearchResults() throws NoSuchElementException {
        try {
            driver.findElement(lblSearchResults2).isDisplayed();
            System.out.println("Searched Movie in search results");
            return true;
        }catch(Exception e){
            System.out.println("Searched Movie not in search results");
            return false;
        }
    }

    public void scrollToFanFavorites(){
        WebElement element1 = driver.findElement(lblFanFavorites);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

    }

    public boolean isDisplayedBookMark() {
        return  driver.findElement(btnBookMark).isDisplayed();
    }

    public boolean isDisplayedImage() {
        return  driver.findElement(btnImage).isDisplayed();
    }


    public boolean isDisplayedRating() {
        return  driver.findElement(lblRating).isDisplayed();
    }

    public String getTextMovieName() {
        return  driver.findElement(btnMovieName).getText();
    }

    public boolean isDisplayedWatchList() {
        return  driver.findElement(btnWatchList).isDisplayed();
    }

    public boolean isDisplayedTrailer() {
        return  driver.findElement(btnTrailer).isDisplayed();
    }

    public void clickTrailer() {
        driver.findElement(btnTrailer).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(btnTrailer));

    }


    public boolean isDisplayedVideo() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(video));
        wait.until(ExpectedConditions.elementToBeClickable(video));
        return  driver.findElement(video).isDisplayed();
    }

}
