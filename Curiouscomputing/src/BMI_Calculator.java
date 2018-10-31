// Akhil Sachdev and Lab Assignment 3: Calculation of BMI

import java.util.Scanner;

public class BMI_Calculator
{
   public static void main(String[] args)
   {     
      int intWeight;
   	int intHeight;
   	double dblBMI;
   	 
   	   Scanner in = new Scanner(System.in);
	
   	    System.out.println("Run 1");
   	   

   	      // Accept user weight 
   	        System.out.println("Enter Weight (in pounds)");
   	        intWeight= in.nextInt();
   	      
   	      // Validate weight information

   	     if (intWeight < 0)
   	        {System.out.println("Invalid weight entered, Program Terminated!!!!"); 
	           return;}
   	 
   	      // Accept user height 
   	        System.out.println("Enter Height (in inches)");
   	        intHeight = in.nextInt();

   	     // Validate height information

   	     if (intHeight < 0)
   	        {System.out.println("Invalid height entered, Program Terminated!!!!"); 
	           return;}


   	       // Calculate BMI

   	       dblBMI = ( intWeight * 703.0) / ( intHeight * intHeight );

   	       if (dblBMI <= 18.5 )
     	          System.out.println("BMI = " + dblBMI+"  You are underweight"); 
     	       else if (dblBMI >= 25)
     	          System.out.println("BMI = " + dblBMI+"  You are overweight"); 
     	       else 
     	          System.out.println("BMI = " + dblBMI+"  You weight is optimal");  
   	       
   	 	   System.out.println("Run 2");

    	      // Accept user weight 
    	      System.out.println("Enter Weight (in pounds)");
    	      intWeight= in.nextInt();
    	  
    	      // Validate weight information

    	      if (intWeight <= 0)
      	      {System.out.println("Invalid weight entered, Program Terminated!!!!"); 
      	      return;}
   	 
    	      // Accept user height 
    	         System.out.println("Enter Height (in inches)");
    	         intHeight = in.nextInt();
  
    	     // Validate height information

    	     if (intHeight <= 0)
    	        {System.out.println("Invalid height entered, Program Terminated!!!!"); 
	           return;}

    	       // Calculate BMI

    	       dblBMI = ( intWeight * 703.0) / ( intHeight * intHeight );

    	       if (dblBMI <= 18.5 )
     	          System.out.println("BMI = " + dblBMI+"  You are underweight"); 
     	       else if (dblBMI >= 25)
     	          System.out.println("BMI = " + dblBMI+"  You are overweight"); 
     	       else 
     	          System.out.println("BMI = " + dblBMI+"  You weight is optimal");  
    	       
   	 	   System.out.println("Run 3");

     	      // Accept user weight 
     	         System.out.println("Enter Weight (in pounds)");
     	         intWeight= in.nextInt();
     	  
     	      // Validate weight information

     	      if (intWeight <= 0)
       	      {System.out.println("Invalid weight entered, Program Terminated!!!!"); 
       	      return;}
    	 
     	      // Accept user height 
     	         System.out.println("Enter Height (in inches)");
     	         intHeight = in.nextInt();
   
     	     // Validate height information

     	     if (intHeight <= 0)
     	        {System.out.println("Invalid height entered, Program Terminated!!!!"); 
              return;}

     	       // Calculate BMI

     	       dblBMI = ( intWeight * 703.0) / ( intHeight * intHeight );

     	       if (dblBMI < 18.5 )
     	          System.out.println("BMI = " + dblBMI+"  You are underweight"); 
     	       else if (dblBMI > 25)
     	          System.out.println("BMI = " + dblBMI+"  You are overweight"); 
     	       else 
     	          System.out.println("BMI = " + dblBMI+"  You weight is optimal");  

   }

}
