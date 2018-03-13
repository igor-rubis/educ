package com.admanic.skizim

import org.junit.After
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import static com.admanic.skizim.Browser.*
import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.MatcherAssert.assertThat

class ThirdTest {
    @Test
    void thirdTest3() {
        getInstance().get("https://www.linkedin.com/")

        WebElement login = getInstance().findElement(By.cssSelector('.login-email'))
        login.sendKeys("blablabla")

        WebElement password = getInstance().findElement(By.cssSelector('.login-password'))
        password.sendKeys("blablabla")

        WebElement lButton = getInstance().findElement(By.cssSelector('.login'))
        lButton.click()

        WebDriverWait wait = new WebDriverWait(getInstance(), 10)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector('.stat-container [data-control-name=identity_wvmp]')))

        WebElement viewsCount = getInstance().findElement(By.cssSelector('.stat-container [data-control-name=identity_wvmp]'))

        assertThat(viewsCount.getText(), containsString('72'))
    }

    @After
    void tearDown() {
        killBrowser()
    }
}
