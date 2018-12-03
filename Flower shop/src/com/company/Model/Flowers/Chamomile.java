package com.company.Model.Flowers;

public class Chamomile extends Flower {

    public Chamomile() {
        super.setColor("Yellow");
        super.setLenght("15");
        super.setOdor("Sharp");
        super.setCountry("Ukraine");
        super.setPrice(20);
    }

    @Override
    public String toString() {
        return "Chamomile { " + super.toString() + " } ";
    }

    @Override
    public void attribute(){
        System.out.println("Chamomile - the presence of spikes");
    }

    public static void defineClassName(){
        Flower.addFlowerName(Chamomile.class.getSimpleName());
    }
}
