// Akhil Sachdev and Lab Assignment 6: A slot machine simulation

import java.util.Scanner;
import java.lang.Math;

public class Slot_Machine_Sim
{
   public static void main(String[] args)
   {     

      int intBetAmount;
      int intMultiplier;
      int intWininingAmount;
      Scanner input = null;
      //declare class reference
      TripleString thePull;


      do
      {
         // Get Bet Amount
         intBetAmount = getBet(input);

         if (intBetAmount == 0)
         {
            System.out.println("Goodbye.. Thanks for playing");
            break;
         }

         // instantiate the Pull object
         thePull = new TripleString();

         // Get the pull 
         System.out.println("Whirrrrr... your pull is ....");
         thePull = pull();

         //get multiplier based on the pull object
         intMultiplier = getPayMultiplier(thePull);

         //compute winning amount or lost
         intWininingAmount = intMultiplier * intBetAmount;

         //Show whether you lose or winning amount
         displayWinnings(thePull, intWininingAmount);

      } while (true);

   }


   public static TripleString pull()
   {

      TripleString randomPull;
      randomPull = new TripleString();
      randomPull.setstring1(randString());
      randomPull.setstring2(randString());
      randomPull.setstring3(randString());
      return randomPull;
   }

   private static String randString()
   {
      // Generate String based on probability
      double randomNum;
      String strPull = "";

      randomNum = Math.random();

      if (randomNum <= 0.5)
         strPull = "BAR";
      else if (randomNum > 0.5 && randomNum <= 0.75)
         strPull = "cherries";
      else if (randomNum > 0.75 && randomNum <= 0.875)
         strPull = "space";
      else if (randomNum > 0.875)
         strPull = "7";
      return strPull;
   }

   public static void displayWinnings(TripleString thePull, int intWinningAmount)
   {
      System.out.println( thePull.getstring1() + " " + thePull.getstring2() + " " + thePull.getstring3() );
      if (intWinningAmount == 0)
         System.out.println( "Sorry, you lose. ");
      else
         System.out.println( "Congratulations you won : $" + intWinningAmount);
   }

   // get Bet amount and validate
   public static int getBet(Scanner input)
   {
      int bet;
      boolean invalidBet;
      //Accept & validate bet amount entered
       input = new Scanner(System.in);
      do 
      {
         invalidBet = false;
         System.out.println("How much would you like to bet (1-100) ? or 0 to quit :");
         bet = input.nextInt();
         if (bet < 0 || bet > 100)
         {
            System.out.println("Invalid amount. Please enter a bet amount (1-100) ");
            invalidBet = true;
         }
      } while (invalidBet);
      
      if (bet == 0) 
         input.close();   
      return bet;
   }

   //get Pay Multiplier
   public static int getPayMultiplier(TripleString thePull)
   {
      int winnings;

      if (thePull.getstring1() == "7" && thePull.getstring2() == "7" && thePull.getstring3() == "7")
         winnings = 100;
      else if (thePull.getstring1() == "BAR" && thePull.getstring2() == "BAR" && thePull.getstring3() == "BAR")
         winnings = 50;
      else if (thePull.getstring1() == "cherries" && thePull.getstring2() == "cherries" && thePull.getstring3() == "cherries")
         winnings = 30;
      else if (thePull.getstring1() == "cherries" && thePull.getstring2() == "cherries")
         winnings = 15;
      else if (thePull.getstring1() == "cherries")
         winnings = 5;
      else
         winnings = 0;

      return winnings;
   }

}

// TripleString Class
class TripleString
{
   // members 
   private String string1;
   private String string2;
   private String string3;
   public static final int MAX_LEN = 20;

   // constructor
   TripleString()
   {
      string1 = "";
      string2 = "";
      string3 = "";
   }

   // mutator (set) methods
   public boolean setstring1(String str1)
   {
      if (validateString(str1))
      {
         string1 = str1;
         return true;
      }
      else 
         return false;
   }

   private boolean validateString(String strVal)
   {
      if (strVal.length() <= MAX_LEN)
         return true;
      else 
         return false;
   }

   public boolean setstring2(String str2)
   {
      if (validateString(str2))
      {
         string2 = str2;
         return true;
      }
      else 
         return false;
   }

   public boolean setstring3(String str3)
   {
      if (validateString(str3))
      {
         string3 = str3;
         return true;
      }
      else 
         return false;
   }


   // accessor (get) methods
   public String getstring1()
   {
      return string1;
   }
   public String getstring2()
   {
      return string2;
   }
   public String getstring3()
   {
      return string3;
   }  

}

