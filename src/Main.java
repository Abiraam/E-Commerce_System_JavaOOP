// Author: Abiraam Nagarajan
// Filename: Main.java

import java.util.List;
import java.util.Scanner;

public class Main {
    static String firstName, lastName, rewardNumber;

    public static void main(String[] args) {

        // Check if is new user Humphrey, Morara, humphreymorara@gmail.com, 254-708-241903
        if (LoginRegister.IsNewUser()){
            // register the user if the user is new
            String[] details = LoginRegister.registerUser();
            rewardNumber = details[2];
            for (String detail : details) {
                Customers.getCustomerList().add(detail);
            }
            Customers.updateCustomer();
            actions();

        }else {
            //Login the user by checking if the cridentials exist
            String[] details = LoginRegister.loginUser().split(",");
            lastName = details[0];
            rewardNumber = details[1];
            if (Customers.getCustomerList().contains(lastName) && Customers.getCustomerList().contains(rewardNumber)){
                actions();
            }else {
                System.out.println("Details not available");
            }


        }

    }

    /** Choose an action to perform, that might include;
     *      search a product
     *      add product to cart
     * */
    static void actions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose action (Search product: enter- sp, " +
                "put product to cart: enter- pc )" +
                "Delete product: enter- del" +
                "Display items in the carts: enter- dis");
        String input = sc.next();
        if (input.equalsIgnoreCase("sp")){
            //search for the product
            //System.out.println(Products.getProductsList());
            displayItems(Products.getProductsList());
            System.out.println("========================================");
            System.out.println("Enter product number: ");
            String pNumber = sc.next();
            if (Products.getProductsList().contains(pNumber)){
                System.out.println("========================================");
                System.out.println("Add to cart (Y/N): ");
                String add = sc.next();
                if (add.equalsIgnoreCase("y")){
                    Carts.getCartsList().add("1"); // add total number of carts
                    Carts.getCartsList().add(rewardNumber.substring(0,rewardNumber.indexOf(" "))); // add customer reward number
                    Carts.getCartsList().add("1"); // add number cart items
                    Carts.getCartsList().add(Products.searchProduct(pNumber)); // add product number and amount
                    Carts.updateCarts();
                    System.out.println("Product added to cart");

                }else if (add.equalsIgnoreCase("n")){
                    System.out.println("Product not added");

                }else {
                    System.out.println("Invalid input!");
                }

            }else {
                System.out.println("Invalid product number!");
                actions();
            }

        }else if (input.equalsIgnoreCase("pc")){
            // add product to cart
            System.out.println("Choose a product to add to cart");
            System.out.println("========================================");
            displayItems(Products.getProductsList());
            System.out.println("========================================");
            System.out.println("Enter product number: ");
            String pNumber = sc.next();
            Carts.getCartsList().add("1"); // add total number of carts
            Carts.getCartsList().add(rewardNumber.substring(0,rewardNumber.indexOf(" "))); // add customer reward number
            Carts.getCartsList().add("1"); // add number cart items
            Carts.getCartsList().add(Products.searchProduct(pNumber)); // add product number and amount
            Carts.updateCarts();
            System.out.println("Product added to cart");

        }else if (input.equalsIgnoreCase("del")){
            // add product to cart
            System.out.println("Choose a product to delete by entering the reward number");
            System.out.println("========================================");
            displayItems(Products.getProductsList());
            System.out.println("========================================");
            System.out.println("Enter reward number: ");
            String rNumber = sc.next();
            Carts.DeleteCarts(rNumber); // add product number and amount
            System.out.println("Product added to cart");

        }else if (input.equalsIgnoreCase("dis")){
            // add product to cart
            System.out.println("All the items in the cart");
            System.out.println("========================================");
            displayItems(Carts.getCartsList());

        }else {
            System.out.println("Invalid input");
            actions();
        }
    }

    static void displayItems(List<String> list){
        for (String str : list) {
            //sb.append(str);
            System.out.println(str);
        }
    }

}
