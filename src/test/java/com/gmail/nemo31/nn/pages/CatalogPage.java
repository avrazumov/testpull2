package com.gmail.nemo31.nn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {
    public CatalogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = "h2 > a")
    public WebElement actionCameraButton;

    @FindBy(css = ".n-filter-block_pos_left.i-bem div:nth-child(3)")
    public WebElement sortingPriceButton;

    @FindBy(css = ".n-filter-sorter_state_select")
    public WebElement filterSorter;

    @FindBy(css = ".layout-grid__col_width_2 > div > div:nth-child(2) > div > a:nth-child(1)")
    public WebElement fridgesButton;

    @FindBy(name = "Ширина до")
    public WebElement widthToField;

    @FindBy(css = ".headline__header h1")
    public WebElement sortingTitle;

    public void clickActionCameraButton(){
        actionCameraButton.click();
    }

    public void clickSortingPriceButton(){
        sortingPriceButton.click();
        sortingPriceButton.click();
    }

    public String getFilterSorterValue(){
        String text = filterSorter.getAttribute("class");
        return text;
    }

    public void clickFridgesButton(){
        fridgesButton.click();
    }

    public void setWidthToField(String width){
        widthToField.sendKeys(width);
    }

    public String getSortingTitle(){
        (new WebDriverWait(driver,200)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".n-breadcrumbs__item_seo_yes")));
        String sortingTitleText = sortingTitle.getText();
        return sortingTitleText;
    }

}
