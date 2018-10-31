// Akhil Sachdev and Lab Assignment 5: Word Games

import java.util.Scanner;

public class Word_Games
{
   public static void main(String[] args)
   {     
      // Input variable
      String strUserInput;

      strUserInput = getUserInput();

      pigLatin(strUserInput);
      turkeyIrish(strUserInput);
      countVowel(strUserInput);
   }

   // get user input and validate
   public static String getUserInput()
   {
      int wordLength;
      String strInput;
      Scanner in = new Scanner(System.in);
      System.out.println("Please enter a word >= 4 letters :");
      //Accept & validate word entered
      do 
      {
         strInput = in.next();
         wordLength = strInput.length();
         if (wordLength < 4)
            System.out.println("Please enter a word that has at least 4 letters");
      } while (wordLength < 4);
      in.close();
      return strInput;
   }

   // Convert a word into PigLatin
   public static String pigLatin(String strUserInput)
   {   
      String newWord;
      //Create a pig latin word by manipulating parts of the word 
      newWord = strUserInput.substring(1,strUserInput.length()) + strUserInput.charAt(0) + "ay";
      System.out.println("Word made into Pig Latin : \n " + newWord);
      return newWord;     
   }

   // Convert a word into Turkey Irish
   public static String turkeyIrish(String strUserInput)
   {
      String newWord = strUserInput;
      //check each letter of the word for vowel and replace with ab+vowel
      for (int i=0;i< strUserInput.length();i++ )
      {
         if ( (strUserInput.charAt(i) == 'A') || (strUserInput.charAt(i) == 'a') ||
               (strUserInput.charAt(i) == 'E') || (strUserInput.charAt(i) == 'e') ||
               (strUserInput.charAt(i) == 'I') || (strUserInput.charAt(i) == 'i') ||
               (strUserInput.charAt(i) == 'O') || (strUserInput.charAt(i) == 'o') ||
               (strUserInput.charAt(i) == 'U') || (strUserInput.charAt(i) == 'u') )
            newWord = newWord.replace( Character.toString(strUserInput.charAt(i)), "ab"+strUserInput.charAt(i));
      }
      System.out.println("Word made into Turkey Irish : \n " + newWord);
      return newWord;
   }

   // Find Number of Vowels in a Word
   public static int countVowel(String strUserInput)
   {
      int vowelCount = 0;
      //check each letter of the word for vowel and increment the counter
      for (int i=0;i< strUserInput.length();i++ )
      {
         if ( (strUserInput.charAt(i) == 'A') || (strUserInput.charAt(i) == 'a') ||
               (strUserInput.charAt(i) == 'E') || (strUserInput.charAt(i) == 'e') ||
               (strUserInput.charAt(i) == 'I') || (strUserInput.charAt(i) == 'i') ||
               (strUserInput.charAt(i) == 'O') || (strUserInput.charAt(i) == 'o') ||
               (strUserInput.charAt(i) == 'U') || (strUserInput.charAt(i) == 'u') )
            vowelCount++;
      }
      System.out.println("# of volwels in the word : " + vowelCount);

      return vowelCount;
   }

}
