//-------------------------------------------------------
//Assignment 3
//Written by: J Taylor A, 40275281
//For COMP 248 Section P - Fall 2023
//-------------------------------------------------------
//the goal of this program is to offer the user the choice between addition and subtraction.
//after this choice, they are expected to put in their numbers. the first of these numbers should be the total amount of numbers in the calculation
//it proceeds to display the result of the calculation
//the user is then asked if they'd like to continue with another calculation.
// this process is repeated until the user indicates they are done.
// the program greets the user at its beginning and end.


import java.util.Scanner;
public class A3_Q1 {
    public static void main(String[] args) {
        System.out.println("Welcome to this calculator, offering Addition and Subtraction."); //welcome message and create scanner
        Scanner sc = new Scanner(System.in);
        while(true){ //this loop continues to offer addition and subtraction
            //the loop ends once a condition is met

            System.out.print("Please select 1 for Addition or 2 for Subtraction: ");
            int add_sub = sc.nextInt();
            if(add_sub == 1){
                //if the user wants addition...
                System.out.print("please input your numbers: ");
                sc.nextLine(); // this  "uses up" the 1 or 2 we just called
                String user_nums = sc.nextLine();
                String[] num_list = user_nums.split(" "); //we seperate users numbers by whitespaces, and add them to an array num_list
                double sum = 0;

                for(int i = 1; i< num_list.length; i++){//start init at 1 so we skip the first number
                    double num_in_array = Double.parseDouble(num_list[i]); //treat our string num_in_array as a double
                    sum += num_in_array;
                }
                System.out.println("The result of your addition is: "+sum);

            }else if(add_sub==2){ //the user chooses to subtract
                System.out.print("please input your numbers: ");
                sc.nextLine();
                String user_nums = sc.nextLine();
                String[] num_list = user_nums.split(" ");//establish an array where the numbers are determined by spaces

                double sum = Double.parseDouble(num_list[1]); // starting sum should be the minuend (2nd user number, index 1 in num_list)
                for(int i = 2; i< num_list.length; i++){ //init i is 2, we want to skip the length number and minuend
                    double num_in_array = Double.parseDouble(num_list[i]);
                    sum -= num_in_array;
                }System.out.println("The result of your subtraction is: "+sum);

            }
            System.out.print("do you want to perform another operation? y/yes: ");
            String yes_no = sc.nextLine();
            if(yes_no.toLowerCase().contains("y")){ //if the users response contains a y or Y, we assume they mean theyd like to continue the loop
                continue;
            }else{
                break; //if they put anything else, we assume they are done calculating
            }
        }
        System.out.println("Goodbye!");
    }
}