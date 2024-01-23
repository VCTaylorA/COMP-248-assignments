// ------------------------------------------------------- 
// Assignment 1 Algorithm 2: Simple Travel-Time Computer
// Written by: J Taylor A ID: 40275281 
// For COMP 248 Section P – Fall 2023 
// --------------------------------------------------------
//our goal with this program is to take our given variable (speed), and user input (distance) to calculate time of travel
// from earth to a given planet a certain distance away.
//attempts were made to declare variables appropriately to make code as legible as possible.
import java.util.Scanner;

public class A1_Q2 {
    public static void main(String[] args) {
        System.out.println("welcome user!");
        //create scanner object
        Scanner scanner = new Scanner(System.in);

        //constants
        double milesPerKilometer = 0.621371;
        int spaceshipSpeedMph = 28000;
        int hoursPerDay = 24;

        System.out.println("Project-S Simple Travel-Time Computer:");
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        //take input value from user
        System.out.print("Please enter the distance (in km) between the Earth and the extraterrestrial body: ");
        double distanceKm = scanner.nextDouble();
        //we close the scanner to save resources.
        scanner.close();
        //convert km to miles
        double distanceMiles = distanceKm * milesPerKilometer;

        //calculate time in hours
        double timeHours = distanceMiles / spaceshipSpeedMph;

        //calculate time in days (rounded down)
        int timeDays = (int) (timeHours / hoursPerDay);
        //format function helps to "insert" a variable into a string
        String answerLine = String.format("Project-S spaceship, constantly traveling at 28000mi/h, will take approximately %d 'Earth-based days' to get to its foreknown extraterrestrial destination.", timeDays);
        //print out our last lines
        System.out.println(answerLine);
        System.out.println(" ");
        System.out.println("Thank you for your contribution to Project-S.");
        System.out.println("End of program.");
    }
}