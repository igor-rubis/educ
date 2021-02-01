package com.admanic.skizim

import com.admanic.commons.browser.Browser
import org.openqa.selenium.By

class ProductPage {
    static getNameText(){
        return Browser.instance.findElement(By.cssSelector('.breadcrumb>li>h1>span')).getText()
    }
}
