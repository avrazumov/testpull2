package com.gmail.nemo31.nn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage {
    public ComparePage(WebDriver driver){
    PageFactory.initElements(driver, this);
    this.driver = driver;
}
    public WebDriver driver;

    @FindBy(css = ".n-compare-cell_product_1731400950.n-compare-cell-draggable.i-bem.n-compare-cell_js_inited")
    public WebElement compareFirstResult;

    @FindBy(css = ".n-compare-cell_product_1731400948.n-compare-cell-draggable.i-bem.n-compare-cell_js_inited.n-compare-cell_mode_last")
    public WebElement compareSecondResult;

    @FindBy(css = ".n-compare-toolbar__action span span")
    public WebElement deleatButton;

    @FindBy(css = ".n-compare-empty__content > div.title.title_size_18")
    public WebElement emptyCompareMessage;

    public String getCompareFirstResultText(){
        String commpareFirstText = compareFirstResult.getText();
        return commpareFirstText;
    }

    public String getCompareSecondResultText(){
        String compareSecondText = compareSecondResult.getText();
        return compareSecondText;
    }

    public void deleatingCompareResults(){
        deleatButton.click();
    }

    public String getEmptyCompareMessage(){
        String emptyCompareText = emptyCompareMessage.getText();
        return emptyCompareText;
    }
}
