package com.gmail.nemo31.nn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = ".b-zone_js_inited > div:nth-child(1) > div.n-snippet-cell2__hover > div > div > div")
    public WebElement addToCompare1;

    @FindBy(css = ".b-zone_js_inited > div:nth-child(2) > div.n-snippet-cell2__hover > div > div > div")
    public WebElement addToCompare2;

    @FindBy(css = ".popup-informer__controls")
    public WebElement compareButton;

    @FindBy(css = "div:nth-child(1) > div.n-snippet-cell2__header")
    public WebElement firstResultTitle;

    @FindBy(css = "div:nth-child(2) > div.n-snippet-cell2__header")
    public WebElement secondResultTitle;

    public void clickAddToCompareButton1(){
        addToCompare1.click();
    }

    public void clickAddToCompareButton2(){
        addToCompare2.click();
    }

    public void clickCompareButton(){
        (new WebDriverWait(driver,200)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".popup-informer__controls")));
        compareButton.click();
    }

    public String getFirstResultTitle(){
        String firstTitle = firstResultTitle.getText();
        return firstTitle;
    }

    public String getSecondResultTitle(){
        String secondTitle = secondResultTitle.getText();
        return secondTitle;
    }



}
