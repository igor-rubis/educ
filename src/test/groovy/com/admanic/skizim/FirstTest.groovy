package com.admanic.skizim

import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

class FirstTest {
    @Test
    void firstTest1() {
        FirefoxDriverManager.getInstance().setup()
        WebDriver driver = new FirefoxDriver()

        driver.get("http://www.google.com")

        WebElement element = driver.findElement(By.name("q"))

        element.sendKeys("Cheese!")


        element.submit()


        System.out.println("Page title is: " + driver.getTitle())


        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!")
            }
        })

        System.out.println("Page title is: " + driver.getTitle())

        driver.quit()
    }
}
