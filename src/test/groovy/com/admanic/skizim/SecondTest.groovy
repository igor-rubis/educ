package com.admanic.skizim

import com.admanic.commons.browser.Browser
import org.junit.After
import org.junit.Test

import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.MatcherAssert.assertThat

class SecondTest {
    @Test
    void secondTest2() {
        Browser.instance.get('https://pn.com.ua/')
        HomePage home = new HomePage()
        home.openLaptops()
        LaptopsPage laptops = new LaptopsPage()
        laptops.openFirstItem()
        ProductPage product = new ProductPage()
        assertThat(product.getNameText(), containsString (laptops.getFirstItemText()))
    }
    @After
    void tearDown() {
        Browser.killBrowser()
    }
}