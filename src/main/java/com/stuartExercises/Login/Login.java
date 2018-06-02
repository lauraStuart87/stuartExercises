package com.stuartExercises.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class Login {

    private final static String SYSTEM_PROPERTY = System.setProperty("webdriver.chrome.driver", "/Users/MundoTrekkie/Documents/chromedriver");
    private final static String EMAIL = "***";
    private final static String PASSWORD = "***";

    private final static String EMAIL_FIELD_ID = "email";
    private final static String PASSWORD_FIELD_ID = "password";
    private final static String LOGGING_BTN_ID = "logInButton";

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    private void setUpDriver(){
        driver = new ChromeDriver();
    }

    private void openPage() {
        setUpDriver();
        driver.get("http://dashboard-sandbox.stuart.com");
    }

    public void closePage(){
        //Clear the cookies on the browser
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        //Close the browser
        driver.close();
    }

    private void logInPage() {
        inputEmail();
        inputPassword();
        startSession();
    }

    public void userLogsIn(){
        openPage();
        logInPage();
    }

    private void inputEmail(){
        WebElement emailField = driver.findElement(By.id(EMAIL_FIELD_ID));
        emailField.sendKeys(EMAIL);
    }

    private void inputPassword(){
        WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD_ID));
        passwordField.sendKeys(PASSWORD);
    }

    private void startSession(){
        WebElement startSessionBtn = driver.findElement(By.id(LOGGING_BTN_ID));
        startSessionBtn.click();
    }
}
