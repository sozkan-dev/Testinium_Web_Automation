package com.example.testinium_study_case;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageObjects.*;

import java.io.IOException;

import static driver.DriverFactory.cleanDriver;

public class OrderTest {
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;

    public OrderTest() throws IOException {
        super();
    }

    @BeforeEach
    public void setUp() {
        BasePage.getDriver();
    }

    @AfterEach
    public void tearDown() {
        cleanDriver();
    }


    @Test
    public void orderTest() throws IOException, InterruptedException {
        HomePage homePage = new HomePage();
        homePage.go_to_homepage();
        homePage.accept_cookies();
        Assert.assertEquals(homePage.getTabName(), "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu");
        homePage.typeKey(0);
        homePage.searchKey(1);

        SearchPage searchPage = new SearchPage();
        searchPage.selectProduct();

        ProductPage productPage = new ProductPage();
        productPage.productInfoToTxt();
        productPage.addProductToBasket();

        CartPage cartPage = new CartPage();
        Thread.sleep(10);
        Assert.assertTrue(cartPage.isCorrectPrice());
        Assert.assertTrue(cartPage.isQuantityMatch(1));
        Assert.assertTrue(cartPage.isDeleted());

    }

}