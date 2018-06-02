package com.stuartExercises.DeliveryRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.stuartExercises.Login.Login.driver;


public class DeliveryRequest {

    private static final String PICK_UP_CARD_ID = "pickUpCard-0";
    private static final String PICK_UP_ADDRESS_FIELD_ID = "pickUpCard-0-fields-field-address";
    private static final String ADDRESS_FIELD_SELECTOR_CLASS = "_1KevZPfb";
    private static final String DROP_OFF_ADDRESS_FIELD_ID = "dropOffCard-0-fields-field-address";
    private static final String DROP_OFF_ADDRESS = "Avinguda Diagonal 50";
    private static final String TRANSPORT_CAR_RADIO_BTN_CLASS = "_1_9ly3pq";
    private static final String REQUEST_DELIVERY_BTN_ID = "requestButton";
    private static final String LAST_ACTIVE_JOB_PAGE_CLASS= "_1hvvIGew";
    private static final String TRANSPORT_PRICES_CLASS = "_2GUaVkNp";

    public String getPickUpCard() {
        WebElement pickUpCard = waitForIdToBeVisible(PICK_UP_CARD_ID);
        return pickUpCard.getText();
    }

    private WebElement waitForIdToBeVisible(String id){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(id)));

    }

    private void waitForClassToBeVisible(String className){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public void userFillsPickUpField() {
        WebElement pickUpAddressField = waitForIdToBeVisible(PICK_UP_ADDRESS_FIELD_ID);
        pickUpAddressField.click();
        waitForClassToBeVisible(ADDRESS_FIELD_SELECTOR_CLASS);
        List<WebElement> addressesSelector = driver.findElements(By.className(ADDRESS_FIELD_SELECTOR_CLASS));
        addressesSelector.get(3).click();
    }

    public void userFillsDestinationField() {
        WebElement pickUpAddressField = driver.findElement(By.id(DROP_OFF_ADDRESS_FIELD_ID));
        pickUpAddressField.sendKeys(DROP_OFF_ADDRESS);
        waitForClassToBeVisible(ADDRESS_FIELD_SELECTOR_CLASS);
        List<WebElement> addressesSelector = driver.findElements(By.className(ADDRESS_FIELD_SELECTOR_CLASS));
        addressesSelector.get(3).click();
    }

    public void userSelectsCarAsVehicle() {
        waitForClassToBeVisible(TRANSPORT_PRICES_CLASS);
        WebElement transportCar = driver.findElement(By.className(TRANSPORT_CAR_RADIO_BTN_CLASS));
        transportCar.click();
    }

    public void userRequestsDelivery() {
        waitForClassToBeVisible(REQUEST_DELIVERY_BTN_ID);
        WebElement requestDeliveryBtn = driver.findElement(By.id(REQUEST_DELIVERY_BTN_ID));
        requestDeliveryBtn.click();
    }

    public String getLastActiveJobAddresses() {
        waitForClassToBeVisible(LAST_ACTIVE_JOB_PAGE_CLASS);
        WebElement activeJob = driver.findElement(By.className(LAST_ACTIVE_JOB_PAGE_CLASS));
        return activeJob.getText();
    }

}
