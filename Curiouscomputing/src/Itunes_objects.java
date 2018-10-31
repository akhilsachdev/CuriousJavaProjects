// Akhil Sachdev and Lab Assignment 7: iTunes Objects

public class Itunes_objects
{
   public static void main(String[] args)
   {     

      //declare iTunes objects
      iTunes theiTunes1;
      iTunes theiTunes2;
      iTunes theiTunes3;
      iTunes theiTunes4;

      System.out.println( "Artist        Title      Play time (sec)    Bitrate (K bits per sec)");
      System.out.println( "=========================================================================");

      // instantiate iTunes 1 objects as default

      System.out.println( " iTunes 1 - Default values");
      theiTunes1 = new iTunes();
      theiTunes1.display();

      //mutator test
      System.out.println( "iTunes 1 - Set artist, title ");

      theiTunes1.setartist("Akhil Sachdev");
      theiTunes1.setname("My favorite music");

      theiTunes1.display();

      //accessor test
      System.out.println( "iTunes 1 - Accessor bitrate, play time ");
      System.out.println( "Bitrate : " + theiTunes1.getbitrate() + "K bits per second");
      System.out.println( "Play Time : " + theiTunes1.gettotalTime()/1000 + "seconds");



      // instantiate iTunes object with parameters
      theiTunes2 = new iTunes("You were never mine", "Janiva Magness", 128, 36500);

      System.out.println( "\n iTunes 2 ");
      theiTunes2.display();

      //mutator test
      System.out.println( "iTunes 2 - Set artist, title ");

      theiTunes2.setartist("Janiva -Changed");
      theiTunes2.setname("You were never mine -CHANGED");

      theiTunes2.display();

      //accessor test
      System.out.println( "iTunes 2 - Accessor Artist, play time ");
      System.out.println( "Artist : " + theiTunes2.getartist());
      System.out.println( "Play Time : " + theiTunes2.gettotalTime()/1000 + "seconds");


      // instantiate iTunes object with parameters
      System.out.println( "\n iTunes 3 ");

      theiTunes3 = new iTunes("Hall of Fame", "The Script", 128, 240000);
      theiTunes3.display();

      //mutator test
      System.out.println( "iTunes 3 - Set bitrate, playtime ");

      theiTunes3.setbitrate(64);
      theiTunes3.settotalTime(200000);
      theiTunes3.display();

      //accessor test
      System.out.println( "iTunes 2 - Accessor bitrate play time ");
      System.out.println( "Bitrate : " + theiTunes3.getbitrate() + "K bits per second");
      System.out.println( "Play Time : " + theiTunes3.gettotalTime()/1000 + "seconds");

      // instantiate iTunes object with parameters
      System.out.println( "\n iTunes 4 ");

      theiTunes4 = new iTunes("Cake by the Ocean", "DNCE", 512, 180000);
      theiTunes4.display();

      //mutator test
      System.out.println( "iTunes 4 - Set bitrate, playtime - Invalid min values ");

      if ( !theiTunes4.setbitrate(-64))
         System.out.println( "Bitrate could not be set to -64");
      else
         System.out.println( "Bitrate set to -64");

      if (!theiTunes4.settotalTime(-300))
         System.out.println( "Total time could not be set to -300");
      else
         System.out.println( "Total time set to -300");

      theiTunes4.display();

      System.out.println( "iTunes 4 - Set bitrate - Invalid max values ");

      if ( !theiTunes4.setbitrate(800))
         System.out.println( "Bitrate could not be set to 800");
      else
         System.out.println( "Bitrate set to 800");

      theiTunes4.display();

      System.out.println( "iTunes 4 - Set bitrate to 705 ");
      theiTunes4.setbitrate(705);
      theiTunes4.display();


   }
}

// iTunes Class
class iTunes
{
   // members 
   private String name;
   private String artist;
   private int bitrate;
   private int totalTime;

   public static final int MIN_BITRATE = 64;
   public static final int MAX_BITRATE = 705;
   public static final int MIN_STR_LENGTH = 1;
   public static final int MAX_STR_LENGTH = 80;
   public static final int MIN_PLAYTIME = 1000;
   public static final int MAX_PLAYTIME = 1000*60*60;

   public static final int DEFAULT_BITRATE = 64;
   public static final int DEFAULT_PLAYTIME = 1000;
   public static final String DEFAULT_STRING = "(undefined)";


   // constructor that sets the default values
   public iTunes()
   {
      name = DEFAULT_STRING;
      artist = DEFAULT_STRING;
      bitrate = DEFAULT_BITRATE;
      totalTime = DEFAULT_PLAYTIME;
   }  

   // constructor that takes parameter values
   public iTunes(String name, String artist, int bitrate, int totalTime)
   {

      if (!setname(name))
         setname(DEFAULT_STRING);  

      if (!setartist(artist))
         setartist(DEFAULT_STRING);

      if (!setbitrate(bitrate))
         setbitrate(DEFAULT_BITRATE);

      if (!settotalTime(totalTime))
         settotalTime(DEFAULT_PLAYTIME);

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
      if (strVal.length() > MIN_STR_LENGTH && strVal.length() <= MAX_STR_LENGTH)
         return true;
      else 
         return false;
   }

   public boolean setartist(String artist)
   {
      if (validateString(artist))
      {
         this.artist = artist;
         return true;
      }
      else 
         return false;
   }

   public boolean setbitrate(int bitrate)
   {
      if (validateNumber(bitrate, MIN_BITRATE, MAX_BITRATE))
      {
         this.bitrate = bitrate;
         return true;
      }
      else 
         return false;
   }

   private boolean validateNumber(int num, int min, int max)
   {
      if (num >= min && num <= max)
         return true;
      else 
         return false;
   }

   public boolean settotalTime(int totalTime)
   {
      if (validateNumber(totalTime, MIN_PLAYTIME, MAX_PLAYTIME))
      {
         this.totalTime = totalTime;
         return true;
      }
      else 
         return false;
   }

   // accessor (get) methods
   public String getname()
   {
      return name;
   }
   public String getartist()
   {
      return artist;
   }
   public int getbitrate()
   {
      return bitrate;
   }  

   public int gettotalTime()
   {
      return totalTime;
   }  

   //Display 
   public void display()
   {
      //display iTunes object
      System.out.println( "\n"+ artist +", " + name + ", "+ totalTime/1000 + " seconds, " + bitrate + "k bits per second \n");

   }

}

