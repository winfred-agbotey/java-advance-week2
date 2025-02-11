package com.mawulidev.behavioral.observer.example1;

public class DisplayObserver implements Observer {
    private final String name;

    public DisplayObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(name + " - Weather Update: Temp=" + temperature + ", Humidity=" + humidity + ", Pressure=" + pressure);
    }
}
