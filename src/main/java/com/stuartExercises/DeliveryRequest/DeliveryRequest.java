package com.stuartExercises.DeliveryRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.stuartExercises.Login.Login.getDriver;


public class DeliveryRequest {

    private static final String PICK_UP_CARD_ID = "pickUpCard-0";
    private static final String PICK_UP_ADDRESS_FIELD_ID = "pickUpCard-0-fields-field-address";
    private static final String PICK_UP_ADDRESS = "Avinguda Diagonal 5";
    private static final String ADDRESS_FIELD_SELECTOR_CLASS = "_1KevZPfb";
    private static final String DROP_OFF_CARD_ID = "dropOffCard-0";
    private static final String DROP_OFF_ADDRESS_FIELD_ID = "dropOffCard-0-fields-field-address";
    private static final String DROP_OFF_ADDRESS = "Avinguda Diagonal 64";
    private static final String REQUEST_DELIVERY_BTN_ID = "requestButton";
    private static final String IN_PROGRESS_PAGE_PARENT_CLASS = "_1hvvIGew";
    private static final String LAST_ACTIVE_JOB_CARD_CLASS = "_3qv1HTOr";
    private static final String REQUEST_DELIVERY_PARENT_CLASS = "_3DvsBvhT";
    private static final String TRANSPORTATION_TYPE_BIKE = "icon-bike";
    private static final String TRANSPORTATION_CARD_PARENT_ID = "vehicleCard";
    private static final String TRANSPORTATIONS_PRICES_CLASS = "_2GUaVkNp";

    private WebElement getPickUpCardParent(){
        return getDriver().findElement(By.id(PICK_UP_CARD_ID));
    }

    private WebElement getDropOffCardParent(){
        return getDriver().findElement(By.id(DROP_OFF_CARD_ID));
    }

    private WebElement getRequestDeliveryBtnParent(){
        return getDriver().findElement(By.className(REQUEST_DELIVERY_PARENT_CLASS));
    }

    private WebElement getLastAciveJobParent(){
        return getDriver().findElement(By.className(LAST_ACTIVE_JOB_CARD_CLASS));
    }

    private WebElement getTrasportationCardParent(){
        return getDriver().findElement(By.id(TRANSPORTATION_CARD_PARENT_ID));
    }

    public String getPickUpCardTitle() {
        waitForIdToBeVisible(PICK_UP_CARD_ID);
        WebElement pickUpCard = getPickUpCardParent().findElement(By.id(PICK_UP_CARD_ID));
        return pickUpCard.getText();
    }

    private void waitForIdToBeVisible(String id){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    private void waitForClassToBeVisible(String className){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    private void waitForElementToByClickableByLocator(String locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
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
        waitForElementToByClickableByLocator(REQUEST_DELIVERY_BTN_ID);
        WebElement requestDeliveryBtn = getRequestDeliveryBtnParent().findElement(By.id(REQUEST_DELIVERY_BTN_ID));
        requestDeliveryBtn.click();
    }

    public String getLastActiveJobAddresses() {
        waitForClassToBeVisible(IN_PROGRESS_PAGE_PARENT_CLASS);
        WebElement activeJob = getLastAciveJobParent();
        return activeJob.getText();
    }

    public boolean getBikeTransportType() {
        waitForClassToBeVisible(TRANSPORTATION_TYPE_BIKE);
        WebElement bike = getLastAciveJobParent().findElement(By.className(TRANSPORTATION_TYPE_BIKE));
        return bike.isDisplayed();
    }

    public int getTransportPrices() {
        waitForClassToBeVisible(TRANSPORTATIONS_PRICES_CLASS);
        List<WebElement> vehiclesPrices = getTrasportationCardParent().findElements(By.className(TRANSPORTATIONS_PRICES_CLASS));
        return vehiclesPrices.size();
    }
}
