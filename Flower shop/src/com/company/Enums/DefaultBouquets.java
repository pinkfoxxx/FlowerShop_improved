package com.company.Enums;

import com.company.Model.Flowers.Bouquet;

import static com.company.Model.Flowers.Flower.getFlowersNames;


public enum DefaultBouquets {

  BOUQUET1(new Bouquet("KissOfDeath", flowerNames(), new int[]{1,1,1})),
  BOUQUET2(new Bouquet("FirstDate", flowerNames(), new int[]{1,2,2})),
  BOUQUET3(new Bouquet("Aroma", flowerNames(), new int[]{1,3,2})),
  BOUQUET4(new Bouquet("FreeListener", flowerNames(), new int[]{1,4,2})),
  BOUQUET5(new Bouquet("YouAreEverything", flowerNames(),new int[]{1,0,1}));

  private final Bouquet bouquet ;

  DefaultBouquets(Bouquet bouquet) {
        this.bouquet = bouquet;
  }

  public static String [] flowerNames(){
      return getFlowersNames().toArray(new String[0]);
  }

  public Bouquet getBouquet() {
        return bouquet;
    }
}
