package com.admanic.misha

import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class Browser {
    private static WebDriver driver

    private Browser() {}

    static WebDriver getInstance() {
        if (driver == null) {
            FirefoxDriverManager.getInstance().setup()
            driver = new FirefoxDriver()
        }
        return driver
    }

    static void killBrowser() {
        driver.quit()
    }
}
