package com.expedia.flightsbooking;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.expedia.flightsbooking.pages.SearchExpediaPage;

public class TestNGTestSuite {
    private WebDriver driver;
    private String baseUrl;
    static Logger log = Logger.getLogger(TestNGTestSuite.class);

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        PropertyConfigurator.configure("log4j.properties");
        driver.get(baseUrl);
    }

    @Test
    public void fillBasicInfo() throws Exception {
        SearchExpediaPage.navigateToFlightsTab(driver);
        SearchExpediaPage.fillOriginTextBox(driver, "New York");
        try {
            SearchExpediaPage.fillDestinationTextBox(driver, "Chicago");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            SearchExpediaPage.fillDepartureDateTextBox(driver, "12/25/2015");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            SearchExpediaPage.fillReturnDateTextBox(driver, "12/31/2015");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
