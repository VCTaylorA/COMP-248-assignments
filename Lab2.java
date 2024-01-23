import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the time (hours) you have been driving followed by the speed (km/h) you are driving: ");
        int t = sc.nextInt();
        double s = sc.nextDouble();
        sc.close(); // Close the scanner when you're done with it

        String speed_template = "You have been driving for %d hours with a speed of %.2f km/h";
        String distance_template = "You have traveled %.2f km";

        double distance = t * s; // Calculate the distance traveled

        System.out.printf(speed_template, t, s);
        System.out.println(); // Print a newline for formatting
        System.out.printf(distance_template, distance);
    }
}
