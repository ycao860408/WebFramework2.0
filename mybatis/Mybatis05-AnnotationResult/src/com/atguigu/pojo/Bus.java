package com.atguigu.pojo;

import java.util.List;

public class Bus {
    private Integer id;
    private String name;
    private List<Passenger> passengers;

    public Bus() {
    }

    public Bus(Integer id, String name, List<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.passengers = passengers;
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
