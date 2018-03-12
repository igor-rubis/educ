package com.admanic.skizim

import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver

import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.MatcherAssert.assertThat

class SecondTest {

    WebDriver driver

    @Test
    void secondTest2() {
        FirefoxDriverManager.getInstance().setup()
        driver = new FirefoxDriver()

        driver.get("https://pn.com.ua/")

        WebElement laptops = driver.findElement(By.cssSelector('[href*="1003"]'))
        laptops.click()

        WebElement firstItem = driver.findElement(By.cssSelector(".catalog-block-head>a"))
        String fItem = firstItem.getText()
        firstItem.click()

        WebElement itemPage = driver.findElement(By.cssSelector(".breadcrumb>li>h1>span"))
        String iPage = itemPage.getText()

        assertThat(iPage, containsString(fItem))

    }

    @After
    void tearDown(){
        driver.quit()
    }
}