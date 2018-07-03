package com.gmail.nemo31.nn.tests;

import com.gmail.nemo31.nn.pages.CatalogPage;
import com.gmail.nemo31.nn.pages.MarketMainPage;
import com.gmail.nemo31.nn.pages.SearchResultPage;
import com.gmail.nemo31.nn.pages.YandexMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortingPriceTest extends BaseTest {
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
    public void sortingPriceTest(){
        driver.get("https://yandex.by/");
        yandexMainPage.clickMarketButton();
        marketMainPage.clickElectronicsButton();
        catalogPage.clickActionCameraButton();
        catalogPage.clickSortingPriceButton();
        String actualAtrributeValue = catalogPage.getFilterSorterValue();
        Assert.assertEquals(actualAtrributeValue, "n-filter-sorter i-bem n-filter-sorter_js_inited n-filter-sorter_sort_desc n-filter-sorter_state_select");
    }
}
