package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

public class RackArrayImpl implements Rack {

    private int size;
    private Device[] devices;

    RackArrayImpl(int size) {

        if (size > 0) {
            this.size = size;
            devices = new Device[size];
        } else {
            System.err.println("Size value less than zero.");
            devices = new Device[0];
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreeSize() {

        int counter = 0;

        for (int i = 0; i < size; i++) {
            if (devices[i] != null) {
                counter++;
            }
        }

        return counter;
    }

    @Override
    public Device getDevAtSlot(int index) {

        if (chekIndex(index)) {
            return null;
        }

        return devices[index];
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {

        if (chekIndex(index)) {
            return false;
        }

        if (devices[index] != null) {
            System.err.println("Add in Rock was failed. Rack is not empty");
            return false;
        }

        if (device.getIn() <= 0) {
            System.err.println("Add in Rack was failed. (IN) is less or equals 0");
            return false;
        }

        devices[index] = device;
        return true;
    }

    @Override
    public Device removeDevFromSlot(int index) {

        if (chekIndex(index)) {
            return null;
        }

        if (devices[index] == null) {
            return null;
        }

        Device temp = devices[index];
        devices[index] = null;
        return temp;
    }

    @Override
    public Device getDevByIN(int in) {

        for (Device device : devices) {
            if (device.getIn() == in)
                return device;
        }

        return null;
    }

    private Boolean chekIndex(int index) {

        if (index > devices.length - 1) {
            System.err.println("Index " + index + " out of bounds for length " + devices.length);
            return true;
        }

        if (index < 0) {
            System.err.println("The new Index cannot be negative");
            return true;
        }

        return false;
    }

}
