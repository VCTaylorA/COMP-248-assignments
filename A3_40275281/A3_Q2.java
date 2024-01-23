//-------------------------------------------------------
//Assignment 3
//Written by: J Taylor A, 40275281
//For COMP 248 Section P - Fall 2023
//-------------------------------------------------------
//the goal of this program is to keep track of skier times and adjust the ranking according to their completion time.
//the program takes as many inputs as the user would like, or 20. whichever comes first. this is done to save resources
import java.util.Scanner;

public class A3_Q2 {
    public static void main(String[] args) {
        //greet the user and set up the scanner object
        System.out.println("Welcome to Mont-Halloween Skiing Contest Ranker.");
        System.out.println("Whenever a skier makes it to the finish line, enter their name and skiing time.");
        Scanner sc = new Scanner(System.in);

        //set up our arrays and integers
        int max_size = 20;
        String[] names = new String[max_size];
        double[] times = new double[max_size];
        int skier_count = 0;

        //this while loop continues until the user says no, or when the skier count surpasses the array sizes
        while (skier_count < max_size) {
            // Gather skier's name and add to the array
            System.out.print("Please input the skier's name: ");
            String name = sc.nextLine();
            names[skier_count] = name;

            // Gather skier's time and add to the array
            System.out.print("Please input the skier's time: ");
            double time = sc.nextDouble();
            times[skier_count] = time;

            skier_count++;//keep track of number of skiers

            //first loop sets up the second loop to operate for every single element in the arrays
            //second loop takes a single element and compares it to every other element in the list, then repositions it if it is larger than a given number in an iteration
            for (int i = 0; i < skier_count - 1; i++) {
                for (int j = 0; j < skier_count - i - 1; j++) {
                    if (times[j] > times[j + 1]) {
                        // Swap times
                        double temp_time = times[j];
                        times[j] = times[j + 1];
                        times[j + 1] = temp_time;

                        // Swap names
                        String temp_name = names[j];
                        names[j] = names[j + 1];
                        names[j + 1] = temp_name;
                    }
                }
            }

            // Print podium rankings after each skier entry, depending on how many spots in the array are filled
            System.out.println("First podium goes to " + names[0] + " who made it in " + times[0] + " second(s)");
            if (skier_count >= 2) {
                System.out.println("Second podium goes to " + names[1] + " who made it in " + times[1] + " second(s)");
            }
            if (skier_count >= 3) {
                System.out.println("Third podium goes to " + names[2] + " who made it in " + times[2] + " second(s)");
            }
            //prompt user to continue or quit
            System.out.print("Do you want to add another skier? y/yes: ");
            String yes_no = sc.next();
            sc.nextLine(); //this prevents some input lines from printing improperly by consuming a string
            if (!yes_no.toLowerCase().contains("y")) {//if the user doesnt put anything with y, we assume they want to end the program
                break;//exit the while loop
            }

        }System.out.println("Goodbye!"); //greet the user
    }
}
