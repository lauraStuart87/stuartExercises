package com.stuartExercises.Login;

import com.stuartExercises.DeliveryRequest.DeliveryRequest;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class LoginInTest {

    private Login logIn = new Login();
    private DeliveryRequest deliveryRequest = new DeliveryRequest();

    @Test
    public void userIsAbleToLogIn(){
        logIn.userLogsIn();
        assertThat(deliveryRequest.getPickUpCardTitle(), containsString("Recogida"));
    }
}
