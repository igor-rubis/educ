package com.admanic.skizim

import com.admanic.commons.browser.Browser
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class HomePage {
    static void openLaptops(){
        WebElement lap1 = Browser.instance.findElement(By.cssSelector('[href*="1003"]'))
        lap1.click()
    }
}
