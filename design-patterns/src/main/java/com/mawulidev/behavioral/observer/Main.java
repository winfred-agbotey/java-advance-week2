package com.mawulidev.behavioral.observer;

import com.mawulidev.behavioral.observer.example1.DisplayObserver;
import com.mawulidev.behavioral.observer.example1.Observer;
import com.mawulidev.behavioral.observer.example1.WeatherStation;
import com.mawulidev.behavioral.observer.example2.Investor;
import com.mawulidev.behavioral.observer.example2.StockMarket;
import com.mawulidev.behavioral.observer.example2.StockObserver;

public class Main {
    public static void main(String[] args) {
    //Example 1
        WeatherStation station = new WeatherStation();

        Observer display1 = new DisplayObserver("Display 1");
        Observer display2 = new DisplayObserver("Display 2");

        station.registerObserver(display1);
        station.registerObserver(display2);

        station.setWeatherData(30.0f, 65.0f, 1013.1f);
        station.setWeatherData(28.5f, 70.0f, 1012.5f);


        //Example 2
        StockMarket stockMarket = new StockMarket();

        StockObserver investor1 = new Investor("Alice");
        StockObserver investor2 = new Investor("Bob");

        stockMarket.registerObserver("AAPL", investor1);
        stockMarket.registerObserver("AAPL", investor2);
        stockMarket.registerObserver("GOOGL", investor1);

        stockMarket.updateStockPrice("AAPL", 150.0);
        stockMarket.updateStockPrice("GOOGL", 2800.0);
    }
}
