package com.expedia.flightsbooking.pages;
import com.expedia.flightsbooking.utilities.WaitTypes;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class SearchExpediaPage {
    public static WebElement element = null;
    static Logger log = Logger.getLogger(SearchExpediaPage.class);

    /**
     * Clear all the fields on the Search page
     * @param driver
     */
    public static void clearAllFields(WebDriver driver) {
        driver.findElement(By.id("flight-origin")).clear();
        driver.findElement(By.id("flight-destination")).clear();
        driver.findElement(By.id("flight-departing")).clear();
        driver.findElement(By.id("flight-returning")).clear();
    }
    /**
     * Returns the flight origin text box element
     * @param driver
     * @return
     */
    public static WebElement originTextBox(WebDriver driver) {
        //xpath:/html/body/div[1]/div[1]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]/button
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]/button")).click();
//        element = driver.findElement(By.id("flight-origin"));
        element = driver.findElement(By.id("location-field-leg1-origin"));
        log.info("Origin text box element found");
        return element;
    }

    /**
     * Fill origin city in origin text box
     * @param driver
     * @param origin
     */
    public static void fillOriginTextBox(WebDriver driver, String origin) throws Exception {
        element = originTextBox(driver);
        element.sendKeys(origin);
        Thread.sleep(2*1000);
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
        log.info("Enter origin city as ".concat(origin));
    }

    /**
     * Returns the flight destination text box element
     * @param driver
     * @return
     */
    public static WebElement destinationTextBox(WebDriver driver) {
        try {
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div/div/div[1]/div[1]/button")).click();
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
            log.warn("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        finally {
            log.info("Destination button element scrolls");
        }
        try {
//        element = driver.findElement(By.id("flight-destination"));
            element = driver.findElement(By.id("location-field-leg1-destination"));
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
            log.warn("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        finally {
            log.info("Destination text box element found");
        }
        return element;
    }

    /**
     * Fill destination city in destination text box
     * @param driver
     * @param destination
     */
    public static void fillDestinationTextBox(WebDriver driver, String destination) throws Exception {
        try {
            element = destinationTextBox(driver);
            element.sendKeys(destination);
        }
        catch(StaleElementReferenceException StaleElementReferenceException){
            System.out.println("StaleElementReferenceException: " + StaleElementReferenceException.getMessage());
            log.warn("StaleElementReferenceException: " + StaleElementReferenceException.getMessage());
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
            log.warn("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        finally {
            log.info("Enter destination city as ".concat(destination));
        };
    }

    /**
     * Returns the departure date text box element
     * @param driver
     * @return
     */
    public static WebElement departureDateTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-departing"));
        return element;
    }

    /**
     * Fill departure date in departure date text box
     * @param driver
     * @param date
     */
    public static void fillDepartureDateTextBox(WebDriver driver, String date) {
        try {
            element = departureDateTextBox(driver);
            element.sendKeys(date);
        }
        catch(StaleElementReferenceException StaleElementReferenceException){
            System.out.println("StaleElementReferenceException: " + StaleElementReferenceException.getMessage());
            log.warn("StaleElementReferenceException: " + StaleElementReferenceException.getMessage());
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
            log.warn("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        finally {
            log.info("Enter departure date as ".concat(date));
        }
    }

    /**
     * Returns the return date text box element
     * @param driver
     * @return
     */
    public static WebElement returnDateTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-returning"));
        return element;
    }

    /**
     * Fill return date in return date text box
     * @param driver
     * @param date
     */
    public static void fillReturnDateTextBox(WebDriver driver, String date) {
        try {
            element = returnDateTextBox(driver);
            element.clear();
            element.sendKeys(date);
        }
        catch(StaleElementReferenceException StaleElementReferenceException){
            System.out.println("StaleElementReferenceException: " + StaleElementReferenceException.getMessage());
            log.warn("StaleElementReferenceException: " + StaleElementReferenceException.getMessage());
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
            log.warn("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        finally {
            log.info("Enter return date as ".concat(date));
        }
    }

    /**
     * Returns the search button box element
     * @param driver
     * @return
     */
    public static WebElement searchButton(WebDriver driver) {
        element = driver.findElement(By.id("search-button"));
        return element;
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
//        driver.findElement(By.id("header-history")).click(); // origin version
        try {
            driver.findElement(By.xpath("/html/body/div[@id=\"app-blossom-flex-ui\"]/div[@id=\"app-layer-manager\"]/div/div[@class=\"uitk-grid pageWhiteBackground\"]/header/section/div/div/nav/div/button")).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
            log.warn("NoSuchElementException: " + noSuchElementException.getMessage());
        }
//        element = driver.findElement(By.id("tab-flight-tab")); // origin version
        try {
            //xpath:/html/body/div[@id="app-blossom-flex-ui"]/div[@id="app-layer-manager"]/div/div[@class="uitk-grid pageWhiteBackground"]
            //xpath:/html/body/div[@id="app-blossom-flex-ui"]/div[@id="app-layer-manager"]/div/div[@class="uitk-grid pageWhiteBackground"]/header/section/div/div/nav/div/div/div/a[@class="uitk-link uitk-list-item uitk-link-layout-default uitk-type-300"][@href="/Flights"]
            //xpath:/html/body/div[1]/div[1]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div/div/div/div/div/ul/li[2]/a/span
            element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div/div/div/div/div/ul/li/a[@href=\"?pwaLob=wizard-flight-pwa\"]/span"));
            element.click();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
            log.warn("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        log.info("Navigate to flights tab");
    }

    /**
     * Click on Advanced Options link
     * @param driver
     */
    public static void clickOnAdvancedLink(WebDriver driver) {
        element = driver.findElement(By.id("advanced-options"));
        element.click();
        log.info("Clicked on Advanced Options link");
    }
    /**
     * Click non-stop check box
     * @param driver
     */
    public static void clickNonStopCheckBox(WebDriver driver) {
        element = driver.findElement(By.id("advanced-flight-nonstop"));
        element.click();
        log.info("Clicked non-stop check box");
    }
    /**
     * Select flight class
     * @param driver
     */
    public static void selectFlightClass(WebDriver driver, String flightClass) {
        Select options = new Select(driver.findElement(By.id("flight-advanced-preferred-class")));
        options.selectByValue(flightClass);
        log.info("Select flight class as ".concat(flightClass));
    }
    /**
     * Click on Morning check box to filter the results
     * @param driver
     */
    public static void clickMorningFlight(WebDriver driver) {
        WebElement element = WaitTypes.getWhenVisible(driver,
                By.xpath("//ul[@id='departureTimeList']//span[contains(text(), 'Morning')]//preceding-sibling::input"), 30);
        element.click();
        log.info("Clicked on Morning Time to filter the results");
    }
    /**
     * Select flight adults
     * @param driver
     * @param flightAdults
     */
    public static void selectFlightAdults(WebDriver driver, String flightAdults) {
        Select options = new Select(driver.findElement(By.id("flight-adults")));
        options.selectByValue(flightAdults);
        log.info("Select flight adults as ".concat(flightAdults));
    }
}
