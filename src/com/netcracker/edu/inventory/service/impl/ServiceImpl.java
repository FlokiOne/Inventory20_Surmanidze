package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.Service;

public class ServiceImpl implements Service {

    @Override
    public void sortByIN(Device[] devices) {

        for (int i = 0; i < devices.length; i++) {

            for (int j = 0; j < devices.length; j++) {

                if (devices[j + 1] != null) {

                    if (devices[j] == null) {
                        swipePosition(devices, j, j + 1);
                    }

                    if (devices[j].getIn() == 0 && devices[j + 1].getIn() != 0) {
                        swipePosition(devices, j, j + 1);
                    }

                    if (devices[j].getIn() > devices[j + 1].getIn() && devices[j + 1].getIn() != 0) {
                        swipePosition(devices, j, j + 1);
                    }

                }
            }
        }
    }

    @Override
    public void filtrateByType(Device[] devices, String type) {

        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null && !devices[i].getType().equals(type)) {
                devices[i] = null;
            }
        }

    }

    private Device[] swipePosition(Device[] devices, int first, int second) {

        Device temp = devices[first];
        devices[first] = devices[second];
        devices[second] = temp;

        return devices;
    }

}
