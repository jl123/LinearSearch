import java.util.*;
import java.util.stream.Collectors;

//takes user input and finds instances of that value in array and ArrayList
// with random values

public class LinearSearch
{

   //traverses array provided and returns ArrayList of all indexes where
   // target int is found
   public static List<Integer> findIndexes(int[] nums, final int TARGET)
         throws TargetNotFoundException
   {
      List<Integer> indexesOfTarget = new ArrayList<>();

      for (int i = 0; i < nums.length; i++)
      {
         if (nums[i] == TARGET)
         {
            indexesOfTarget.add(i);
         }
      }
      if (indexesOfTarget.size() == 0)
      {
         throw new TargetNotFoundException("No instances of "
               + TARGET + " found.");
      }
      return indexesOfTarget;
   }

   public static List<Integer> findIndexes(List<Integer> nums, final int TARGET)
         throws TargetNotFoundException
   {
      int[] listAsArray = nums.stream().mapToInt(x -> x).toArray();
      return findIndexes(listAsArray, TARGET);
   }

   //produces & returns array of size and high bound value provided
   private static int[] getRandomArray(final int SIZE, final int BOUND)
   {
      int[] nums = new int[SIZE];
      Random ran = new Random();

      for (int i = 0; i < SIZE; i++)
      {
         nums[i] = ran.nextInt(BOUND ) + 1;
      }
      return nums;
   }

   private static List<Integer> getRandomArrayList(final int SIZE, final int BOUND)
   {
      return new Random()
            .ints(SIZE,1,BOUND + 1)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
   }

   public static void main(String[] args)
   {
      final int SIZE_OF_ARRAY = 75;
      final int HIGH_BOUND = 15;

      int target = Integer.MIN_VALUE;
      int inputCounter = 0;

      List<Integer>  locations;

      int[] nums = getRandomArray(SIZE_OF_ARRAY, HIGH_BOUND);
      Scanner scanner = new Scanner(System.in);

      List<Integer> numsList= getRandomArrayList(SIZE_OF_ARRAY, HIGH_BOUND);

      do
      {
         inputCounter++;
         if (inputCounter > 1)
         {
            System.out.print("Invalid input. ");
         }
         System.out.println(
               "Enter an integer to be found between 1 and "
               + HIGH_BOUND + ".");
         try
         {
            target = Integer.parseInt(scanner.nextLine());
         }
         catch (NumberFormatException e)
         {
            System.out.println(e.getMessage());
         }
      }while (target < 1 || target > HIGH_BOUND );

      //array test
      try
      {
         locations = findIndexes(nums, target);
         ArrayPrintUtils.printArray(nums);
         System.out.println();
         System.out.println("Value " + target + " found in random array "
               + locations.size() + " times at indexes: ");
         locations.forEach(loc ->
         {
            System.out.print(loc);
            System.out.print(" ");
         });
         System.out.println();
      }
      catch (TargetNotFoundException e)
      {
         System.out.println(e.getMessage());
      }

      //arrayList test
      try
      {
         locations = findIndexes(numsList, target);
         ArrayPrintUtils.printArray(nums);
         System.out.println();
         System.out.println("Value " + target + " found in random List "
               + locations.size() + " times at indexes: ");
         locations.forEach(loc ->
         {
            System.out.print(loc);
            System.out.print(" ");
         });
         System.out.println();
      }
      catch (TargetNotFoundException e)
      {
         System.out.println(e.getMessage());
      }
   }
}

class TargetNotFoundException extends Exception
{
   TargetNotFoundException(String message)
   {
      super(message);
   }
}