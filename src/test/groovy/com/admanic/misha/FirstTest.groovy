package com.admanic.misha

import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo

class FirstTest {

    WebDriver driver

//    @Test
    void firstTest1() {
        FirefoxDriverManager.getInstance().setup()
        driver = new FirefoxDriver()

        driver.get("http://www.google.com")

        WebElement element = driver.findElement(By.name("q"))

        element.clear()
        element.sendKeys("Cheese!")

        element.submit()

        System.out.println("Page title is: " + driver.getTitle())

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!")
            }
        })

        System.out.println("Page title is: " + driver.getTitle())

        assertThat(driver.getTitle(), equalTo('Cheese! - Пошук Google'))
    }

//    @Test
    void firstTest2() {
        FirefoxDriverManager.getInstance().setup()
        driver = new FirefoxDriver()

        driver.get("https://hotline.ua/")

        def cityPopUpCloseButton = driver.findElement(By.cssSelector("[data-dropdown-id='confirm-city-detect'] .close"))
        cityPopUpCloseButton.click()

        def element = driver.findElement(By.name("q"))

        element.clear()
        element.sendKeys("iphone x")

        element.submit()

        def explicitWait = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector('div.pages-list [data-page="2"]')))

        def element1 = driver.findElement(By.cssSelector('div.pages-list [data-page="2"]'))
        element1.click()

    }

    @Test
    void firstTest3() {
        FirefoxDriverManager.getInstance().setup()
        driver = new FirefoxDriver()

        driver.get("https://hotline.ua/")
    }

    @After
    void tearDown() {
        driver.quit()
    }
}