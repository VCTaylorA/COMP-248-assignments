// ---------------------------------------------------------
// Assignment 4
// Written by: J Taylor A 40275281
// For COMP 248 Section P – Fall 2023
// ---------------------------------------------------------



public class PoS {
    private Sales mealSales;
    private PrePaidCard[] PrePaidCards;
    
    //default constructors
    public PoS(){
        mealSales = new Sales();
        PrePaidCards = new PrePaidCard[5];
    }

    //Constructor with 2 parameters
    public PoS(Sales mealSales, PrePaidCard[] PrePaidCards){
        this.mealSales =mealSales;
        this.PrePaidCards = PrePaidCards;
    }

    public PoS(Sales mealSales){
        this.mealSales = mealSales;
    }

    //Method to compare total $ value of sales of two PoS objects
    public boolean equalTotalSales(PoS other){
        return this.getTotalSales() == other.getTotalSales();
    }

    //Method to compare number of each sales category of two PoS objects
    public boolean equalSalesCategories(PoS other){
        return this.mealSales.equals(other.mealSales);
    }

    //Method to return the total $ sales of a PoS
    public int getTotalSales(){
        return mealSales.sales_total();
    }
    // Method to return the number of prepaid cards in a PoS
    public int getNumberOfPrePaidCards(){
        if (PrePaidCards == null){
            return 0;
        } else {
            return PrePaidCards.length;
        }
    }
    //Method to add a new PrePaidCard to the pos
    public int addPrePaidCard(PrePaidCard newCard){
        if (PrePaidCards == null){
            PrePaidCards = new PrePaidCard[]{newCard};
        } else {
            PrePaidCard[] temporary = new PrePaidCard[PrePaidCards.length + 1];
            System.arraycopy(PrePaidCards, 0, temporary, 0, PrePaidCards.length);
            temporary[temporary.length - 1] = newCard;
            PrePaidCards = temporary;
        }
        return getNumberOfPrePaidCards();
    }
    
    //remove prepaid card from POS
    public boolean removePrePaidCard() {
        if (PrePaidCards != null && PrePaidCards.length > 0) {
            PrePaidCard[] temporary = new PrePaidCard[PrePaidCards.length - 1];
            System.arraycopy(PrePaidCards, 0, temporary, 0, PrePaidCards.length - 1);
            PrePaidCards = temporary;
            return true;
        }
        return false;
    }
    
    // Method to update the expiry day and month of a prepaid card
    public void updatePrePaidCardExpiry(int cardIndex, int day, int month){
        if(PrePaidCards != null && cardIndex >= 0 && cardIndex<PrePaidCards.length){
            PrePaidCards[cardIndex].setExpiryDay(day);
            PrePaidCards[cardIndex].setExpiryMonth(month);
        }
    }

    //method to add meals to the pos

    public int addmealsales(int carnivore, int halal, int kosher, int pescetarian, int vegetarian, int vegan){
        mealSales.add_sales(carnivore, halal, kosher, pescetarian, vegetarian, vegan);
        return mealSales.sales_total();
    }
    
    /*Method equals() which compares total sales value 
    AND number of pre-paid cards of two PoS objects*/
    public boolean equals(PoS other){
        return this.getTotalSales() == other.getTotalSales() && this.getNumberOfPrePaidCards() == other.getNumberOfPrePaidCards();
    }

    public String toString() { //displays sales for our PoS Summary Methods
        String salesBreakdown = "Sales Breakdown:\n";
    
        if (mealSales != null) {
            salesBreakdown += "Carnivore Meals Sold: " + mealSales.getCarnivoreMealsSold() + "\n" +
                    "Halal Meals Sold: " + mealSales.getHalalMealsSold() + "\n" +
                    "Kosher Meals Sold: " + mealSales.getKosherMealsSold() + "\n" +
                    "Pescetarian Meals Sold: " + mealSales.getPescetarianMealsSold() + "\n" +
                    "Vegetarian Meals Sold: " + mealSales.getVegetarianMealsSold() + "\n" +
                    "Vegan Meals Sold: " + mealSales.getVeganMealsSold() + "\n\n";
        } else {
            salesBreakdown += "No sales data available\n";
        }
    
        String PrePaidCardsInfo = "Pre-Paid Cards:\n";
        boolean hasPrePaidCards = false;
    
        if (PrePaidCards != null) { //prepare card info
            for (PrePaidCard card : PrePaidCards) {
                if (card != null) {
                    PrePaidCardsInfo += card.toString() + "\n";
                    hasPrePaidCards = true;
                }
            }
        }
    
        if (!hasPrePaidCards) {
            PrePaidCardsInfo += "No pre-paid cards";
        }
    
        return salesBreakdown + PrePaidCardsInfo;
    }
    
    
    


}
