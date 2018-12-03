package com.company.View;

import com.company.Model.Flowers.Bouquet;

import java.text.NumberFormat;
import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Bouquet> bouquets;
    private int itemsCount;
    private double totalPrice;

    public ShoppingCart(){
        this.bouquets = new ArrayList<>();
    }

    public void addToCart(Bouquet bouquet)
    {
        bouquets.add(bouquet);
        totalPrice += bouquet.getPrice();
        itemsCount++;
    }

    // -------------------------------------------------------
    //  Returns the contents of the cart together with
    //  summary information.
    // -------------------------------------------------------
    @Override
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String contents = "\nShopping Cart : \n";

        if(bouquets!=null)
        for(Bouquet obj : bouquets){
            contents += BouquetMenu.getBouquet(obj);
        }
        else return "Shopping cart is empty";

        contents += "\n\nTotal Price: " + fmt.format(totalPrice);

        return contents;
    }
}