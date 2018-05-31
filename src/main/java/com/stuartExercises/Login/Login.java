package com.stuartExercises.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class Login {


    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "/Users/MundoTrekkie/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://dashboard-sandbox.stuart.com");
    }

    public void logIn() {
        WebElement emailField = WebDriver.findElement(By.id("email"));
    }
}
