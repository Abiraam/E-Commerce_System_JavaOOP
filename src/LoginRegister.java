// Author: Abiraam Nagarajan
// Filename: LoginRegister.java
// Specification: Validating new users and registering using their credentials, and generating and storing reward numbers
// For: CS 2365 Object Oriented Programming Section 002

import java.util.Random;
import java.util.Scanner;

public class LoginRegister {
    public LoginRegister() {}

    static Scanner sc = new Scanner(System.in);

    /** check if it is a new user and return boolean
     * */
    public static boolean IsNewUser(){
        Scanner sc = new Scanner(System.in);
        boolean isNewUser = false;
        System.out.println("Are you a new user (Y/N): ");
        String newUser = sc.next().toLowerCase();
        if (newUser.equalsIgnoreCase("y")){
            // Register user
            isNewUser = true;
        }else if (newUser.equalsIgnoreCase("n")){
            isNewUser = false;
        }else {
            System.out.println("Invalid input");
        }
        return isNewUser;
    }

    /** register the user by taking the following credentials
     *      first name
     *      last name
     *      email
     *      phone number
     * */
    public static String[] registerUser(){
        Random random = new Random();
        String reward, eStatus;

        do {
            reward = getReward();
            eStatus = (new Random().nextInt(2) == 1)?"Yes":"No";
        }while (Customers.getCustomerList().contains(reward));

        Scanner sc = new Scanner(System.in);
        String[] details = new String[6];
        String[] str = new String[4];
        System.out.println("Enter your details separated with \"','\" (e.g John, Williams, john@email.com, 806-123-4567): ");
        String s = sc.nextLine();
        str = s.split(",");
        details[0] = str[0]; //first name
        details[1] = str[1]; //second name
        details[2] = reward + " " + eStatus; //reward and elite status
        details[3] = String.valueOf(new Random().nextInt(1,10)/100); //discount
        details[4] = str[2]; //email
        details[5] = str[3]; //phone


        return details;
    }

    /** randomly generate a reward and give it to the user
     * */
    static String getReward(){
        // generate a random reward
        return "00" + new Random().nextInt(1000000);
    }

    /** login the user by taking last name and reward number
     * */
    public static String loginUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Last name and Reward number (e.g John, 012345): ");
        return sc.nextLine();

    }

}
