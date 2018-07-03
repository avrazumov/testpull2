package com.gmail.nemo31.nn.pages;

import com.gmail.nemo31.nn.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class ArtistPage {
    public ArtistPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = ".d-generic-page-head__main-top h1")
    public WebElement artistTitle;

    @FindBy(css = "div:nth-child(3) a")
    public WebElement albums;

    @FindBy(css = "div:nth-child(1) > div.d-track__start-column > div.d-track__cover div")
    public WebElement firstSong;

    @FindBy(css = ".progress__bar.progress__progress > div")
    public WebElement progressBar;

    @FindBy(css = ".volume__bar div div div")
    public WebElement slider;

    public void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }
    }
    
    public String getArtistName(){
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".d-generic-page-head__main-top h1")));
        String artistName = artistTitle.getText();
        return artistName;
    }

    public void clickAlbums(){
        (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div:nth-child(3) a")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",albums);
        albums.click();
    }

    public void playSong(){
        wait(1000);
        (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div:nth-child(1) > div.d-track__start-column > div.d-track__cover div")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",firstSong);
        firstSong.click();
    }

    public boolean checkProgress() {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".progress__bar.progress__progress > div")));
        int res1 = progressBar.getAttribute("style").length();
        wait(5000);
        int res2 = progressBar.getAttribute("style").length();
        return res1 != res2;
    }

    public boolean cheskSlider() {
        String strSlider = slider.getAttribute("style");
        strSlider = strSlider.substring(8, strSlider.length() - 2);
        return Double.parseDouble(strSlider) != 0.0;
    }



}
