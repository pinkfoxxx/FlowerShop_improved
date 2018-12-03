package com.company.Model.Flowers;

import java.util.ArrayList;
import java.util.Objects;

public class Flower {

    private String color;
    private String lenght;
    private String odor;
    private String country;
    private double price;

    private static ArrayList<String> flowersNames = new ArrayList();

    public Flower() {}

    public Flower(String color, String lenght, String odor, String country, double price) {
        this.color = color;
        this.lenght = lenght;
        this.odor = odor;
        this.country = country;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getOdor() {
        return odor;
    }

    public void setOdor(String odor) {
        this.odor = odor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void addFlowerName(String name){
        flowersNames.add(name);
    }

    public static ArrayList<String> getFlowersNames() {
        return flowersNames;
    }

    @Override
    public String toString() {
        return
                "color='" + color + '\'' +
                ", lenght='" + lenght + "cm" + '\'' +
                ", odor='" + odor + '\'' +
                ", country='" + country + '\'' +
                ", price='" + price + "grn" + '\'' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.price, price) == 0 &&
                Objects.equals(color, flower.color) &&
                Objects.equals(lenght, flower.lenght) &&
                Objects.equals(odor, flower.odor) &&
                Objects.equals(country, flower.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, lenght, odor, country, price);
    }

    public void attribute(){
        System.out.println("Simple Flower");
    }

    public static void defineClassName(){};
}
