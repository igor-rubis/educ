package com.admanic.skizim

import com.admanic.commons.browser.Browser
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class LaptopsPage {

    static getFirstItemText(){
        Browser.instance.findElement(By.cssSelector('.catalog-block-head>a')).getText()
    }

    static void openFirstItem(){
        WebElement fItem = Browser.instance.findElement(By.cssSelector('.catalog-block-head>a'))
        fItem.click()
    }

}
