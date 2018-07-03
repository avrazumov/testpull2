package com.gmail.nemo31.nn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(name = "login")
    public WebElement loginInput;

    @FindBy(name = "passwd")
    public WebElement passwordInput;

    @FindBy(className = "passport-Button-Content")
    public WebElement loginButton;

    public void setLogin(String login){
        loginInput.sendKeys(login);
    }

    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }


}
