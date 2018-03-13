package com.admanic.skizim

import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import static com.admanic.skizim.Browser.*

class FirstTest {
    @Test
    void firstTest1() {
        getInstance().get("http://www.google.com")
        WebElement element = getInstance().findElement(By.name("q"))
        element.sendKeys("Cheese!")
        element.submit()
        System.out.println("Page title is: " + getInstance().getTitle())
        (new WebDriverWait(getInstance(), 10)).until(new ExpectedCondition<Boolean>() {
            Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!")
            }
        })

                System.out.println("Page title is: " + getInstance().getTitle())
    }

    @After
    void tearDown() {
        killBrowser()
    }

}
