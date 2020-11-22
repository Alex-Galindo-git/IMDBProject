package webPages;

import Data.SortData;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WatchListPage {

    WebDriver driver;

    private By btnEditWatchList = By.xpath("//a[@title='Edit']");
    private By chkWatchListBox = By.xpath("//div[@class='lister-edit-total ']//div[@class='element-check-wrapper']");
    private By lnkDeleteWatchList = By.xpath("//span[@class='lister-edit-actions']/a[text()='Delete']");
    private By lnkDeleteWatchListPopup = By.xpath("//input[@value='DELETE']");
    private By btnDone = By.xpath("//div[@class='lister-edit-form']/button");
    private By lblWatchCount= By.xpath("//div[@class='lister-details']/span[text()='0']");

    private By lblWatchListEmpty = By.xpath("//span[text()='Your Watchlist is empty']");
    private By lblMovieName = By.xpath("//div[@class='lister-item-content']//a[text()='The Matrix']");
    private String movieName;
    private By drpSort = By.xpath("//select[@id='lister-sort-by-options']");
    private By lblYourWatchList =By.xpath("//h1[text()='Your Watchlist']");



   public WatchListPage(WebDriver driver) {
       this.driver=driver;
   }

   public void clickEditButton(){
       WebDriverWait wait=new WebDriverWait(driver, 40);
       wait.until(ExpectedConditions.elementToBeClickable(btnEditWatchList));
       driver.findElement(btnEditWatchList).click();
       driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
   }

    public void clickChkBox(){
        WebDriverWait wait=new WebDriverWait(driver, 60);
        driver.navigate().back();
        driver.navigate().forward();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblMovieName));
        wait.until(ExpectedConditions.presenceOfElementLocated(lblMovieName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(chkWatchListBox));
        wait.until(ExpectedConditions.elementToBeClickable(chkWatchListBox));
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(chkWatchListBox).click();
   /*     driver.findElement(chkWatchListBox).click();
        driver.findElement(chkWatchListBox).click();*/
    }

    public void clickDeleteLnk(){
        WebDriverWait wait=new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lnkDeleteWatchList));
        wait.until(ExpectedConditions.elementToBeClickable(lnkDeleteWatchList));
        driver.findElement(lnkDeleteWatchList).click();
    }

    public void clickDeleteLnkPopup() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lnkDeleteWatchListPopup));
        wait.until(ExpectedConditions.elementToBeClickable(lnkDeleteWatchListPopup));
        driver.findElement(lnkDeleteWatchListPopup).click();


    }

    public LandingPage clickDoneBtn(){

        WebDriverWait wait=new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(lblWatchCount));
        wait.until(ExpectedConditions.presenceOfElementLocated(btnDone));
        wait.until(ExpectedConditions.elementToBeClickable(btnDone));
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(btnDone).click();
        return new LandingPage(driver);
    }

    public boolean isDispayWatchListEmptyText(){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblWatchListEmpty));
        return driver.findElement(lblWatchListEmpty).isDisplayed();
    }


    public void selectSortOption(String sortType){
       WebElement element =driver.findElement(drpSort);
       element.click();
       Select select = new Select(element);
       select.selectByValue(sortType);
       driver.findElement(lblYourWatchList).click();

    }


    public boolean isMovieDisplayOnTop(String movie){
        movieName=movie;
        String a= "//div[@class='lister-list mode-detail']/div[1]//a[text()='"+movieName+"']";
        WebElement element= driver.findElement(By.xpath(a));
        return element.isDisplayed();


    }

}
