// Akhil Sachdev and Lab Assignment 4: Candy Bar Locker

import java.util.Scanner;

public class Cost_Calculator_1
{
   public static void main(String[] args)
   {     
      int availableBars = 15;
      int INIT_COST = 15;
      int totalCost = INIT_COST;
      String strUserMenuOption;
      int intConsumeBars;
      int intRemainingBars ;
      int intPurchaseSet;


      Scanner in = new Scanner(System.in);

      System.out.println("Initial Account Settings:");
      System.out.println(" Avaiable Bars:\t" + availableBars);
      System.out.println(" Cost (so far) this month:  $" + INIT_COST);

      do
      {
         //Display Menu options
         System.out.println("Menu:");
         System.out.println(" B (Show Bill and starts new month)");
         System.out.println(" A (show Available number of bars for current month)");
         System.out.println(" C (Consume bars now)");
         System.out.println(" P (Purchase additional bars for current month)");
         System.out.println(" Q (show bill and Quit)");

         //Accept user menu input
         strUserMenuOption = in.next();

         //Logic based on first character of Menu Options
         if ( strUserMenuOption.charAt(0) == 'B' || strUserMenuOption.charAt(0) == 'b' )
         {   
            System.out.println("Closing Bill for month:");
            System.out.println(" Unused Bars:\t" + availableBars);
            System.out.println(" Final amount due immediately:  $" + totalCost);
            availableBars = 15;
            System.out.println("\nStarting new month ...Avaiable Bars:" + availableBars);
            totalCost = 15;

         }
         else if (strUserMenuOption.charAt(0) == 'A' || strUserMenuOption.charAt(0) == 'a')
            System.out.println("Avaiable Bars:" + availableBars);
         else if (strUserMenuOption.charAt(0) == 'C' || strUserMenuOption.charAt(0) == 'c')
         {
            System.out.println("\n Your Choice:\t" + strUserMenuOption);   
            System.out.println(" Number of bars you want to Consume: \t");
            intConsumeBars = in.nextInt();
            intRemainingBars = availableBars - intConsumeBars;

            //Validate the consumed bars amount and it should be between 1 and 10
            if (intConsumeBars > 10 || intConsumeBars <= 0)
            {
               System.out.println("Sorry, amounts must be between 1 and 10");
               System.out.println("\nAvaiable Bars:" + availableBars);
               continue;
            }
            //Validate to see if you exceeded monthly allotment
            else if (intRemainingBars <= 0)
            {
               System.out.println("You exceeded your monthly allotment. $15 / 10 bars added to current balances.");
               availableBars += 10;
               totalCost = totalCost + 15;
            }

            availableBars = availableBars - intConsumeBars;
            System.out.println("Avaiable Bars:\t" + availableBars);

         }

         else if (strUserMenuOption.charAt(0) == 'P' || strUserMenuOption.charAt(0) == 'p')
         {
            System.out.println("\n Your Choice:\t" + strUserMenuOption);   
            System.out.println(" Purchase additional bars in sets  of 10 (1-3): \t");
            intPurchaseSet = in.nextInt();
            //Validate purchase set value is between 1 and 3
            if (intPurchaseSet > 3 || intPurchaseSet <= 0)
            {
               System.out.println("Sorry, amounts must be between 1 and 3");
               System.out.println("\nAvaiable Bars:" + availableBars);
               continue;
            }
            //Calculate available bars and cost based on the purchase set input value
            availableBars = availableBars + (intPurchaseSet *10);
            totalCost = totalCost + (intPurchaseSet * 11);
            System.out.println("\n Avaiable Bars: " + availableBars);
         }
         else if (strUserMenuOption.charAt(0) == 'Q' || strUserMenuOption.charAt(0) == 'q')
         {
            System.out.println(" Total Monthly Bill is:  $" + totalCost);
         }
         else 
         {
            //Message for invalid message option
            System.out.println("\n Your Choice:\t" + strUserMenuOption);
            System.out.println(" Use B, A, C, P or Q, please");
         }

      }
      //Condition to check for continuing the loop
      while (strUserMenuOption.charAt(0) != 'Q' && strUserMenuOption.charAt(0) != 'q' );
   }
}
