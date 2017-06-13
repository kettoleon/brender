package com.github.kettoleon.brender.model;

import java.util.ArrayList;
import java.util.List;

public class CommunicationBody {

    private Address address;

    private List<Product> triggeringProducts = new ArrayList<Product>();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getTriggeringProducts() {
        return triggeringProducts;
    }

    public void setTriggeringProducts(List<Product> triggeringProducts) {
        this.triggeringProducts = triggeringProducts;
    }
}
