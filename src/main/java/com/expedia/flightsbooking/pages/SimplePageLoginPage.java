package com.expedia.flightsbooking.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimplePageLoginPage {

    ExtentTest test;
    WebDriver driver = null;

    public SimplePageLoginPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void clickSignUpLink() {
        WebElement signupLink = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div/div[4]/a/div"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signup link");
    }

    public void login(String email, String password) {
        fillInEmailField(email);
        fillInPasswordField(password);
        clickGoButton();
    }

    private void fillInEmailField(String s) {
        WebElement emailField = driver.findElement(By.xpath("//*/input[@id=\"email\"]"));
        emailField.sendKeys(s);
        test.log(LogStatus.INFO, "Enter email");
    }

    private void fillInPasswordField(String s) {
        WebElement passwordField = driver.findElement(By.xpath("//*/input[@id=\"password\"]"));
        passwordField.sendKeys(s);
        test.log(LogStatus.INFO, "Enter password");
    }

    private void clickGoButton() {
        WebElement goButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[4]/div[1]/input"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go button");
    }

    public boolean isWelcomeTextPresent() {
        WebElement welcomeText = null;
        try {
            welcomeText = getWelcomeText();
            if (welcomeText != null) {
                return true;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            test.log(LogStatus.ERROR, e.getMessage());
            return false;
        }
        return false;
    }

    private WebElement getWelcomeText() {
        return driver.findElement(By.xpath("/html/body/div[@id=\"page\"]/div[contains(@class,\"block hero full-vheight\")]/div/div/div/div/div/div[2]/div/div/a/div[1]/div[2]/div/span[contains(@class,\"zen-course-author-name\")][contains(text(),\"Let's Kode It\")]"));
    }
}
