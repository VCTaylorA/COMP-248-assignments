// ---------------------------------------------------------
// Assignment 4
// Written by: J Taylor A 40275281
// For COMP 248 Section P – Fall 2023
// ---------------------------------------------------------



public class PrePaidCard {
    //declare attributes
    private String cardType;
    private String cardHolderID;
    private int expiryDay;
    private int expiryMonth;


     public PrePaidCard(String cardType, String cardHolderID, int expiryDay, int expiryMonth){
        this.cardType = cardType;
        this.cardHolderID = cardHolderID;
        setExpiryDay(expiryDay);
        setExpiryMonth(expiryMonth);
     }


    //Default Constructor
    public PrePaidCard(){
        cardType = "";
        cardHolderID = "";
        expiryDay = 0;
        expiryMonth = 0;
    }

    //copy constructor with parameter of type PrePaidCard
    public PrePaidCard(PrePaidCard other){
        this.cardType = other.cardType;
        this.cardHolderID = other.cardHolderID;
        this.expiryDay = other.expiryDay;
        this.expiryMonth = other.expiryMonth; 
    }

    //accessor methods for each attribute
    public String getCardType(){
        return cardType;
    }

    public String getCardHolderID(){
        return cardHolderID;
    }

    public int getexpiryDay(){
        return expiryDay;
    }

    public int getexpiryMonth(){
        return expiryMonth;
    }


    //Mutator, to change expiry day

    public void setExpiryDay(int day){
        if (day >= 1 && day <= 31){
            this.expiryDay = day;
        }else{
            this.expiryDay = 0;
        }
    }

    // Mutator, to change expiry month
    public void setExpiryMonth(int month){
        if (month >= 1 && month <= 12){
            this.expiryMonth = month;
        }else{
            this.expiryMonth = 0;
        }
    }

    //Method toString() to display card information

    public String toString(){
        String formattedDay = String.valueOf(expiryDay);
        String formattedMonth = String.valueOf(expiryMonth);

        if (expiryDay < 10) {
            formattedDay = "0" + formattedDay;
        }
        if  (expiryMonth< 10){
            formattedMonth =  "0" + formattedMonth;
        }
        return 
        "Card Type: " + cardType + "\n" +
        "Card Holder ID: " + cardHolderID + "\n" +
        "Expiry Date: " + formattedDay + "/" + formattedMonth;
    }

    /* equals() which will return true if the two objects of type
     PrePaiCard are identical in other words have exactly the same 
     information and false otherwise.*/ 

public boolean equals( PrePaidCard other){
    return
    this.cardType.equals(other.cardType) &&
    this.cardHolderID.equals(other.cardHolderID) &&
    this.expiryDay == other.expiryDay &&
    this.expiryMonth == other.expiryMonth;
}






}