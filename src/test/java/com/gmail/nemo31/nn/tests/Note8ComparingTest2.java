package com.gmail.nemo31.nn.tests;

import com.gmail.nemo31.nn.pages.ComparePage;
import com.gmail.nemo31.nn.pages.MarketMainPage;
import com.gmail.nemo31.nn.pages.SearchResultPage;
import com.gmail.nemo31.nn.pages.YandexMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Note8ComparingTest2 extends BaseTest{
    public static YandexMainPage yandexMainPage;
    public static MarketMainPage marketMainPage;
    public static SearchResultPage searchResultPage;
    public static ComparePage comparePage;

    @BeforeClass
    protected void initiliaze(){
        yandexMainPage = new YandexMainPage(driver);
        marketMainPage = new MarketMainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        comparePage = new ComparePage(driver);
    }

    @Test
    public void note8ComparingWithDeleating(){
        driver.get("https://yandex.by/");
        yandexMainPage.clickMarketButton();
        marketMainPage.setSearchText("Note 8");
        marketMainPage.clickSearchButton();
        searchResultPage.clickAddToCompareButton1();
        searchResultPage.clickAddToCompareButton2();
        String firstResultTitle = searchResultPage.getFirstResultTitle();
        String secondsResultTitle = searchResultPage.getSecondResultTitle();
        searchResultPage.clickCompareButton();
        String compareFirstResultTitle = comparePage.getCompareFirstResultText();
        String compareSecondResultTitle = comparePage.getCompareSecondResultText();
        Assert.assertEquals(firstResultTitle, compareSecondResultTitle);
        Assert.assertEquals(secondsResultTitle, compareFirstResultTitle);
        comparePage.deleatingCompareResults();
        String actualEmptyMessage = comparePage.getEmptyCompareMessage();
        Assert.assertEquals(actualEmptyMessage, "Товаров нет. Чтобы увидеть ранее добавленные вами товары, авторизуйтесь.");
    }
}
