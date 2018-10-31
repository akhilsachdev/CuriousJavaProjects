// Akhil Sachdev and Lab Assignment 8: Computer Dating

public class Online_Dating_Sim
{
   public static void main(String[] args)
   {     
      //declare & Instantiate Applicant objects with parameters
      DateProfile[] applicant = {  
            new DateProfile("Hugh Hefner", 'M', 'F', 6, 4, 3),
            new DateProfile("Carmen Miranda", 'F', 'M', 5, 9, 3),
            new DateProfile("Brad Pitt", 'M','F', 9, 2, 8),
            new DateProfile("Mary Lynn Rajskub", 'F', 'M', 8, 5, 3)
      };

      //Outer Loop For Checking each applicant
      for (int i = 0; i < applicant.length; i++)
      {
         System.out.println(applicant[i].getname());
         //Inner Loop for comparing with each applicant
         for ( int k=0; k< applicant.length; k++)
            {
            System.out.println("  " + applicant[i].profileFitInfo(applicant[k]));
            }
      }

   }
}

// Date Profile Class
class DateProfile
{
   // members 
   private String name;
   private char gender;
   private char searchGender;
   private int romance;
   private int finance;
   private int distance;

   // Valid Values
   public static final int MIN_NUMBER = 1;
   public static final int MAX_NUMBER = 10;
   public static final char GENDER_MALE = 'M';
   public static final char GENDER_FEMALE = 'F';

   // Default values
   public static final char DEFAULT_CHAR = 'M';
   public static final int DEFAULT_INT = 1;
   public static final String DEFAULT_NAME = "(undefined or error)";


   // constructor that sets the default values
   public DateProfile()
   {
      name = DEFAULT_NAME;
      gender = DEFAULT_CHAR;
      searchGender = DEFAULT_CHAR;
      romance = DEFAULT_INT;
      finance = DEFAULT_INT;
      distance = DEFAULT_INT;
   }  

   // constructor that takes parameter values
   public DateProfile(String name, char gender, char searchGender, int romance, int finance, int distance)
   {

      if (!setname(name))
         setname(DEFAULT_NAME);  

      if (!setgender(gender))
         setgender(DEFAULT_CHAR);

      if (!setsearchGender(searchGender))
         setsearchGender(DEFAULT_CHAR);

      if (!setromance(romance))
         setromance(DEFAULT_INT);

      if (!setfinance(finance))
         setromance(DEFAULT_INT);

      if (!setdistance(distance))
         setdistance(DEFAULT_INT);

   }

   // mutator (set) methods
   public boolean setname(String name)
   {
      if (validateString(name))
      {
         this.name = name;
         return true;
      }
      else 
         return false;
   }

   private boolean validateString(String strVal)
   {
      if (strVal != null && strVal.length() > 0 && Character.isLetter(strVal.charAt(0)))
         return true;
      else 
         return false;
   }

   public boolean setgender(char gender)
   {
      if (validateGender(gender))
      {
         this.gender = gender;
         return true;
      }
      else 
         return false;
   }

   public boolean setsearchGender(char searchGender)
   {
      if (validateGender(searchGender))
      {
         this.searchGender = searchGender;
         return true;
      }
      else 
         return false;
   }

   // validate gender
   private boolean validateGender(char charVal)
   {
      if (charVal == GENDER_MALE || charVal == GENDER_FEMALE)
         return true;
      else 
         return false;
   }

   public boolean setromance(int romance)
   {
      if (validateNumber(romance, MIN_NUMBER, MAX_NUMBER))
      {
         this.romance = romance;
         return true;
      }
      else 
         return false;
   }

   public boolean setfinance(int finance)
   {
      if (validateNumber(finance, MIN_NUMBER, MAX_NUMBER))
      {
         this.finance = finance;
         return true;
      }
      else 
         return false;
   }

   public boolean setdistance(int distance)
   {
      if (validateNumber(distance, MIN_NUMBER, MAX_NUMBER))
      {
         this.distance = distance;
         return true;
      }
      else 
         return false;
   }

   // validate romance, finance, distance numbers
   private boolean validateNumber(int num, int min, int max)
   {
      if (num >= min && num <= max)
         return true;
      else 
         return false;
   }

   // accessor (get) methods
   public String getname() { return name; }
   public char getgender() { return gender; }
   public char getsearchGender() { return searchGender; }
   public int getromance() { return romance; }  
   public int getfinance() { return finance; }  
   public int getdistance() { return distance; }  

   // calculate overall Fit Value by passing other applicant object

   private double fitValue(DateProfile otherApplicant)
   {
      double fitvalue;

      fitvalue = determineGenderFit(otherApplicant) * determineRomanceFit(otherApplicant) * 
            determineFinanceFit(otherApplicant) * determineDistanceFit(otherApplicant);

      return fitvalue;

   }  

   //create a string with other Applicant and Fit Value info   
   public String profileFitInfo(DateProfile otherApplicant)
   {
      String strProfileFit;
      double dblFitValue;
      dblFitValue = fitValue(otherApplicant);
      strProfileFit = otherApplicant.getname() + " fit: " + dblFitValue;
      return strProfileFit;
   }

   // methods that accept "other applicant" object and find the individual fit values

   private double determineGenderFit(DateProfile otherApplicant)
   {
      if ((this.searchGender == otherApplicant.gender) && (otherApplicant.searchGender == this.gender))
      {
         return 1;
      }
      else 
         return 0;
   }

   private double determineRomanceFit(DateProfile otherApplicant)
   {
      double fitvalue;
      fitvalue = findfitvalue(this.romance, otherApplicant.romance);
      return fitvalue;

   }
   
   // common fit value calculation for Romance, Finance and Distance
   private double findfitvalue(int val1, int val2)
   {
      double dblValue = 0;
      double intdiff = 0;
      double denom = 10;
   
      intdiff = (double) ((Math.abs(val1-val2) / denom));
      dblValue = (double) (1 - (double) intdiff);
      return dblValue;
   }

   private double determineFinanceFit(DateProfile otherApplicant)
   {
      double fitvalue;
      fitvalue = findfitvalue(this.finance, otherApplicant.finance);
      return fitvalue;
   }

   private double determineDistanceFit(DateProfile otherApplicant)
   {
      double fitvalue;
      fitvalue = findfitvalue(this.distance, otherApplicant.distance);
      return fitvalue;
   }



}

