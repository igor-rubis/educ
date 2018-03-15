package com.admanic.misha

import com.admanic.commons.browser.Browser
import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo

class FirstTest {

    @Test
    void firstTest1() {
        Browser.instance.get("http://www.google.com")

        WebElement element = Browser.instance.findElement(By.name("q"))

        element.clear()
        element.sendKeys("Cheese!")

        element.submit()

        System.out.println("Page title is: " + Browser.instance.getTitle())

        (new WebDriverWait(Browser.instance, 10)).until(new ExpectedCondition<Boolean>() {
            Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!")
            }
        })

        System.out.println("Page title is: " + Browser.instance.getTitle())

        assertThat(Browser.instance.getTitle(), equalTo('Cheese! - Пошук Google'))
    }

    @Test
    void firstTest2() {

        Browser.instance.get("https://hotline.ua/")

        def cityPopUpCloseButton = Browser.instance.findElement(By.cssSelector("[data-dropdown-id='confirm-city-detect'] .close"))
        cityPopUpCloseButton.click()

        def element = Browser.instance.findElement(By.name("q"))

        element.clear()
        element.sendKeys("iphone x")

        element.submit()

        new WebDriverWait(Browser.instance, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector('div.pages-list [data-page="2"]')))

        def element1 = Browser.instance.findElement(By.cssSelector('div.pages-list [data-page="2"]'))
        element1.click()

    }

    @After
    void tearDown() {
        Browser.killBrowser()
    }
}