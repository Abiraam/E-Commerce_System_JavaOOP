// Author: Abiraam Nagarajan
// Filename: Carts.java
// Specification: Method to read the carts text document and return a list of the cart items; Updates / modifications to the list of items in the cart

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Carts {

    /** Carts method to read and return list of items
     * */
    public static List<String> getCartsList(){
        BufferedReader br = null;
        List<String> cartsList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("carts.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {

            //read the data and add to list
            String item = null;
            if (br != null) {
                item = br.readLine();
                while (item != null) {
                    cartsList.add(item);
                    item = br.readLine();

                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return cartsList;
    }

    /** Updates the carts list file after modifying the items in the list
     * */
    static void updateCarts(){
        StringBuilder sb = new StringBuilder();
        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\Ecommerce System\\carts.txt");
        for (String str: getCartsList()) {
            String s = str + "\n";
            sb.append(s);

        }

        try {
            Files.writeString(filePath, sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Updates the carts list file after modifying the items in the list
     * */
    static void DeleteCarts(String rewardNumber){
        StringBuilder sb = new StringBuilder();
        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\Ecommerce System\\carts.txt");
        try {
            int index = getCartsList().indexOf(rewardNumber);
            getCartsList().remove(index-1);
            getCartsList().remove(index);
            getCartsList().remove(index+1);
            getCartsList().remove(index+2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String str: getCartsList()) {
            String s = str + "\n";
            sb.append(s);

        }

        try {
            Files.writeString(filePath, sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
