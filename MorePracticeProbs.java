import java.util.Arrays;
public class MorePracticeProbs{
   public static void main(String[] args){
      MorePracticeProbs c = new MorePracticeProbs();
      int [] a1 = {1,2,4,5,6,7,8,9}; // one missing number
      int [] a2 = {1,2,3,4,5,6,7,8}; //two missing numbers
      int [] a3 = {1,4,4,6,8,4,10}; // three missing numbers;
      System.out.println("The missing number in array: " +  Arrays.toString(a1) + " is " + c.calcNum(a1, a1.length+1));
      System.out.println("The second highest number in array in array: " + Arrays.toString(a1) + " is " + c.secondHighest(a1));
      System.out.println(Arrays.toString(c.eraseDuplicates(a3)));
      System.out.println("The smallest and largest numbers in array: " + Arrays.toString(a3) + "are " + Arrays.toString( c.findSmallLarge(a3)));
      c.findPairs(a2,10);
   }
   //Calculates missing number given an array
   int calcNum(int [] array, int size){
      int missing = 0;
      int expectedSum = (size*(size+1))/2;
      int actualSum = 0;
      for(int i =0;i < array.length; i++){
         actualSum += array[i];
      }
      missing = expectedSum - actualSum;
      return missing;
   }
   
   //finds second highest number in an array
   int secondHighest(int[] array){
      int first = 0; int second = 0;
      for(int i = 0; i < array.length; i++){
         if(array[i] > first){
            second = first;
            first = array[i];
         }
      }
      return second;
   }
   //Erases all duplicates found in an array without using Java API collections
   //possible improvement could be analyzing all non duplicate size
   //and return an array without all the zeroes
   int [] eraseDuplicates(int [] array){
      int [] noDup = new int [array.length];
      int c1 = 0; int c2 = 0;
      Arrays.sort(array);//key to only having to check the next index vs scanning entire array
      System.out.println(Arrays.toString(array)); 
      for(int i = 0; i < array.length;i++){
         c2 = array[i];
         if(c2 != c1){
            noDup[i]=c2;
         }
         c1 = c2;
         
      }
      return noDup;
   }
   
   //finds smallest and largest numbers in an array
   int [] findSmallLarge(int [] array){
      int smallest = 0; int largest = 0;
      int [] smallLarge = new int [2]; //0 index will contain smallest, 1 index will contain largest
      smallest = array[0];
      largest = array[0];
      for(int i =0; i < array.length; i++){
         if(smallest > array[i]){
            smallest = array[i];
         }
         if(largest < array[i]){
            largest = array[i];
         }
      }
      smallLarge[0] = smallest;
      smallLarge[1] = largest;
      return smallLarge;
   }
   
   //Given a target sum, find all pairs that add up to target sum
   void findPairs(int [] array, int sum){
      int [] pairs = new int [2];
      int pair = 0;int pair1 =0;
      int remainder = 0;
      System.out.println("Pairs for target sum are: ");
      for(int i = 0; i < array.length; i++){
        pair = array[i];
        remainder = sum - pair;
        for(int j = 0; j < array.length; j++){
         if(pair == array[j]){
            continue; // we want distinct pairs only
         }
         if(array[j] == remainder){
            System.out.println("[ " + pair + ", " + array[j] + "]");
            continue;
         }
        }
        
      }
   }
}