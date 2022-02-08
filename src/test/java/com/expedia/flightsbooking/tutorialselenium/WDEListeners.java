package com.expedia.flightsbooking.tutorialselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WDEListeners {
    public static void main(String[] args) {
        String baseUrl = "https://www.expedia.com/";
        WebDriver driver = new FirefoxDriver();

        EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
        HandleEvents handleEvents = new HandleEvents();
        eDriver.register(handleEvents);

        eDriver.get(baseUrl);
//        eDriver.findElement(By.id("tab-flight-tab")).click();
        eDriver.findElement(By.xpath("/html/body/div[@id=\"app-blossom-flex-ui\"]/div[@id=\"app-layer-manager\"]/div/div/div/div[@class=\"uitk-cell\"]/div/div[@data-testid=\"storefront-region\"]/div/div/div/div/div/ul/li[@class=\"uitk-tab\"]/a/span[@class=\"uitk-tab-text\"][contains(text(),\"Flights\")]")).click();
        eDriver.close();
    }
}
