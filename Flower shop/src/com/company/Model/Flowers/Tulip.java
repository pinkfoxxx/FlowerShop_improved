package com.company.Model.Flowers;

public class Tulip extends Flower {

    public Tulip() {
        super.setColor("Pink");
        super.setLenght("25");
        super.setOdor("Gentle");
        super.setCountry("Netherlands");
        super.setPrice(100);
    }

    @Override
    public String toString() {
        return "Tulip { " + super.toString() + " }";
    }

    @Override
    public void attribute(){
        System.out.println("Tulip - the presence of spikes");
    }

    public static void defineClassName(){
       Flower.addFlowerName(Tulip.class.getSimpleName());
    }
}
