package com.admanic.skizim

import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.MatcherAssert.assertThat

class ThirdTest {
    WebDriver driver

    @Test
    void thirdTest3() {
        FirefoxDriverManager.getInstance().setup()
        driver = new FirefoxDriver()
        driver.get("https://www.linkedin.com/")

        WebElement login = driver.findElement(By.cssSelector('.login-email'))
        login.sendKeys("blablabla")

        WebElement password = driver.findElement(By.cssSelector('.login-password'))
        password.sendKeys("blablabla")

        WebElement lButton = driver.findElement(By.cssSelector('.login'))
        lButton.click()

        WebDriverWait wait = new WebDriverWait(driver, 10)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector('.stat-container [data-control-name=identity_wvmp]')))

        WebElement viewsCount = driver.findElement(By.cssSelector('.stat-container [data-control-name=identity_wvmp]'))

        assertThat(viewsCount.getText(), containsString('76'))
    }

    @After
    void tearDown(){
        driver.quit()
    }
}
