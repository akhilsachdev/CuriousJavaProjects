//Akhil Sachdev : Pseudo Solids

public class PseudoSolids
{
   public static void main(String[] args)
   {     
      //declare & Instantiate point object
      Point point1 = new Point();

      point1.displayPoint();

      //declare & Instantiate point object with Parameters

      Point point3 = new Point(10.5f, 11.6f, 12.7f);
      point3.displayPoint();

      Point point4 = new Point(8.3f, -7.2f, 6.1f);
      point4.displayPoint();

      Point point5 = new Point(-5.9f, 4.8f, 3.7f);
      point5.displayPoint();

      // set new range - min and max val
      if (!Point.setRange(15f, -15f))
         System.out.println("Min Val shd be greater than Max Val - Min Val: " + Float.toString(15f) + " Max Val: " + Float.toString(-15f));

      if (!Point.setRange(-20f, 20f))
         System.out.println("Min Val shd be greater than Max Val - Min Val: " + Float.toString(15f) + " Max Val: " + Float.toString(-15f));

      System.out.println("New Min Val: " + Float.toString(-20f) + " New Max Val: " + Float.toString(20f));

      Point point2 = new Point(12.1f, 12.2f, 12.3f);
      point2.displayPoint();

      point2.setPoint(1, 10, 11);
      point2.displayPoint();


      // First Solid
      float[] xArray1 =  {1, 2, 3, 4, 5, 6, 7, 8};
      float[] yArray1 =  {10, 20, 30, 40, 50, 60, 70, 80};
      float[] zArray1 =  {11, 22, 33, 44, 55, 66, 77, 88};

      Solid solid1 = new Solid(8, xArray1, yArray1, zArray1);
      solid1.showSolid();

      //Second Solid 

      float[] xArray2 =  {1.9f, 2, 5.7f, 7, 9, 1.1f};
      float[] yArray2 =  {2, 3.8f, 6, 8, 9, 10};
      float[] zArray2 =  {3, 4, 7, 9.9f, 8, 12};

      // set invalid numPoints > Max Points
      Solid solid2 = new Solid(55, xArray2, yArray2, zArray2);
      //Valid numPoints
      solid2.setPoints(3, xArray2, yArray2, zArray2);
      solid2.showSolid();


      // Third Solid
      float[] xArray3 =  {5.4f, 3.1f, 5.9f};
      float[] yArray3 =  {9, 2.2f, 6.6f};
      float[] zArray3 =  {8, 4.1f, 7.3f};

      Solid solid3 = new Solid();
      solid3.setPoints(3, xArray3, yArray3, zArray3);
      solid3.showSolid();

   }

}

// Point Class
class Point
{
   // members 
   private float x;
   private float y;
   private float z;

   public static float MIN_VAL = -10f;
   public static float MAX_VAL = +10f;

   // Default values
   public static float DEFAULT_COORDINATES = (MIN_VAL + MAX_VAL) / 2f;

   // constructor that sets the default values
   public Point()
   {
      x = DEFAULT_COORDINATES;
      y = DEFAULT_COORDINATES;
      z = DEFAULT_COORDINATES;

   }  

   // constructor that takes parameter values
   public Point(float x, float y, float z)
   {
      if (!setPoint(x, y, z) )
      {
         this.x = DEFAULT_COORDINATES;
         this.y = DEFAULT_COORDINATES;
         this.z = DEFAULT_COORDINATES;
      }
   }  


   // mutator (set) methods
   public boolean setPoint(float x, float y, float z)
   {
      if ((validateCoord(x, MIN_VAL, MAX_VAL)) && 
            (validateCoord(y, MIN_VAL, MAX_VAL)) &&
            (validateCoord(z, MIN_VAL, MAX_VAL)) )
      {
         this.x = x;
         this.y = y;
         this.z = z;
         return true;
      }
      else
      {
         return false;
      }
   }

   public boolean setx(float x)
   {
      if (validateCoord(x, MIN_VAL, MAX_VAL))
      {
         this.x = x;
         return true;
      }
      else 
         return false;
   }

   public boolean sety(float y)
   {
      if (validateCoord(y, MIN_VAL, MAX_VAL))
      {
         this.y = y;
         return true;
      }
      else 
         return false;
   }

   public boolean setz(float z)
   {
      if (validateCoord(z, MIN_VAL, MAX_VAL))
      {
         this.z = z;
         return true;
      }
      else 
         return false;
   }

