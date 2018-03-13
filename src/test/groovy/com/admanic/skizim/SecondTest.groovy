package com.admanic.skizim

import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import static com.admanic.skizim.Browser.*
import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.MatcherAssert.assertThat

class SecondTest {
    @Test
    void secondTest2() {
        getInstance().get("https://pn.com.ua/")

        WebElement laptops = getInstance().findElement(By.cssSelector('[href*="1003"]'))
        laptops.click()

        WebElement firstItem = getInstance().findElement(By.cssSelector(".catalog-block-head>a"))
        String fItem = firstItem.getText()
        firstItem.click()

        WebElement itemPage = getInstance().findElement(By.cssSelector(".breadcrumb>li>h1>span"))
        String iPage = itemPage.getText()

        assertThat(iPage, containsString(fItem))

    }

    @After
    void tearDown() {
        killBrowser()
    }
}