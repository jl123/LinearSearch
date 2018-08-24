class ArrayPrintUtils<T>
{
   public static void printArray(int[] values)
   {

         System.out.println("-----------------------------------------" +
               "----------------------------------------");
      for (int  i = 0; i < values.length; i++)
      {
         System.out.print("|  " + values[i] + getBuffer(values[i]));
         if (i % 9 == 8)
         {
            System.out.println("|");
            System.out.println("-----------------------------------------" +
                  "----------------------------------------");

         }
      }
      System.out.println("|");
   }

   private static String getBuffer(int i)
   {
      String buffer;
      if (i < 10){buffer = "     ";}
      else if (i < 100){buffer = "    ";}
      else if (i < 1000){buffer = "   ";}
      else if (i < 10000){buffer = "  ";}
      else {buffer = " ";}

      return buffer;
   }
}