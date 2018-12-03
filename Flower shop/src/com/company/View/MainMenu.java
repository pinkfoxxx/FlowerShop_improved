package com.company.View;

import com.company.Model.Flowers.Chamomile;
import com.company.Model.Flowers.Rosie;
import com.company.Model.Flowers.Tulip;
import com.company.Model.Flowers.Bouquet;
import com.company.Enums.DefaultBouquets;
import com.company.Model.Payment.Order;
import com.company.Model.Payment.PayByCreditCard;
import com.company.Model.Payment.PayByPayPal;
import com.company.Model.Payment.PayStrategy;

import java.util.Scanner;

import static com.company.Enums.DefaultBouquets.*;

 public class MainMenu {

    private static ShoppingCart cart = new ShoppingCart();
    private static PayStrategy strategy;
    private static Order order = new Order();

    static {
        Rosie.defineClassName();
        Chamomile.defineClassName();
        Tulip.defineClassName();
    }

     public static void menu(){
         DefaultBouquets[] defaultBouquets = {BOUQUET1, BOUQUET2, BOUQUET3, BOUQUET4, BOUQUET5};

        Scanner scanner = new Scanner(System.in);
        String continueChoice = null;
        do {
            System.out.println("\nPlease, select option: "
                    + "\n1 - Select default bouquet"
                    + "\n2 - Make your own bouquet"
                    + "\n3 - Display shopping cart"
                    + "\n4 - Finish");

            String numberErrorMessage = "Please, write correct number";
            String mainOptions = conditionCheck(new String[]{"1","2","3"}, numberErrorMessage);

            switch (mainOptions) {
                case "1":
                    System.out.println("\nPlease, select what bouquet you want to buy: ");
                    String [] bouquetsNumbers = new String[defaultBouquets.length];
                    for (int i = 0; i < defaultBouquets.length; i++) {
                        BouquetMenu.print(defaultBouquets[i].getBouquet());
                        bouquetsNumbers[i]=String.valueOf(i+1);
                    }
                    int bouquetNumber = Integer.valueOf(conditionCheck(bouquetsNumbers, numberErrorMessage));
                    cart.addToCart(defaultBouquets[bouquetNumber-1].getBouquet());
                    order.addToCost(defaultBouquets[bouquetNumber-1].getBouquet().getPrice());

                    break;
                case "2":
                    Bouquet bouquet = new Bouquet();
                    boolean isReady = false;

                    while (!isReady) {
                        System.out.println("\nPlease, select type of flowers you want add to bouquet"
                                + "\n1 - Rosie"
                                + "\n2 - Chamomile"
                                + "\n3 - Tulip"
                                + "\n4 - Stop adding and make bouquet");

                        String bouquetOptions = conditionCheck(new String[]{
                                "1","2","3","4"}, numberErrorMessage);

                        switch (bouquetOptions) {
                            case "1":
                                bouquet.addFlowers(new Rosie(), flowersCount());
                                break;
                            case "2":
                                bouquet.addFlowers(new Chamomile(), flowersCount());
                                break;
                            case "3":
                                bouquet.addFlowers(new Tulip(), flowersCount());
                                break;
                            case "4":
                                isReady = true;
                                BouquetMenu.print(bouquet);
                                cart.addToCart(bouquet);
                                order.addToCost(bouquet.getPrice());
                                break;
                        }
                    }
                    break;
                case "3":
                    System.out.println(cart);
                    break;
                case "4":
                    continueChoice = "finish";
                    if(order.getTotalCost()==0)System.exit(0);
                    break;
            }

            if(continueChoice != null && continueChoice.equals("finish"))break;

            System.out.println("\nDo you wish to continue selecting products? Y/N: \n");
            String letterErrorMessage = "Please, write correct letter\n";
            continueChoice = conditionCheck(new String[]{"Y","N"},letterErrorMessage);

        } while (continueChoice.equalsIgnoreCase("Y"));

        if (strategy == null) {
            System.out.println("Please, select a payment method:" + "\n" +
                    "1 - PalPay" + "\n" +
                    "2 - Credit Card");

            String paymentMethod = scanner.next();

            // Client creates different strategies based on input from user,
            // application configuration, etc.
            if (paymentMethod.equals("1")) {
                strategy = new PayByPayPal();
            } else {
                strategy = new PayByCreditCard();
            }

            // com.company.Model.Payment.Order object delegates gathering payment data to strategy
            // object, since only strategies know what data they need to
            // process a payment.
            order.processOrder(strategy);

                // Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
        }
    }


    public static int flowersCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write number of flowers you want to add to bouquet");

        int count;
        try {
            count = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error, please try again! \nEnsure that you write integer number!\n");
            return flowersCount();
        }

        return count;
    }

    public static String conditionCheck(String [] values, String errorMessage) {
         Scanner scanner = new Scanner(System.in);
         boolean success = false;
         String choice;
         do {
             choice = scanner.next();
             for (String obj : values) {
                 success = choice.equalsIgnoreCase(obj);
                 if(success)break;
             }
             if(!success) System.out.println(errorMessage);
         } while (!success);
         return choice;
     }

}

