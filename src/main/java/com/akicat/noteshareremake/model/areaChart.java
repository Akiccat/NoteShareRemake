package com.akicat.noteshareremake.model;

public class areaChart {
    private String name;
    private int value;

    public areaChart() {
    }

    public areaChart(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
