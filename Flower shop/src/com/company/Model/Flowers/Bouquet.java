package com.company.Model.Flowers;

import java.util.ArrayList;

public class Bouquet {
    private String name;
    private ArrayList<Flower> flowers = new ArrayList();
    private double price;

    public Bouquet() {
        this.name = "";
        this.price = 0;
    }

    //Constructor for default bouquets
    public Bouquet(String name, String [] flowerNames, int count[]) {
        this.name = name;
        for (int i = 0; i<flowerNames.length; i++) {
            if(flowerNames[i].equals("Rosie"))addFlowers(new Rosie(), count[i]);
            if(flowerNames[i].equals("Chamomile")) addFlowers(new Chamomile(), count[i]);
            if(flowerNames[i].equals("Tulip"))addFlowers(new Tulip(), count[i]);
        }
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " { " +
                "Flowers : " + flowers +
                ", price=" + price + "grn" +
                '}';
    }

    public void addFlowers(Flower flower, int k){
        for (int i =0; i<k; i++) {
            flowers.add(flower);
            this.price =price + flower.getPrice();
        }
    }

}
