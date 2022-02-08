package com.expedia.flightsbooking.tutorialselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class HandleEvents implements WebDriverEventListener {
//    @Override
//    public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
//        System.out.println("After the change of value on " + arg0.toString());
//    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver arg1) {
        System.out.println("After clicking on element " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("before change value Of element " + webElement.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("after change value Of element " + webElement.toString());
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        System.out.println("Before clicking on element " + arg0.toString());
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        System.out.println("Just after navigating to " + arg0);
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("before navigate refresh " + webDriver.toString());
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("after navigate refresh " + webDriver.toString());
    }

    @Override
    public void afterScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("before switch to window " + webDriver.toString());
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("after switch to window " + webDriver.toString());
    }

//    @Override
//    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("before alert accept " + webDriver.toString());
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("after alert accept " + webDriver.toString());
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("after alert Dismiss " + webDriver.toString());
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("before alert Dismiss " + webDriver.toString());
    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
    }
}
