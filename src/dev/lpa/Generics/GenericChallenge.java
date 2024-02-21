package dev.lpa.Generics;

public class GenericChallenge {
    public static void main(String[] args) {
        Park[] usNationalParks = new Park[]{
                new Park("YellowStone", "44.4482,-110.5916"),
                new Park("Grand Canyon", "36.1085,-112.0965"),
                new Park("Yoemite", "37.8855,-119.5360"),
        };

        Layer<Park> parkLayer = new Layer<>(usNationalParks);
        parkLayer.renderLayer();

        River[] usRivers = new River[]{
                new River("Mississippi", "47.2160,-95.2348", "29.1566,-89.2495", "35.1556,-90.0659"),
                new River("Missouri", "45.9239,-111.4983", "38.8146,-90.1218", "43.0770,-98.6424"),
                new River("Columbia", "47.4515,-120.3162", "46.2167,-119.1047", "45.6076,-122.6405"),
        };
        Layer<River> riverLayer = new Layer<>(usRivers);
        riverLayer.renderLayer();
    }
}
