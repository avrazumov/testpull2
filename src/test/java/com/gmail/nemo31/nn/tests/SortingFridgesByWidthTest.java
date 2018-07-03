package com.gmail.nemo31.nn.tests;

import com.gmail.nemo31.nn.pages.CatalogPage;
import com.gmail.nemo31.nn.pages.MarketMainPage;
import com.gmail.nemo31.nn.pages.SearchResultPage;
import com.gmail.nemo31.nn.pages.YandexMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortingFridgesByWidthTest extends BaseTest {
    public static YandexMainPage yandexMainPage;
    public static MarketMainPage marketMainPage;
    public static SearchResultPage searchResultPage;
    public static CatalogPage catalogPage;

    @BeforeClass
    protected void initiliaze(){
        yandexMainPage = new YandexMainPage(driver);
        marketMainPage = new MarketMainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        catalogPage = new CatalogPage(driver);
    }

    @Test
    public void sortingFridges(){
        driver.get("https://yandex.by/");
        yandexMainPage.clickMarketButton();
        marketMainPage.clickAppliancesButton();
        catalogPage.clickFridgesButton();
        catalogPage.setWidthToField("50");
        String actualSortingTitle = catalogPage.getSortingTitle();
        Assert.assertEquals(actualSortingTitle, "Холодильники шириной до 50 см");
    }
}
