package com.expedia.flightsbooking.pages;

import com.expedia.flightsbooking.locators.ExpediaPageLocators;
import org.openqa.selenium.*;

public class ExpediaPage {
    public static WebElement element = null;
    private static WebDriver driver = null;
    private static ExpediaPageLocators expediaPageLocators = new ExpediaPageLocators(driver);

    /**
     * Returns the flight origin text box element
     * @param driver
     * @return
     */
    public static WebElement originTextBox(WebDriver driver) {
//        element = driver.findElement(By.id("flight-origin"));
        try {
            //Selector:#location-field-leg1-origin-menu > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > div.uitk-field.has-floatedLabel-label.has-no-placeholder > button
            //Selector:#location-field-leg1-origin-menu > div.uitk-field.has-floatedLabel-label.has-no-placeholder > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button
//            element = driver.findElement(By.id("location-field-leg1-origin"));
            element = driver.findElement(By.cssSelector("#location-field-leg1-origin-menu > div.uitk-field.has-floatedLabel-label.has-no-placeholder > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button"));
            element.click();
            return element;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        return element;
    }

    public static void fillOriginTextBox(WebDriver driver, String origin) {
        element = originTextBox(driver);
        element.sendKeys(origin);
    }

    /**
     * Returns the flight destination text box element
     * @param driver
     * @return
     */
    public static WebElement destinationTextBox(WebDriver driver) {
        try {
//            element = driver.findElement(By.id("flight-destination"));
            element = driver.findElement(By.cssSelector("#location-field-leg1-destination-menu > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > div.uitk-field.has-floatedLabel-label.has-no-placeholder > button"));
            element.click();
            return element;
        } catch(NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        return element;
    }

    /**
     * Returns the departure date text box element
     * @param driver
     * @return
     */
    public static WebElement departureDateTextBox(WebDriver driver) {
        try {
            //Selector:#d1-btn
            //xpath://*[@id="d1-btn"]
//            element = driver.findElement(By.id("flight-departing"));
            element = driver.findElement(By.cssSelector("#d1-btn"));
            element.click();
            element.sendKeys(Keys.ENTER);
            return element;
        } catch(NoSuchElementException noSuchElementException){
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        return element;
    }

    /**
     * Returns the return date text box element
     * @param driver
     * @return
     */
    public static WebElement returnDateTextBox(WebDriver driver) {
        //xpath://*[@id="d2-btn"]
        //Selector:#d2-btn
//        element = driver.findElement(By.id("flight-returning"));
        try {
            element = driver.findElement(By.cssSelector("#d2-btn"));
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
//        element.click();
//        element.sendKeys(Keys.ENTER);
        return element;
    }

    /**
     * Returns the search button box element
     * @param driver
     * @return
     */
    public static WebElement searchButton(WebDriver driver) {
        //Selector:#wizard-flight-pwa-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-1.uitk-layout-grid-columns-medium-8.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-padding-small-blockstart-three.uitk-spacing-padding-small-blockend-six.uitk-spacing-padding-medium-blockstart-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-1.uitk-layout-grid-item-columnspan-medium-2.uitk-layout-grid-item-columnspan-large-2 > button
//        element = driver.findElement(By.id("search-button"));
        try {
            element = driver.findElement(By.cssSelector("#wizard-flight-pwa-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-1.uitk-layout-grid-columns-medium-8.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-padding-small-blockstart-three.uitk-spacing-padding-small-blockend-six.uitk-spacing-padding-medium-blockstart-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-1.uitk-layout-grid-item-columnspan-medium-2.uitk-layout-grid-item-columnspan-large-2 > button"));
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        return element;
    }

    /**
     * click on Flights link
     * @param driver
     */
    public void clickOnFlightsLink(WebDriver driver) {
        try {
            element = driver.findElement(By.xpath("//*/div[@class='uitk-tabs-container']/ul/li/a[@href='?pwaLob=wizard-flight-pwa']/span[@class='uitk-tab-text']"));
        } catch(NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        element.click();
    }

    /**
     * Click on search button
     * @param driver
     */
    public static void clickOnSearchButton(WebDriver driver) {
        element = searchButton(driver);
        element.click();
    }

    /**
     * Navigate to flights tab
     * @param driver
     */
    public static void navigateToFlightsTab(WebDriver driver) {
        driver.findElement(By.id("header-history")).click();
        element = driver.findElement(By.id("tab-flight-tab"));
        element.click();
    }
}
