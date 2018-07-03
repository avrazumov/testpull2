package com.gmail.nemo31.nn.tests;

import com.gmail.nemo31.nn.pages.ArtistPage;
import com.gmail.nemo31.nn.pages.LoginPage;
import com.gmail.nemo31.nn.pages.MusicPage;
import com.gmail.nemo31.nn.pages.YandexMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YandexMusicMetallicaTest extends BaseTest {
    public static YandexMainPage yandexMainPage;
    public static LoginPage loginPage;
    public static MusicPage musicPage;
    public static ArtistPage artistPage;

    @BeforeClass
    protected void initialize(){
        yandexMainPage = new YandexMainPage(driver);
        loginPage = new LoginPage(driver);
        musicPage = new MusicPage(driver);
        artistPage = new ArtistPage(driver);
    }

    @BeforeMethod
    public void preconditions(){
        driver.get("https://www.yandex.by/");
        yandexMainPage.clickMailButton();
        loginPage.setLogin("AutotestUser");
        loginPage.setPassword("AutotestUser123");
        loginPage.clickLoginButton();
    }

    @Test
    public void metallicaTest(){
        driver.get("https://www.yandex.by/");
        yandexMainPage.clickMusickButton();
        musicPage.setSerchInput("M");
        musicPage.setSerchInput("etal");
        musicPage.clickSuggestArtist();
        String actualArtistName = artistPage.getArtistName();
        Assert.assertEquals(actualArtistName, "Metallica");
        artistPage.clickAlbums();
        String actualArtistAlbumName = artistPage.getArtistName();
        Assert.assertEquals(actualArtistAlbumName, "Metallica");
    }
}
