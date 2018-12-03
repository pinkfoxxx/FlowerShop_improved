package com.company.Model.Flowers;

public class Rosie extends Flower {

    public Rosie() {
        super.setColor("Red");
        super.setLenght("30");
        super.setOdor("Dangerous");
        super.setCountry("Bulgaria");
        super.setPrice(120);
    }

    @Override
    public String toString() {
        return "Rosie { " + super.toString() + " }";
    }

    @Override
    public void attribute(){
        System.out.println("Rose - the presence of spikes");
    }

    public static void defineClassName(){
        Flower.addFlowerName(Rosie.class.getSimpleName());
    }
}
