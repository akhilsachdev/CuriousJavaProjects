//Akhil Sachdev and Lab Assignment 9: A Pizzaria

import java.util.Scanner;

public class Pizza_Ordering
{
   public static void main(String[] args)
   {     
      //declare & Instantiate Applicant objects with parameters
      PizzaOrder myPizza; 
      int selectTopping;
      char pizzaSize;

      Scanner input = new Scanner(System.in);

      // Outer loop for Pizza Order     
      do
      {
         pizzaSize = getPizzaSize(input);

         //Logic based on first character of Menu Options
         if ( pizzaSize == 's' || pizzaSize == 'S' )
            myPizza = new PizzaOrder(0);
         else if ( pizzaSize == 'm' || pizzaSize == 'M' )
            myPizza = new PizzaOrder(1);
         else if ( pizzaSize == 'l' || pizzaSize == 'L' )
            myPizza = new PizzaOrder(2);
         else if ( pizzaSize == 'd' || pizzaSize == 'D' )
            myPizza = new PizzaOrder(3);
         else 
            break;

         System.out.println("Current Pizza: " + myPizza.stringizeSize());

         //Inner Loop for Toppings selection
         do
         {
            displayToppingsMenu();

            selectTopping = input.nextInt();

            if (selectTopping == 0)
               break;

            //Validate purchase set value is between 1 and 11
            if (selectTopping > 12 || selectTopping < 0)
            {
               System.out.println("Sorry, Toppings selection must be (1 - 12)");
               continue;
            }

            //Add Toppings to the pizza order

            if (!myPizza.addToppings(selectTopping))
            {
               System.out.println("You have exceeded toppings limit, you are done with adding toppings");
               break;
            }
            System.out.println(myPizza.stringizeSize() + " + " + myPizza.getToppings());
         }
         while (true);

         myPizza.displayPizza();
         myPizza.resetToppings();

      }
      //Condition to check for continuing the loop
      while ( pizzaSize != 'Q' && pizzaSize != 'q' );

      input.close();


   }


   // Foothill method - get Pizza Size and validate input
   public static char getPizzaSize(Scanner input)
   {
      String strSize;
      char charSize;

      do
      {
         //Select Pizza Size
         System.out.println("\nSelect Size of Pizza:");
         System.out.println("('s', 'm', 'l', 'd') or 'q' to quit :");

         //Accept user menu input
         strSize = input.next();
         charSize = strSize.charAt(0);

         if (( charSize == 's') || (charSize == 'S') ||
               (charSize == 'm') || (charSize == 'M') ||
               (charSize == 'l') || (charSize == 'L') ||
               (charSize == 'd') || (charSize == 'D') ||
               (charSize == 'q') || (charSize == 'Q') )
            break;
         else 
            //Message for invalid message option
            System.out.println("Invalid Size. Enter S, M, L, D or Q to quit, please");
      }
      while (true);

      return charSize;
   }

   // Foothill Method - Display toppings menu
   public static void displayToppingsMenu()
   {
      System.out.println("\nSelect Toppings by number (0 when done) :");
      System.out.println(" 1. onions");
      System.out.println(" 2. bell peppers");
      System.out.println(" 3. olives");
      System.out.println(" 4. pepperoni");
      System.out.println(" 5. tomatoes");
      System.out.println(" 6. spinach");
      System.out.println(" 7. artichoke");
      System.out.println(" 8. garlic");
      System.out.println(" 9. pinapple");
      System.out.println(" 10. jalapenos");
      System.out.println(" 11. sausage");
      System.out.println(" 12. chicken");
      System.out.print(" Selection: ");

   }


}



// Pizza Order Class
class PizzaOrder
{
   // members 
   private int size;
   private int numtoppings;
   private String[] toppings;


   // Valid Values
   public static final String[] TOPPINGS_OFFERED = { 
         "onions", "bell pepers", "olives", "pepperoni", 
         "tomatoes", "spinach", "artichoke", "garlic", 
         "pinapple", "jalepenos", "sausage", "chicken"
   };

   public static final double TOPPINGS_BASE_COST = 0.25;
   public static final double BASE_PRICE = 7.00;
   public static final int SMALL_SIZE = 0;
   public static final int MEDIUM_SIZE = 1;
   public static final int LARGE_SIZE = 2;
   public static final int SUDU_SIZE = 3;
   public static final int MAX_TOPPINGS = 11;


   // Default values
   public static final int DEFAULT_SIZE = 0;
   public static final int NO_TOPPINGS = 0;
   public static final int MIN_NUMBER = 0;
   public static final int MAX_NUMBER = 3;

   //public static final String DEFAULT_NAME = "(undefined or error)";


   // constructor that sets the default values
   public PizzaOrder()
   {
      size = DEFAULT_SIZE;
      toppings = new String[MAX_TOPPINGS];
      numtoppings = NO_TOPPINGS;
   }  

   // constructor that takes parameter values
   public PizzaOrder(int size)
   {
      if (!setsize(size))
         setsize(DEFAULT_SIZE);
      toppings = new String[MAX_TOPPINGS];
      numtoppings = NO_TOPPINGS;
   }

   // mutator (set) methods
   public boolean setsize(int size)
   {
      if (validateSize(size, MIN_NUMBER, MAX_NUMBER))
      {
         this.size = size;
         return true;
      }
      else 
         return false;
   }

   // validate size
   private boolean validateSize(int num, int min, int max)
   {
      if (num >= min && num <= max)
         return true;
      else 
         return false;
   }

   public boolean addToppings(String strtopping)
   {
      int k = this.toppings.length;

      if (k > MAX_TOPPINGS)
         return false;
      else 
      {
         this.toppings[k] = strtopping;
         this.numtoppings++;
         return true;
      }
   }

   public boolean addToppings(int toppingpos)
   {
      int i = numtoppings;

      if (i > MAX_TOPPINGS)
         return false;
      else 
      {
         this.toppings[i] = TOPPINGS_OFFERED[toppingpos-1];
         this.numtoppings++;
         return true;
      }
   }


   // accessor (get) methods
   public int getsize() { return size; }  

   // calculate price of pizza

   private double getPrice()
   {
      double price;

      if (this.size == 3)
         price = (BASE_PRICE * 1.35) + (this.numtoppings * TOPPINGS_BASE_COST);
      else if (this.size == 2)
         price = (BASE_PRICE * 1.25) + (this.numtoppings * TOPPINGS_BASE_COST);
      else if (this.size == 1)
         price = (BASE_PRICE * 1.15) + (this.numtoppings * TOPPINGS_BASE_COST);
      else
         price = BASE_PRICE + (this.numtoppings * TOPPINGS_BASE_COST);

      return price;
   }  

   public String stringizeSize()
   {
      String strSize;

      if (this.size == 3)
         strSize = "Super Duper";
      else if (this.size == 2)
         strSize = "Large";
      else if (this.size == 1)
         strSize = "Medium";
      else
         strSize = "Small";

      return strSize;
   }  

   public String getToppings()
   {
      String strToppings = "";

      for (int i = 0; i < numtoppings; i++)
      {
         strToppings = strToppings + toppings[i] + ",";

      }
      return strToppings;
   }  

   //create a string to show pizza order  
   public void displayPizza()
   {
      System.out.println( "Pizza Order:");
      System.out.print("Size: " + stringizeSize());
      System.out.print(" Toppings: " + getToppings());
      System.out.print( "\nTotal Price: $" );
      System.out.printf("%.2f", getPrice());

   }   

   public void resetToppings()
   {
      numtoppings = NO_TOPPINGS;
      toppings = new String[MAX_TOPPINGS];
   }


}

