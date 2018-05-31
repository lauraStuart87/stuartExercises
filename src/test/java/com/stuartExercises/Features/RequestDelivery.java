package com.stuartExercises.Features;

import com.stuartExercises.DeliveryRequest.DeliveryRequest;
import com.stuartExercises.Login.Login;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class RequestDelivery {

    private Login logIn = new Login();
    private DeliveryRequest deliveryRequest = new DeliveryRequest();

    private void userLogsIn(){
        logIn.openPage();
        logIn.logInPage();
    }

    @Test
    public void userIsAbleToLogIn(){
        userLogsIn();
        assertThat(deliveryRequest.getPickUpCard(), containsString("Recogida"));
    }

    @Test
    public void userIsAbleToRequestAnInmediateDeliveryByCar(){
        userLogsIn();
        deliveryRequest.userFillsPickUpField();
        deliveryRequest.userFillsDestinationField();
        deliveryRequest.userSelectsCarAsVehicle();
        deliveryRequest.userRequestsDelivery();
        assertThat(deliveryRequest.getLastActiveJobAddresses(), containsString("Avinguda Diagonal 5"));
        assertThat(deliveryRequest.getLastActiveJobAddresses(), containsString("Carrer del mar 3"));
    }
}
