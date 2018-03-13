package com.admanic.misha

import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import static com.admanic.misha.Browser.*


import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo

class FirstTest {

    @Test
    void firstTest1() {
        getInstance().get("http://www.google.com")

        WebElement element = getInstance().findElement(By.name("q"))

        element.clear()
        element.sendKeys("Cheese!")

        element.submit()

        System.out.println("Page title is: " + getInstance().getTitle())

        (new WebDriverWait(getInstance(), 10)).until(new ExpectedCondition<Boolean>() {
            Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!")
            }
        })

        System.out.println("Page title is: " + getInstance().getTitle())

        assertThat(getInstance().getTitle(), equalTo('Cheese! - Пошук Google'))
    }

    @Test
    void firstTest2() {

        getInstance().get("https://hotline.ua/")

        def cityPopUpCloseButton = getInstance().findElement(By.cssSelector("[data-dropdown-id='confirm-city-detect'] .close"))
        cityPopUpCloseButton.click()

        def element = getInstance().findElement(By.name("q"))

        element.clear()
        element.sendKeys("iphone x")

        element.submit()

        new WebDriverWait(getInstance(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector('div.pages-list [data-page="2"]')))

        def element1 = getInstance().findElement(By.cssSelector('div.pages-list [data-page="2"]'))
        element1.click()

    }

    @After
    void tearDown() {
        killBrowser()
    }
}