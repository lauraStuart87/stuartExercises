package com.stuartExercises.Features;

import com.stuartExercises.DeliveryRequest.DeliveryRequest;
import com.stuartExercises.Login.Login;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class RequestDeliveryTest {

    private Login logIn = new Login();
    private DeliveryRequest deliveryRequest = new DeliveryRequest();

    @Test
    public void userIsAbleToRequestAnInmediateDeliveryByCar(){
        //We log in
        logIn.userLogsIn();
        //We add the pick up and drop off addresses and the type of transport
        deliveryRequest.userFillsPickUpField();
        deliveryRequest.userFillsDestinationField();
        deliveryRequest.userRequestsDelivery();
        //In the "In Progress" tab we check that the data of the delivery is correct
        assertThat(deliveryRequest.getLastActiveJobAddresses(), containsString("Avinguda Diagonal 5"));
        assertThat(deliveryRequest.getLastActiveJobAddresses(), containsString("Avinguda Diagonal 64"));
    }
}
