package com.expedia.flightsbooking.basicweb;

import com.expedia.flightsbooking.locators.ExpediaPageLocators;
import com.expedia.flightsbooking.pages.ExpediaPage;
import com.expedia.flightsbooking.pages.SearchExpediaPage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestExpediaPageClass {

    private WebDriver driver;
    private String baseURL;
    private WebDriverWait wait;

//    @Before
    @BeforeClass
    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
        baseURL = "https://www.expedia.com";
        String engine = "chrome";
//        String engine = "gecko";
        switch (engine) {
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "/home/robert/.config/google-chrome/Drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "gecko":
//                System.setProperty("webdriver.gecko.driver", "/home/robert/.config/mozilla/Drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + engine);
        }
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void shouldTestExpedia(){
        driver.get(baseURL);

        //xpath:/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[4]/div[1]/div/div/div/div/div/ul/li[contains(@class,'uitk-tab')]/a[@href='?pwaLob=wizard-flight-pwa']/span[@class='uitk-tab-text']
        //xpath://*[@id="wizard-flight-pwa"]
        try {
            WebElement flightsInput = driver.findElement(By.xpath("//*[@id=\"wizard-flight-pwa\"]"));
            flightsInput.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
//        WebElement childDropdown = driver.findElement(By.id("package-1-age-select-1"));
//        System.out.println("Child Drpdown Displayed: " + childDropdown.isDisplayed());
    }

    @Test
    public void shouldFirstTestCalendarSelectionOnExpedia(){
        driver.get(baseURL);
        try {
            driver.findElement(By.xpath("//a[@aria-controls='wizard-flight-pwa']")).click();
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
        // Find departing field and click it
        try {
            WebElement departingField = driver.findElement(By.id("d1-btn"));
            departingField.click();
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Find the departure date to be selected and click it
        try {
            WebElement departureDateToSelect = driver.findElement(By.xpath("(//div[@data-stid='date-picker-month']//button[@data-day='30'])[1]"));
            departureDateToSelect.click();
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
        // Find the return date to be selected and click it
        try {
            WebElement returnDateToSelect = driver.findElement(By.xpath("(//div[@data-stid='date-picker-month']//button[@data-day='30'])[2]"));
            returnDateToSelect.click();
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
        // Wait to see the click action before clicking Done button
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            WebElement doneButton = driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']"));
            doneButton.click();
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
    }

    @Test
    public void shouldSecondTestCalendarSelectionOnExpedia(){
        driver.get(baseURL);
        // Click flights tab
        try {
            driver.findElement(By.xpath("//a[@aria-controls='wizard-flight-pwa']")).click();
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
        // Find departing field and click it
        try {
            WebElement departingField = driver.findElement(By.id("d1-btn"));
            departingField.click();
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
        WebElement calMonth = null;
        List<WebElement> allValidDates = null;
        try {
            calMonth = driver.findElement(By.xpath("(//div[@data-stid='date-picker-month'])[1]"));
            allValidDates = calMonth.findElements(By.tagName("button"));
        } catch (Exception e) {
            System.out.println("MESSAGE: " + e.getMessage() + "<<EOM");
        }
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!(allValidDates == null)) {
            for (WebElement date : allValidDates) {
                if (date.getAttribute("data-day").contains("30")) {
                    date.click();
                    break;
                }
            }
        }
        // **************** IMPORTANT ****************
        // After the above action,
        // you will still see the calendar open because in this loop we only selected departure date
    }

    @Test
    public void shouldTestPageObjectModelExpedia(){
        driver.get(baseURL);
        ExpediaPage searchPage = new ExpediaPage();
        searchPage.clickOnFlightsLink(driver);
        searchPage.fillOriginTextBox(driver, "  Harrisburg (MDT - Harrisburg Intl.)");
        searchPage.destinationTextBox(driver).sendKeys("A Chicago");
        searchPage.departureDateTextBox(driver).sendKeys("12/25/2014");
        // Added a line to clear the return date text box
        // before entering the return date, because Expedia by default
        // enters the return date same as the departure date
        try {
            searchPage.returnDateTextBox(driver).clear();
        } catch (InvalidElementStateException invalidElementStateException){
            System.out.println("InvalidElementStateException: " + invalidElementStateException.getMessage()
                    + "\n\'Clear\' Action of \"" + searchPage.returnDateTextBox(driver).getText() + "\""
                    + " in " + searchPage.returnDateTextBox(driver).getTagName());
        }
        searchPage.returnDateTextBox(driver).sendKeys("12/31/2014");
        searchPage.clickOnSearchButton(driver);
    }

    @Test
    public void shouldFrameworkTestCaseExpedia(){
        driver.get(baseURL);
        ExpediaPage searchPage = new ExpediaPage();
        searchPage.clickOnFlightsLink(driver);
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExpediaPageLocators expediaPageLocators = new ExpediaPageLocators(driver);
        expediaPageLocators.clickFlightTab();
        expediaPageLocators.clickMultipleDestination();
        expediaPageLocators.clickRoundTrip();
//        expediaPageLocators.setOriginCity("New York");
//        expediaPageLocators.setDestinationCity("San Francisco");
//        expediaPageLocators.setDepartureDate("10/28/2015");
//        expediaPageLocators.setReturnDate("10/31/2015");
    }

    @Test
    public void shouldNoFrameworkTestExpedia(){
        driver.get(baseURL);
        try {
            driver.findElement(By.id("header-history")).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.xpath("//*/div[@class='uitk-tabs-container']/ul/li/a[@href='?pwaLob=wizard-flight-pwa']/span[@class='uitk-tab-text']")).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.xpath("//*/ul[@id=\"uitk-tabs-button-container\"]/div/li/a[@aria-controls=\"wizard-flight-tab-oneway\"]")).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.xpath("//*/ul[@id=\"uitk-tabs-button-container\"]/div/li/a[@aria-controls=\"wizard-flight-tab-roundtrip\"]")).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.cssSelector("#location-field-leg1-origin-menu > div.uitk-field.has-floatedLabel-label.has-no-placeholder > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button")).sendKeys("A JFK New York");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.cssSelector("#location-field-leg1-origin")).sendKeys(Keys.ENTER);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            //cssSelector:#location-field-leg1-destination-menu > div.uitk-field.has-floatedLabel-label.has-no-placeholder > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button
            driver.findElement(By.cssSelector("#location-field-leg1-destination-menu > div.uitk-field.has-floatedLabel-label.has-no-placeholder > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button")).sendKeys("A A Chicago");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.cssSelector("#location-field-leg1-destination")).sendKeys(Keys.ENTER);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            //Selector:#d1-btn
            driver.findElement(By.xpath("//*/div[@class=\"uitk-date-picker-menu uitk-menu uitk-menu-mounted\"]/div[@class=\"uitk-field has-floatedLabel-label has-icon has-placeholder\"]/button[@id=\"d1-btn\"]")).sendKeys(Keys.ENTER);
            // Select date
            //cssSelector:#wizard-flight-tab-roundtrip > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-4.uitk-layout-grid-columns-medium-6.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-padding-block-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan.uitk-layout-grid-item-columnspan-small-4.uitk-layout-grid-item-columnspan-medium-6.uitk-layout-grid-item-columnspan-large-4 > div > div > div:nth-child(1) > div > div.uitk-date-picker-menu-container.uitk-date-picker-menu-container-double.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-autoposition.uitk-menu-container-text-nowrap > div > div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > button
            if(driver.findElements(By.xpath("//*/div/div[@class=\"uitk-calendar\"]/div/button[@stid=\"date-picker-paging\"]")).size() > 0) {
                driver.findElements(By.xpath("//*/div/div[@class=\"uitk-calendar\"]/div/button[@stid=\"date-picker-paging\"]")).get(1).click();
                driver.findElements(By.xpath("//*/div/div[@class=\"uitk-calendar\"]/div/button[@stid=\"date-picker-paging\"]")).get(1).click();
            }
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElements(By.xpath("//*/div[@class=\"uitk-date-picker-menu-months-container\"]/div[@class=\"uitk-date-picker-month\"]/table[@class=\"uitk-date-picker-weeks\"]/tbody/tr[2]/td[3]/button")).get(0).click();
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[4]/div[1]/div/div/div/div/div/div/div[2]/div/form/div[2]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[@class=\"uitk-date-picker date-picker-menu\"]/div[@class=\"uitk-flex uitk-date-picker-menu-footer\"]/button")).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("//*/div[@class='uitk-date-picker-menu uitk-menu uitk-menu-mounted']/div/div[@class='uitk-date-picker date-picker-menu']/div/button")).sendKeys(Keys.ENTER);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.id("#d2-btn")).sendKeys("03/31/2022");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
        try {
            driver.findElement(By.cssSelector("#wizard-flight-pwa-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-1.uitk-layout-grid-columns-medium-8.uitk-layout-grid-columns-large-12.uitk-spacing.uitk-spacing-padding-small-blockstart-three.uitk-spacing-padding-small-blockend-six.uitk-spacing-padding-medium-blockstart-three > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-1.uitk-layout-grid-item-columnspan-medium-2.uitk-layout-grid-item-columnspan-large-2 > button")).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("NoSuchElementException: " + noSuchElementException.getMessage());
        }
    }

    @Test
    public void shouldFindLinksTestExpedia(){
        driver.get(baseURL);
        SearchExpediaPage.navigateToFlightsTab(driver);

        List<WebElement> linksList = clickableLinks(driver);
        for (WebElement link : linksList) {
            String href = link.getAttribute("href");
            try {
                System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    private List<WebElement> clickableLinks(WebDriver driver) {
        List<WebElement> linksToClick = new ArrayList<WebElement>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));

        for (WebElement webElement : elements) {
            if (webElement.getAttribute("href") != null) {
                linksToClick.add(webElement);
            }
        }
        return linksToClick;
    }

    public static String linkStatus(URL url) {
        // http://download.java.net/jdk7/archive/b123/docs/api/java/net/HttpURLConnection.html#getResponseMessage%28%29
        try {
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();
            String responseMessage = http.getResponseMessage();
            http.disconnect();
            return responseMessage;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
