package com.stuartExercises.Features;

import com.stuartExercises.Login.Login;
import org.junit.Test;

public class RequestDelivery {

    private Login logIn = new Login();

    @Test
    public void requestAnInmediateDelivery(){
        logIn.openPage();
        logIn.logIn();
    }
}
