import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinearSearch
{
   public static List<Integer> findIndexes(int[] nums, final int TARGET)
   {
      List<Integer> indexesOfTarget = new ArrayList<>();
      for (int i = 0; i < nums.length; i++)
      {
         if (nums[i] == TARGET)
         {
            indexesOfTarget.add(i);
         }
      }
      return indexesOfTarget;
   }

   private static int[] getRandomArray(int size, int bound)
   {
      int[] nums = new int[size];
      Random ran = new Random();

      for (int i = 0; i < size; i++)
      {
         nums[i] = ran.nextInt(bound);
      }
      return nums;
   }

   public static void main(String[] args)
   {
      final int TARGET = 5;

      final int SIZEOFARRAY = 75;
      final int HIGHBOUND = 15;

      int[] nums= getRandomArray(SIZEOFARRAY, HIGHBOUND);

      List<Integer> locations = findIndexes(nums, TARGET);
      ArrayPrintUtils.printArray(nums);
      System.out.println();
      System.out.println("Value " + TARGET + "found at indexes: ");
      for (int i : locations)
      {
         System.out.println(i + " ");
      }
   }
}
