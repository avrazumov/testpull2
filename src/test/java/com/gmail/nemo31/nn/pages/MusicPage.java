package com.gmail.nemo31.nn.pages;

import com.gmail.nemo31.nn.tests.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MusicPage extends BaseTest {
    public MusicPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = ".deco-input__suggest input")
    public WebElement musicSearchField;

    @FindBy(css = ".d-suggest__item-artist")
    public WebElement suggestArtist;


    @FindBy(css = ".d-lang-switcher__current-lang-icon")
    public WebElement rusFlag;


    public void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }
    }

    public void setSerchInput(String artistName){
        wait(500);
        musicSearchField.sendKeys(artistName);

    }

    public void clickSuggestArtist(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",suggestArtist);
        wait(1000);
        suggestArtist.click();
    }


}
