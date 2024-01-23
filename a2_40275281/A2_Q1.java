// ------------------------------------------------------- 
// Assignment 2 Question 1:
// Written by: J Taylor A 40275281
// For COMP 248 Section P – Fall 2023
// --------------------------------------------------------
//the purpose of this program is to create a simple BMI calculator
//that accepts input from the user, and informs them of how they are categorized
//while also providing general health tips if and only if requested.
import java.util.Scanner;

public class A2_Q1 {
    public static void main(String[] args) {
        // Print our welcome message
        System.out.println("-------****-------****-------****-------****-----****-----");
        System.out.println("Welcome to BMI Calculator");
        System.out.println("-------****-------****-------****-------****-----****-----");
        System.out.println();
        // Ask for user inputs and store them in appropriate variables
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight (in kilograms): ");
        float weight = sc.nextFloat();
        System.out.print("Enter height (in meters): ");
        float height = sc.nextFloat();
        // Calculate BMI
        float BMI = weight / (height * height);
        System.out.printf("BMI: %.2f\n", BMI);

        // Classify patient category based on BMI
		//       but let us declare our variables outside of our if statements first
        String category;
        String tips;
        if (BMI < 18.5) {
            category = "Underweight";
            tips = "Please eat well and do more exercises.";
        } else if (BMI <= 24.9) {
            category = "Normal weight";
            tips = "Congratulations, you are doing fairly well. Keep on going.";
        } else if (BMI <= 29.9) {
            category = "Overweight";
            tips = "Please watch out what you eat and do more exercises!";
        } else {
            category = "Obesity";
            tips = "Please contact our experts for professional help.";
        }

        System.out.println("Category: " + category);
        System.out.print("Do you want some tips according to your BMI?");
		//convert to lowercase to accomodate more inputs
        String yesno = sc.next().toLowerCase();
        //print out tips if requested by user, otherwise say goodbye
        if (yesno.equals("y") || yesno.equals("yes")) {
            System.out.println(tips);
        } else {
            System.out.println("Nice to meet you too. Bye!");
        }
    }
}
