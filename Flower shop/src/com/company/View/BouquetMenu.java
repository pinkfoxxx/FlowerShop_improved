package com.company.View;

import com.company.Model.Flowers.Bouquet;
import com.company.Model.Flowers.Flower;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class BouquetMenu {

    public static void print(Bouquet bouquet) {
        double price = bouquet.getPrice();
        ArrayList<Flower> flowers = bouquet.getFlowers();

        //Put elements of list in Map and count them
        //Key - flower, value - count of this flower
        //https://stackoverflow.com/questions/505928/
        Map<Flower, Long> flowerMap = flowers.stream().collect(
                Collectors.groupingBy(e -> e, Collectors.counting()));

        if(bouquet.getName().equals(""))System.out.println("\n Your Bouquet : ");
        else System.out.println("\n" + bouquet.getName() + " : ");
        for (Map.Entry<Flower, Long> item : flowerMap.entrySet()) {
            Flower flower = item.getKey();
            System.out.println(flower + " Count : " + item.getValue() + "; Total Price : " + flower.getPrice()*item.getValue());
        }
        System.out.println("Bouquet price : " + price + "grn");
    }


    public static String getBouquet(Bouquet bouquet) {

        ArrayList<Flower> flowers = bouquet.getFlowers();
        String result = "";

        //Put elements of list in Map and count them
        //Key - flower, value - count of this flower
        //https://stackoverflow.com/questions/505928/
        Map<Flower, Long> flowerMap = flowers.stream().collect(
                Collectors.groupingBy(e -> e, Collectors.counting()));

        if(bouquet.getName().equals(""))result+=("\n Your Bouquet " + " (" +bouquet.getPrice() + ") : ");
        else result+=("\n\n" + bouquet.getName() + " (" +bouquet.getPrice() + ") : ");
        for (Map.Entry<Flower, Long> item : flowerMap.entrySet()) {
            Flower flower = item.getKey();
            result += "\n" + flower + " Count : " + item.getValue() + "; Price : " + flower.getPrice()*item.getValue();
        }
        return result;
    }
}
