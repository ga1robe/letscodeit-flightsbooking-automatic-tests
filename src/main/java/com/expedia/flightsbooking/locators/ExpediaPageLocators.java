package com.expedia.flightsbooking.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaPageLocators {
    WebDriver driver;

    //xpath://*/ul[@id="uitk-tabs-button-container"]/div/li/a[@aria-controls="wizard-flight-tab-oneway"]
//    @FindBy(id="tab-flight-tab")
    @FindBy(xpath="//*/ul[@id=\"uitk-tabs-button-container\"]/div/li/a[@aria-controls=\"wizard-flight-tab-oneway\"]")
    private WebElement flightTab;

    //xpath://*/ul[@id="uitk-tabs-button-container"]/div/li/a[@aria-controls="wizard-flight-tab-roundtrip"]
//    @FindBy(id="flight-type-roundtrip-label")
    @FindBy(xpath="//*/ul[@id=\"uitk-tabs-button-container\"]/div/li/a[@aria-controls=\"wizard-flight-tab-roundtrip\"]")
    private WebElement roundTrip;

    //xpath://*/ul[@id="uitk-tabs-button-container"]/div/li/a[@aria-controls="wizard-flight-tab-multicity"]
//    @FindBy(id="flight-type-multi-dest-label")
    @FindBy(xpath="//*/ul[@id=\"uitk-tabs-button-container\"]/div/li/a[@aria-controls=\"wizard-flight-tab-multicity\"]")
    private WebElement multipleDestination;

    public ExpediaPageLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void clickRoundTrip() {
        try {
            roundTrip.click();
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch(NullPointerException nullPointerException) {
            System.out.println("NullPointerException: " + nullPointerException.getMessage());
        }
    }

    public void clickFlightTab() {
        try {
            flightTab.click();
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch(NullPointerException nullPointerException) {
            System.out.println("NullPointerException: " + nullPointerException.getMessage());
        }
    }

//    public void clickroundTrip() { roundTrip.click(); }

//    public void clickMultipleDestination() { multipleDestination.click(); }

    public void clickMultipleDestination() {
        try {
            multipleDestination.click();
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch(NullPointerException nullPointerException) {
            System.out.println("NullPointerException: " + nullPointerException.getMessage());
        }
    }
}
