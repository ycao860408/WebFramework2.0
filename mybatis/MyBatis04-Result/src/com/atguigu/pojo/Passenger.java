package com.atguigu.pojo;

public class Passenger {
    private Integer id;
    private String name;
    private Integer busId;
    //private Bus bus;
    public Passenger() {
    }

    public Passenger(Integer id, String name, Integer busId) {
        this.id = id;
        this.name = name;
        //this.bus = bus;
        this.busId = busId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    /*public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }*/
}
