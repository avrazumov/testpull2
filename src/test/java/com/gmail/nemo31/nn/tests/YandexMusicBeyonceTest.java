package com.gmail.nemo31.nn.tests;

import com.gmail.nemo31.nn.pages.ArtistPage;
import com.gmail.nemo31.nn.pages.LoginPage;
import com.gmail.nemo31.nn.pages.MusicPage;
import com.gmail.nemo31.nn.pages.YandexMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YandexMusicBeyonceTest extends BaseTest {
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

    @Test
    public void beyonceTest(){
        driver.get("https://www.yandex.by/");
        yandexMainPage.clickMusickButton();
        musicPage.setSerchInput("b");
        musicPage.setSerchInput("e");
        musicPage.setSerchInput("yo");
        musicPage.clickSuggestArtist();
        artistPage.playSong();
        Assert.assertTrue(artistPage.checkProgress());
        Assert.assertTrue(artistPage.cheskSlider());
    }
}
