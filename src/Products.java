// Author: Abiraam Nagarajan
// Filename: Products.java
// Specification: Method to read products.txt doc and return a list of products and its info; Modifying / Updating the products list

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Products {

    /** Method to read the products text document and return a list of the products
     * */
    public static List<String> getProductsList(){
        BufferedReader br = null;
        List<String> productsList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("products.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {

            //read the data and add to list
            String item = null;
            if (br != null) {
                item = br.readLine();
                while (item != null) {
                    productsList.add(item);
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


        return productsList;
    }

    /** Returns the product number and the price of the product
     * */
    static String searchProduct(String productNumber){
        String productDetails;
        int index = getProductsList().indexOf(productNumber);
        productDetails = getProductsList().get(index) + " " + getProductsList().get(index + 2);
        return productDetails;
    }

    /** Updates the products document file after modifying the items in the list
     * */
    static void updateProducts(){
        StringBuilder sb = new StringBuilder();
        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\Ecommerce System\\products.txt");
        for (String str: getProductsList()) {
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
