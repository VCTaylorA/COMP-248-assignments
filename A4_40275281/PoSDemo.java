// ---------------------------------------------------------
// Assignment 4
// Written by: J Taylor A 40275281
// For COMP 248 Section P – Fall 2023
// ---------------------------------------------------------









import java.util.Scanner;


public class PoSDemo {
    private static PoS[] posArray = new PoS[5];

    public static void main(String[] args) {
        // Creating PoS objects based on criteria...

        Sales sales1 = new Sales();
        sales1.add_sales(10, 20, 15, 5, 30, 25);
        posArray[0] = new PoS(sales1, new PrePaidCard[3]);

        Sales sales2 = new Sales();
        sales2.add_sales(10, 20, 15, 5, 30, 25);
        posArray[1] = new PoS(sales2, new PrePaidCard[3]);

        Sales sales3 = new Sales();
        sales3.add_sales(5, 15, 20, 25, 10, 25);
        posArray[2] = new PoS(sales3, new PrePaidCard[4]);

        Sales sales4 = new Sales();
        sales4.add_sales(5, 10, 20, 25, 30, 10);
        posArray[3] = new PoS(sales4);

        Sales sales5 = new Sales();
        sales5.add_sales(5, 10, 20, 25, 30, 10);
        posArray[4] = new PoS(sales5);

        displayMenu();
    }
    //create a loop that gives you menu options
    private static void displayMenu() {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("|Welcome to Concordia CostLessBites Catering Sales Counter Application          |");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        int choice;
        do {
            System.out.println("| What would you like to do?                                                    |");
            System.out.println("| 1 >> See the contents of all PoSs                                             |");
            System.out.println("| 2 >> See the Content of one PoS                                               |");
            System.out.println("| 3 >> List PoSs with the same $ amount of sales                                |");
            System.out.println("| 4 >> List PoSs with same number of Sales categories                           |");
            System.out.println("| 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards   |");
            System.out.println("| 6 >> Add a Prepaid Card to an existing PoS                                    |");
            System.out.println("| 7 >> Remove an existing prepaid card from a PoS                               |");
            System.out.println("| 8 >> Update the expiry date of an existing Prepaid card                       |");
            System.out.println("| 9 >> Add sales to a PoS                                                       |");
            System.out.println("| 0 >> To quit                                                                  |");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            System.out.print("Please enter your choice and press <Enter>: ");
           

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine(); 
                //the methods will be defined outside of the switch case for legibility purposes
            switch (choice) {
                case 1:
                    System.out.println(1);
                    displayAllPosContents();
                    break;
                case 2:
                    System.out.println(2);
                    displaySinglePosContent();
                    break;
                case 3:
                    System.out.println(3);
                    listPossWithSameSalesAmount();
                    break;
                case 4:
                    System.out.println(4);
                    listPossWithSameSalesCategories();
                    break;
                case 5:
                    System.out.println(5);
                    listPossWithSameSalesAndPrePaidCards();
                    break;
                case 6:
                    System.out.println(6);
                    addPrePaidCardToPos();
                    break;
                case 7:
                    System.out.println(7);
                    removePrePaidCardFromPos();
                    break;
                case 8:
                    System.out.println(8);
                    updatePrePaidCardExpiry();
                    break;
                case 9:
                    System.out.println(9);
                    addSalesToPos();
                    break;
                case 0:
                    System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
    }while (choice !=0);
    }
    //CASE 1
    
    private static void displayAllPosContents() {
        System.out.println("Contents of all PoSs:");
    
        for (int i = 0; i < posArray.length; i++) {
            // Check if the current PoS exists (not null)
            if (posArray[i] != null) { // If the PoS exists, display its contents using the toString() method
                System.out.println("PoS " + i + ":\n" + posArray[i].toString());
            } else {// If the PoS is null, display that it's null
                System.out.println("PoS " + i + " is null");
            }
        }
    }



    //CASE 2

     private static void displaySinglePosContent() {
         Scanner sc = new Scanner(System.in);
         System.out.print("Which PoS do you want to see the content of? (Enter number 0 to " + (posArray.length - 1) + "): ");
         int posIndex = sc.nextInt();
         sc.nextLine(); // Consume newline
    
         if (posIndex >= 0 && posIndex < posArray.length && posArray[posIndex] != null) {
             System.out.println("Content of PoS " + posIndex + ":\n" + posArray[posIndex].toString());
         } else {
             System.out.println("Invalid PoS index or PoS does not exist.");
         }
     }

     //CASE 3

     private static void listPossWithSameSalesCategories() {
        System.out.println("PoSs with the same number of sales categories:");
        
        // Loop through each PoS in the posArray
        for (int i = 0; i < posArray.length; i++) {
            if (posArray[i] != null) {
                // Get the string representation of current PoS's sales categories
                String currentCategoriesInfo = posArray[i].getMealSales().toString();
                boolean foundMatch = false;
    
                // Compare current PoS's sales categories with others in the posArray
                for (int j = i + 1; j < posArray.length; j++) {
                    if (posArray[j] != null && posArray[j].getMealSales().toString().equals(currentCategoriesInfo)) {
                        if (!foundMatch) {
                            // Output when matching PoS are found for the first time
                            System.out.println("PoSs " + i + " and " + j + " both have the same sales categories.");
                            foundMatch = true;
                        }
                        // Output when subsequent matches are found
                        System.out.println("PoSs " + j + " and " + i + " have the same sales categories.");
                    }
                }
            }
        }
    }
    
    //CASE 4
    private static void listPossWithSameSalesAmount() {
        System.out.println("PoSs with the same total sales amount:");
    
        // Loop through each PoS object in the array
        for (int i = 0; i < posArray.length; i++) {
            if (posArray[i] != null) {
                int currentSalesTotal = posArray[i].getTotalSales();
                boolean foundMatch = false;
    
                // Compare the current PoS with others to find matching total sales amounts
                for (int j = i + 1; j < posArray.length; j++) {
                    if (posArray[j] != null && posArray[j].getTotalSales() == currentSalesTotal) {
                        // If matching total sales are found, print information about them
                        if (!foundMatch) {
                            System.out.println("PoS " + i + " and PoS " + j + " have the same total sales amount.");
                            foundMatch = true;
                        }
                        System.out.println("PoS " + j + " has the same total sales amount as PoS " + i + ".");
                    }
                }
            }
        }
    }
    
    

    //CASE 5
    private static void listPossWithSameSalesAndPrePaidCards() {
        System.out.println("PoSs with the same total sales amount and the same number of prepaid cards:");
    
        for (int i = 0; i < posArray.length; i++) {
            if (posArray[i] != null) {    // Get the total sales and number of prepaid cards of the current PoS
                int currentSales = posArray[i].getTotalSales();
                int currentPrePaidCards = posArray[i].getNumberOfPrePaidCards();
                boolean foundMatch = false;
    
                for (int j = i + 1; j < posArray.length; j++) {
                    if (posArray[j] != null && posArray[j].getTotalSales() == currentSales
                            && posArray[j].getNumberOfPrePaidCards() == currentPrePaidCards) {
                        if (!foundMatch) {   // Output when matching PoS are found, displaying their total sales and prepaid cards
                            //  Output when matching PoS are found
                            System.out.println("PoSs " + i + " and " + j + " have the same total sales amount: $" +
                                    currentSales + " and the same number of prepaid cards: " + currentPrePaidCards);
                            foundMatch = true;
                        }
                    }
                }
            }
        }
    }
    


    // CASE 6

    private static void addPrePaidCardToPos() {
        Scanner sc = new Scanner(System.in);
        // Prompt the user for necessary PrePaidCard information
        System.out.println("Please enter the following information so that we may complete the PrePaidCard");
        System.out.print("Which PoS do you want to add a PrePaidCard to? (Enter number 0 to " + (posArray.length - 1) + "): ");
        int posIndex = sc.nextInt();
        sc.nextLine(); 
    
        if (posIndex >= 0 && posIndex < posArray.length && posArray[posIndex] != null) {
            System.out.print("--> Type of PrePaidCard (Carninvore, Halal, Kosher, Pescetarian, Vegetarian, Vegan)");
            String cardType = sc.nextLine();
            
            System.out.print("ID of the prepaid card owner: ");
            String cardHolderID = sc.nextLine();
            
            System.out.print("Expiry day number and month (seperated by a space): ");
            int expiryDay = sc.nextInt();
            int expiryMonth = sc.nextInt();
    
            // Create a prepaid card
            PrePaidCard newCard = new PrePaidCard(cardType, cardHolderID, expiryDay, expiryMonth);
    
            // Add the prepaid card to the PoS
            int updatedCardsCount = posArray[posIndex].addPrePaidCard(newCard);
            System.out.println("Prepaid card added to PoS " + posIndex + ". Number of cards in PoS " + posIndex + " is now: " + updatedCardsCount);
        } else {
            System.out.println("Invalid PoS index or PoS does not exist.");
        }

    }
    





    //CASE 7


    private static void removePrePaidCardFromPos() {
        Scanner sc = new Scanner(System.in); // Prompt the user to select the PoS for PrePaidCard removal
        System.out.print("Which PoS do you want to remove a PrePaidCard from? (Enter number 0 to " + (posArray.length - 1) + "): ");
        int posIndex = sc.nextInt();
        sc.nextLine(); 
      // Attempt to remove a PrePaidCard from the specified PoS
        if (posIndex >= 0 && posIndex < posArray.length && posArray[posIndex] != null) {
            boolean removed = posArray[posIndex].removePrePaidCard();
            if (removed) {
                System.out.println("Prepaid card removed from PoS " + posIndex + ".");
            } else {
                System.out.println("No prepaid card found in PoS " + posIndex + ".");
            }
        } else {
            System.out.println("Invalid PoS index or PoS does not exist.");
        }
    }
    




    //CASE 8

    private static void updatePrePaidCardExpiry() {
        Scanner sc = new Scanner(System.in);
        // Prompt the user to select the PoS for PrePaidCard update
        System.out.print("Which PoS do you want to update a PrePaidCard From? (Enter number 0 to " + (posArray.length - 1) + "): ");
        int posIndex = sc.nextInt();
        sc.nextLine(); 
    // Validate if the entered PoS index is valid and the PoS exists
        if (posIndex >= 0 && posIndex < posArray.length && posArray[posIndex] != null) {
            System.out.print("Which PrePaidCard do you want to want to update?: ");
            int cardIndex = sc.nextInt();
            sc.nextLine(); 
     // Prompt the user to enter the new expiry date for the PrePaidCard
            System.out.print("Enter the new expiry date day, number and month (seperated by a space): ");
            int newDay = sc.nextInt();
            int newMonth = sc.nextInt();
            sc.nextLine(); 
     // Update the expiry date of the specified PrePaidCard in the PoS
            posArray[posIndex].updatePrePaidCardExpiry(cardIndex, newDay, newMonth);
            System.out.println("Prepaid card expiry updated for PoS " + posIndex + ".");
        } else { // Handle invalid PoS index or non-existent PoS
            System.out.println("Invalid PoS index or PoS does not exist.");
        }
    }





    //CASE 9

    private static void addSalesToPos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which PoS do you want to add sales to? (Enter number 0 to " + (posArray.length - 1) + "): ");
        int posIndex = sc.nextInt();
        sc.nextLine(); 
    //validate if entered pos index is valid and the pos exists
        if (posIndex >= 0 && posIndex < posArray.length && posArray[posIndex] != null) {
            System.out.println("Enter the number of sales for each category (Junior, Medium, Big, Teen, Family):");
            System.out.print("Junior: ");
            int junior = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Medium: ");
            int medium = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Big: ");
            int big = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Teen: ");
            int teen = sc.nextInt();
            sc.nextLine(); 
    
            System.out.print("Family: ");
            int family = sc.nextInt();
            sc.nextLine(); 
        // Add sales for each category to the specified PoS
            int totalSales = posArray[posIndex].addmealsales(junior, medium, big, teen, family, 0);
            System.out.println("Sales added to PoS " + posIndex + ". Total sales: $" + totalSales);
        } else {
            System.out.println("Invalid PoS index or PoS does not exist.");
        }
    }
    
    
}
