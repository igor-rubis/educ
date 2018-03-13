package com.admanic.skizim

import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class Browser {
    private static WebDriver DRIVER

    private Browser() {}

    static WebDriver getInstance() {
        if (!DRIVER) {
            FirefoxDriverManager.getInstance().setup()
            DRIVER = new FirefoxDriver()
        }
        return DRIVER
    }

    static void killBrowser() {
        if (DRIVER) {
            DRIVER.quit()
            DRIVER = null
        }
    }
}