   // validate coordinate
   private boolean validateCoord(float num, float min, float max)
   {
      if (num >= min && num <= max)
         return true;
      else 
         return false;
   }

   // accessor (get) methods

   public float getx() { return x; } 
   public float gety() { return y; } 
   public float getz() { return z; } 

   // Format String using x,y,z coordinates
   public String toStringPoint()
   {
      String strpoint;
      strpoint = "(" + Float.toString(this.x) + ", " + Float.toString(this.y) + ", " + Float.toString(this.z) + ")";
      return strpoint;
   }  

   //display point 
   public void displayPoint()
   {
      System.out.println("Point: " + toStringPoint());
   }   

   // Static Class Methods - set min and max val
   static public boolean setRange(float newMinVal, float newMaxVal)
   {

      if (newMinVal >= newMaxVal)
         return false;
      else
      {
         MIN_VAL = newMinVal;
         MAX_VAL = newMaxVal;
         return true;
      }

   }

}

//Solid Class
class Solid
{
   // members 
   private int numPoints;
   private Point[] solidPoints;

   //this variable tracks how many points are being added to this solid; 
   private int currentPointer;

   //Default values
   public static final int MAX_POINTS = 50;

   public static final int NUM_DEFAULT = 0;


   // constructor that sets the default values
   public Solid()
   {
      numPoints = NUM_DEFAULT;
      currentPointer = NUM_DEFAULT - 1;
      solidPoints = new Point[MAX_POINTS];

   }  

   // constructor that takes parameter values
   public Solid(int numPoints, float[] x, float[] y, float[] z)
   {
      if (setnumPoints(numPoints))
      {
         solidPoints = new Point[numPoints];
         currentPointer = NUM_DEFAULT - 1;
         for (int i=0; i < numPoints; i++)
         {
            this.addPoint(x[i], y[i], z[i]);
         }
      }
      else
      {
         System.out.print("Number of Points for Solid (" + numPoints  + ") is greater than the MAX Points (50)");
      }

   }  

   // mutator (set) method

   //Set numPoints for a Solid
   public boolean setnumPoints(int numPoints)
   {
      if (validNumPoints(numPoints))
      {
         this.numPoints = numPoints;
         return true;
      }
      else
      {
         return false;
      }
   }

   //validate numPoints < Max points 
   private boolean validNumPoints(int numPoints)
   {

      if (numPoints <= MAX_POINTS )
         return true;
      else 
         return false;
   }

   // Rebuilds the Solid with new parameters
   public boolean setPoints(int numPoints, float[] x, float[] y, float[] z)
   {
      if (!setnumPoints(numPoints))
      {
         System.out.print("Number of Points for Solid (" + numPoints  + ") is greater than the MAX Points (50)\n");
         return false;
      }
      else
      {
         solidPoints = new Point[numPoints];
         currentPointer = NUM_DEFAULT - 1;

         if (validArraylength(x.length, y.length, z.length))
         {

            for (int i=0; i < this.numPoints; i++)
            {
               if (!this.addPoint(x[i], y[i], z[i]))
               {
                  return false;
               }
            }
            return true;
         }
         else
         {
            return false;
         }
      }
   } 

   // validate x, y, z, array length
   private boolean validArraylength(int len1, int len2, int len3)
   {
      if (len1 < numPoints && len2 <numPoints && len3 < numPoints)
         return false;
      else
         return true;

   }

   // Add point adds a point to the Points array and track the current pointer for the solid
   public boolean addPoint(float x, float y, float z)
   {
      if (validcurrentPointer())
      {
         currentPointer++;

         solidPoints[currentPointer] = new Point();
         solidPoints[currentPointer].setPoint(x, y, z);
         return true;
      }
      else
      {
         return false;
      }
   }

   // validate current Pointer of the solid when adding points
   private boolean validcurrentPointer()
   {
      if (currentPointer < numPoints)
         return true;
      else 
         return false;
   }


   // accessor (get) methods

   public int getnumPoints() { return numPoints; } 
   public Point[] getPoints() { return solidPoints; } 

   // Format String using all the Points for this solid
   public String toStringSolid()
   {
      String strSolid = "";

      for (int i=0; i < numPoints; i++)
      {
         strSolid = strSolid + "point" +  i + solidPoints[i].toStringPoint();
      }

      return strSolid;
   }  

   //display Solid 
   public void showSolid()
   {
      System.out.println("\nSolid: " + toStringSolid() + "\n");
   }   


}


