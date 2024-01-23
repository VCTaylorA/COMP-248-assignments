// ---------------------------------------------------------
// Assignment 4
// Written by: J Taylor A 40275281
// For COMP 248 Section P – Fall 2023
// ---------------------------------------------------------




public class Sales {
    private int carnivore_meals_sold;
    private int halal_meals_sold;
    private int kosher_meals_sold;
    private int pescetarian_meals_sold;
    private int vegetarian_meals_sold;
    private int vegan_meals_sold;

    //default constructor that initializes meal count to 0
    public Sales(){
        carnivore_meals_sold = 0;
        halal_meals_sold = 0;
        kosher_meals_sold = 0;
        pescetarian_meals_sold = 0;
        vegetarian_meals_sold = 0;
        vegan_meals_sold = 0;
    }

    public void add_sales(int carnivore,int halal, int kosher, int pescetarian, int vegetarian, int vegan){
        carnivore_meals_sold += vegan;
        halal_meals_sold += halal;
        kosher_meals_sold += vegan;
        pescetarian_meals_sold += pescetarian;
        vegetarian_meals_sold += vegetarian;
        vegan_meals_sold += vegan;
    }
    public String toString(){
        return  "Carnivore Meals Sold: " + carnivore_meals_sold + "\n" +
                "Halal Meals Sold: " + halal_meals_sold + "\n" +
                "Pescetarian Meals Sold: " + pescetarian_meals_sold + "\n" +
                "Vegetarian Meals Sold: " + vegetarian_meals_sold + "\n" +
                "Vegan Meals Sold: "+vegan_meals_sold ;

    }
    public int countMealTypes() { //we need this method for the ListPossWithSameSalesCategories() method in the demo
        int count = 0;
        if (carnivore_meals_sold > 0) count++;
        if (halal_meals_sold > 0) count++;
        if (kosher_meals_sold > 0) count++;
        if (pescetarian_meals_sold > 0) count++;
        if (vegetarian_meals_sold > 0) count++;
        if (vegan_meals_sold > 0) count++;

        return count;
    }


    public int sales_total(){

        int carnivore_price =1;
        int halal_price = 1;
        int kosher_price =1;
        int pescetarian_price = 1;
        int vegetarian_price = 1;
        int vegan_price = 1;

        int sum_of_sales = (carnivore_meals_sold* carnivore_price)+
                        (halal_meals_sold* halal_price)+
                        (kosher_meals_sold*kosher_price)+
                        (pescetarian_meals_sold*pescetarian_price)+
                        (vegetarian_meals_sold*vegetarian_price)+
                        (vegan_meals_sold*vegan_price);
        return sum_of_sales;

    }

    public boolean equals(Object obj){
        if (this ==obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
    }

// Add getter methods for meal categories
    public int getCarnivoreMealsSold() {
        return carnivore_meals_sold;
    }

    public int getHalalMealsSold() {
        return halal_meals_sold;
    }

    public int getKosherMealsSold() {
        return kosher_meals_sold;
    }

    public int getPescetarianMealsSold() {
        return pescetarian_meals_sold;
    }

    public int getVegetarianMealsSold() {
        return vegetarian_meals_sold;
    }

    public int getVeganMealsSold() {
        return vegan_meals_sold;
    }







}
