package com.stuartExercises.Features;

import com.stuartExercises.DeliveryRequest.DeliveryRequest;
import com.stuartExercises.Login.Login;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RequestDeliveryTest {

    private Login logIn = new Login();
    private DeliveryRequest deliveryRequest = new DeliveryRequest();

    @Test
    public void userIsAbleToRequestAnInmediateDelivery(){
        //We log in
        logIn.userLogsIn();
        //We add the pick up and drop off addresses and the type of transport
        deliveryRequest.userFillsPickUpField();
        deliveryRequest.userFillsDestinationField();
        deliveryRequest.userRequestsDelivery();
        //We check we are inn the "In Progress" tab, and that the data of the delivery is correct
        assertThat(deliveryRequest.getLastActiveJobAddresses(), containsString("Avinguda Diagonal 5"));
        assertThat(deliveryRequest.getLastActiveJobAddresses(), containsString("Avinguda Diagonal 64"));
        assertThat(deliveryRequest.getBikeTransportType(), is(true));
        logIn.closePage();
    }

    @Test
    public void userIsAbleToSeePricesAfterAddingPickUpAndDropOffAddresses(){
        //We log in
        logIn.userLogsIn();
        //We add the pick up and drop off addresses
        deliveryRequest.userFillsPickUpField();
        deliveryRequest.userFillsDestinationField();
        //We check that the prices for all 4 transport types are available for the user
        assertEquals(deliveryRequest.getTransportPrices(), 4);
        logIn.closePage();
    }

}
