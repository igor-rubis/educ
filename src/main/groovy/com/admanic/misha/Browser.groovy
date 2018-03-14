package com.admanic.misha

import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class Browser {
    private static WebDriver DRIVER

    private Browser() {}

    static WebDriver getInstance() {
        if (!DRIVER) {
            switch (System.getProperty('browser', 'chrome')) {
                case 'chrome':
                    ChromeDriverManager.getInstance().setup()
                    DRIVER = new ChromeDriver()
                    break
                case 'firefox':
                    FirefoxDriverManager.getInstance().setup()
                    DRIVER = new FirefoxDriver()
                    break
            }
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
