package com.gmail.nemo31.nn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketMainPage {
    public MarketMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(id = "header-search")
    public WebElement searchField;

    @FindBy(css = ".search2__button")
    public WebElement searchButton;

    @FindBy(css = "li:nth-child(1) > a")
    public WebElement electronicsButton;

    @FindBy(css = " li:nth-child(3) > a")
    public WebElement appliancesButton;

    public void setSearchText(String searchText){
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickElectronicsButton(){
        electronicsButton.click();
    }

    public void clickAppliancesButton(){
        appliancesButton.click();
    }



}
