package com.gmail.nemo31.nn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMainPage {
    public YandexMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(5)")
    public WebElement marketButton;

    @FindBy (css = ".desk-notif-card_type_login-exp.desk-notif-card_bg_default.i-bem.desk-notif-card_js_inited > div > a")
    public WebElement mailButton;

    @FindBy(css = ".home-arrow__tabs div a:nth-child(7)")
    public WebElement musicButton;

    public void clickMarketButton(){
        marketButton.click();
    }

    public void clickMailButton(){
        mailButton.click();
    }

    public void clickMusickButton(){
        musicButton.click();
    }




}
