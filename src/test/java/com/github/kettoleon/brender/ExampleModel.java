package com.github.kettoleon.brender;

import com.github.kettoleon.brender.model.Address;
import com.github.kettoleon.brender.model.CommunicationBody;
import com.github.kettoleon.brender.model.Product;

public class ExampleModel {

    public static CommunicationBody communicationBody() {
        CommunicationBody communicationBody = new CommunicationBody();

        communicationBody.setAddress(new Address());
        communicationBody.getAddress().setStreet("streetName");
        communicationBody.getAddress().setTown("townName");
        communicationBody.getTriggeringProducts().add(new Product("product1", 4.50));
        communicationBody.getTriggeringProducts().add(new Product("product2", 0.51));
        communicationBody.getTriggeringProducts().add(new Product("product3", 3244.545567));

        return communicationBody;
    }
}
