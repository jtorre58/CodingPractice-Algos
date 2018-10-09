public class EulerProb1{
   public static void main(String [] args){
      EulerProb1 prob = new EulerProb1();
      int sum = prob.findSum(3,5);   // Finds sum of multiples under 1,000
      System.out.print("Sum of multiples under 1,000 for 3 and 5 is: " + sum);
   }
   public static int findSum(int x, int y){
   int sum = 0;
   
   for(int i = 0; i < 1000; i++){
      if(i % x == 0){
         sum += i;
      }
      else if(i % y == 0){
         sum += i;
      }
   }
   return sum;
   }
}