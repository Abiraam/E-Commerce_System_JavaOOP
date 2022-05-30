// Author: Abiraam Nagarajan
// Filename: Customers.java
// Specification: Method for Customers read/write; Updating customer files if modifications are put forth
// For: CS 2365 Object Oriented Programming Section 002

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Customers {

    /** Method to read the customers text document and return a list of the customers
     * */
    public static List<String> getCustomerList(){

        BufferedReader br = null;
        List<String> customersList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("customers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {

            //read the data and add to list
            String customer = null;
            if (br != null) {
                customer = br.readLine();
                while (customer != null) {
                    customersList.add(customer);
                    customer = br.readLine();

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


        return customersList;

    }

    /** Updates the customers document file after modifying the items in the list
     * */
    static void updateCustomer(){
        StringBuilder sb = new StringBuilder();
        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\Ecommerce System\\customers.txt");
      /*  for (int i = 0; i < getCustomerList().size(); i++) {
            sb.append(getCustomerList().get(i));
        }*/
        for (String str: getCustomerList()) {
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
