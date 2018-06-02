package com.stuartExercises.DeliveryRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.stuartExercises.Login.Login.driver;


public class DeliveryRequest {

    private static final String PICK_UP_CARD_ID = "pickUpCard-0";
    private static final String PICK_UP_ADDRESS_FIELD_ID = "pickUpCard-0-fields-field-address";
    private static final String PICK_UP_ADDRESS = "Avinguda Diagonal 5";
    private static final String ADDRESS_FIELD_SELECTOR_CLASS = "_1KevZPfb";
    private static final String DROP_OFF_CARD_ID = "dropOffCard-0";
    private static final String DROP_OFF_ADDRESS_FIELD_ID = "dropOffCard-0-fields-field-address";
    private static final String DROP_OFF_ADDRESS = "Avinguda Diagonal 64";
    private static final String REQUEST_DELIVERY_BTN_ID = "requestButton";
    private static final String LAST_ACTIVE_JOB_PAGE_CLASS= "_1hvvIGew";
    private static final String REQUEST_DELIVERY_PARENT = "_3DvsBvhT";

    private WebElement getPickUpCardParent(){
        return driver.findElement(By.id(PICK_UP_CARD_ID));
    }

    private WebElement getDropOffCardParent(){
        return driver.findElement(By.id(DROP_OFF_CARD_ID));
    }

    private WebElement getRequestDeliveryBtnParent(){
        return driver.findElement(By.className(REQUEST_DELIVERY_PARENT));
    }

    public String getPickUpCardTitle() {
        waitForIdToBeVisible(PICK_UP_CARD_ID);
        WebElement pickUpCard = getPickUpCardParent().findElement(By.id(PICK_UP_CARD_ID));
        return pickUpCard.getText();
    }

    private void waitForIdToBeVisible(String id){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    private void waitForClassToBeVisible(String className){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public void userFillsPickUpField() {
        waitForIdToBeVisible(PICK_UP_ADDRESS_FIELD_ID);
        WebElement pickUpAddressField = getPickUpCardParent().findElement(By.id(PICK_UP_ADDRESS_FIELD_ID));
        pickUpAddressField.clear();
        pickUpAddressField.sendKeys(PICK_UP_ADDRESS);
        waitForClassToBeVisible(ADDRESS_FIELD_SELECTOR_CLASS);
        List<WebElement> addressesSelector = getPickUpCardParent().findElements(By.className(ADDRESS_FIELD_SELECTOR_CLASS));
        addressesSelector.get(0).click();
    }

    public void userFillsDestinationField() {
        waitForIdToBeVisible(DROP_OFF_ADDRESS_FIELD_ID);
        WebElement dropOffAddressField = getDropOffCardParent().findElement(By.id(DROP_OFF_ADDRESS_FIELD_ID));
        dropOffAddressField.clear();
        dropOffAddressField.sendKeys(DROP_OFF_ADDRESS);
        waitForClassToBeVisible(ADDRESS_FIELD_SELECTOR_CLASS);
        List<WebElement> addressesSelector = getDropOffCardParent().findElements(By.className(ADDRESS_FIELD_SELECTOR_CLASS));
        addressesSelector.get(0).click();
    }

    public void userRequestsDelivery() {
        //waitForIdToBeVisible(REQUEST_DELIVERY_BTN_ID);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(REQUEST_DELIVERY_BTN_ID)));
        WebElement requestDeliveryBtn = getRequestDeliveryBtnParent().findElement(By.id(REQUEST_DELIVERY_BTN_ID));
        requestDeliveryBtn.click();
    }

    public String getLastActiveJobAddresses() {
        waitForClassToBeVisible(LAST_ACTIVE_JOB_PAGE_CLASS);
        WebElement activeJob = driver.findElement(By.className(LAST_ACTIVE_JOB_PAGE_CLASS));
        return activeJob.getText();
    }
}
