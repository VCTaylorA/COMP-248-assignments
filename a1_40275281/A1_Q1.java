// ------------------------------------------------------- 
// Assignment 1 Algorithm 1: Simple Cipher Program
// Written by: J Taylor A ID: 40275281 
// For COMP 248 Section P – Fall 2023 
// --------------------------------------------------------
//the goal of this program is to collect 6 sets of x and y inputs from the user
//and calculate the output, z, and format our input prompts and outputs in an easy, intuitive manner.
//
import java.util.Scanner;

public class A1_Q1 {
    public static void main(String[] args) {
        System.out.print("Welcome, user of the program!");
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // asks the user to enter all values of x and y,
        //without the use of a loop
        //and stores each variable as a double
        System.out.println("Enter the value of x_1: ");
        double x_1 = scanner.nextDouble();

        System.out.print("Enter the value of y_1: ");
        double y_1 = scanner.nextDouble();

        System.out.print("Enter the value of x_2: ");
        double x_2 = scanner.nextDouble();

        System.out.print("Enter the value of y_2: ");
        double y_2 = scanner.nextDouble();

        System.out.print("Enter the value of x_3: ");
        double x_3 = scanner.nextDouble();

        System.out.print("Enter the value of y_3: ");
        double y_3 = scanner.nextDouble();

        System.out.print("Enter the value of x_4: ");
        double x_4 = scanner.nextDouble();

        System.out.print("Enter the value of y_4: ");
        double y_4 = scanner.nextDouble();

        System.out.print("Enter the value of x_5: ");
        double x_5 = scanner.nextDouble();

        System.out.print("Enter the value of y_5: ");
        double y_5 = scanner.nextDouble();

        System.out.print("Enter the value of x_6: ");
        double x_6 = scanner.nextDouble();

        System.out.print("Enter the value of y_6: ");
        double y_6 = scanner.nextDouble();

        // Close the scanner for saving resources
        scanner.close();
        //Calculate z=(x/y)+(x%y), for each set of inputs, then round z DOWN to nearest integer
        double z_1 = (x_1 / y_1) + (x_1 % y_1);
        int roundedz_1 = (int) Math.floor(z_1);

        double z_2 = (x_2 / y_2) + (x_2 % y_2);
        int roundedz_2 = (int) Math.floor(z_2);

        double z_3 = (x_3 / y_3) + (x_3 % y_3);
        int roundedz_3 = (int) Math.floor(z_3);

        double z_4 = (x_4 / y_4) + (x_4 % y_4);
        int roundedz_4 = (int) Math.floor(z_4);

        double z_5 = (x_5 / y_5) + (x_5 % y_5);
        int roundedz_5 = (int) Math.floor(z_5);

        double z_6 = (x_6 / y_6) + (x_6 % y_6);
        int roundedz_6 = (int) Math.floor(z_6);

        // Print the final screen
        System.out.println("Project-S Access System: 6-Piece Puzzle Authentication Challenge:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Format the third line using our inputs x, y with @ between them
        String Thirdline = String.format(" %d @ %d  %d @ %d  %d @ %d  %d @ %d  %d @ %d  %d @ %d",
                (int)x_1, (int)y_1, (int)x_2, (int)y_2, (int)x_3, (int)y_3,
                (int)x_4, (int)y_4, (int)x_5, (int)y_5, (int)x_6, (int)y_6);

        //print the third line
        System.out.println(Thirdline);
        //make the fourthline the same as thirdline, except replace all chars except @ with space, and @ with "|"
        String Fourthline = Thirdline.replaceAll("[^@]", " ").replaceAll("@", "|");
        //print fourth line
        System.out.println(Fourthline);
        //make the fifthlineinit the same as fourthline, but replace all "|" with %d
        String Fifthlineinit = Fourthline.replaceAll("\\|", "%d");
        //we can format all characters %d to be replaced with our rounded down z values
        String Fifthlinefinal = String.format(Fifthlineinit, roundedz_1, roundedz_2, roundedz_3, roundedz_4, roundedz_5, roundedz_6);
        //print our last 2 lines
        System.out.println(Fifthlinefinal);
        System.out.println("At Project-S, we employ multi-factor authentication because one password is never enough.");
		System.out.println("end of program");
    }
}