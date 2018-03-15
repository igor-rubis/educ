package com.admanic.skizim

import com.admanic.commons.browser.Browser
import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.MatcherAssert.assertThat

class SecondTest {
    @Test
    void secondTest2() {
        Browser.instance.get("https://pn.com.ua/")

        WebElement laptops = Browser.instance.findElement(By.cssSelector('[href*="1003"]'))
        laptops.click()

        WebElement firstItem = Browser.instance.findElement(By.cssSelector(".catalog-block-head>a"))
        String fItem = firstItem.getText()
        firstItem.click()

        WebElement itemPage = Browser.instance.findElement(By.cssSelector(".breadcrumb>li>h1>span"))
        String iPage = itemPage.getText()

        assertThat(iPage, containsString(fItem))

    }

    @After
    void tearDown() {
        Browser.killBrowser()
    }
}