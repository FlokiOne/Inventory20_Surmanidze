package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Date;

public abstract class AbstractDevice implements Device {

    protected int in;
    protected String type;
    protected String manufacturer;
    protected String model;
    protected Date productionDate;

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {

        if (in <= 0) {
            System.err.println("The new value IN cannot be negative or equal to 0");
            return;
        }

        if (this.in == 0) {
            System.err.println("You can change IN only if the current IN is 0");
            return;
        }

        this.in = in;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
