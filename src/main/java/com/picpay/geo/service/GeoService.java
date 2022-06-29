package com.picpay.geo.service;

import com.picpay.geo.integration.TecbanClient;

public class GeoService {

    private final TecbanClient tecbanClient;

    public GeoService() {
        this.tecbanClient = new TecbanClient();
    }

    public String getAll(String lat, String lon) {
        try {
            return this.tecbanClient.getAll(lat, lon);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "";
    }

    public String find(int id) {
        try {
            return this.tecbanClient.find(id);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "";
    }
}
