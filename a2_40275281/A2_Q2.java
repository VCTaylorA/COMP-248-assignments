// -------------------------------------------------------
// Assignment 2 Question 1:
// Written by: J Taylor A 40275281
// For COMP 248 Section P – Fall 2023
// --------------------------------------------------------
// The goal of this program is to accept a users input of their grade (out of 100)
//and to return a corresponding letter grade
//the program must also account for user error. this program allows for 1 mistake input, informing the user
//of the fault with the number entered.
//after 2 failed attempts, the program says its farewells to the user and terminates
import java.util.Scanner;

public class A2_Q2 {
    public static void main(String[] args) {
        System.out.println("-------****-------****-------****-------****-----****-----"); //kindly welcome the user
        System.out.println("Welcome to Grade Calculator");
        System.out.println("-------****-------****-------****-------****-----****-----");
        System.out.println(); //spacing is hard to distinguish in the rubric pdf, but it looks like an extra whitespace line is necessary.
        Scanner sc = new Scanner(System.in); //set up the scanner
        char letterGrade = ' '; //initialize  lettergrade and percentgrade variables

        System.out.print("Enter the student's score (out of 100): ");
        int percentGrade = sc.nextInt();

        if (percentGrade >= 0 && percentGrade <= 100) { // catches faulty inputs
            switch (percentGrade / 10) {//thankfully division of an integer rounds down. we can just divide by 10 and use that as our case.
                case 10:
                case 9://assign lettergrades according to calculated case
                    letterGrade = 'A';
                    break;
                case 8:
                    letterGrade = 'B';
                    break;
                case 7:
                    letterGrade = 'C';
                    break;
                case 6:
                    letterGrade = 'D';
                    break;
                case 5:
                case 4:
                case 3:
                case 2:
                case 1:
                case 0:
                    letterGrade = 'F';
                    break;
            }

            System.out.println("Letter Grade: " + letterGrade); //if we use proper inputs, we can give an output.
        } else { // if proper inputs are not used we have to inform the user, then start the process again
            System.out.println("The score has to be between 0 and 100. Please try again.");
            percentGrade = sc.nextInt();
            sc.close();//save resources by ensuring the scanner closes at our last input
            if (percentGrade >= 0 && percentGrade <= 100) {
                switch (percentGrade / 10) {
                    case 10:
                    case 9:
                        letterGrade = 'A';
                        break;
                    case 8:
                        letterGrade = 'B';
                        break;
                    case 7:
                        letterGrade = 'C';
                        break;
                    case 6:
                        letterGrade = 'D';
                        break;
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                    case 1:
                    case 0:
                        letterGrade = 'F';
                        break;
                }

                System.out.println("The student's grade is: " + letterGrade);
            } else {
                System.out.println("It is still an invalid input. Bye!");//after the second time the user enters an invalid input, the program gives up with exit code 1
                System.exit(1);
            }
        }
    }
}