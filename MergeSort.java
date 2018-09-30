public class MergeSort{
   public static void main(String [] args){
      int [] array =  {1,10,2,9,3,8,4,7,5,6};
      int l = 0;
      int r = array.length -1;
      int m = (l + r)/2;
      MergeSort ob = new MergeSort();
      ob.printArray(array);
         ob.sort(array, l, r);
      ob.printArray(array);
   }
   //Implements actual mergesort algorithm
   //assure left is always less than right
   //recursively break down array into halves
   void sort(int[] array, int l, int r){
      if(l < r){
         int m = (l + r) / 2;
         sort(array, l, m);
         sort(array,m+1, r);
         merge(array, l,m,r);
      }  
   }
   
   //implements merging of two halves
   void merge(int[]array,int l, int m, int r){
      int sizeL = m-l+1;
      int sizeR = r-m; 
      
      int[] temp = new int[sizeL];
      int[] temp2 = new int[sizeR];
      
      for(int i = 0; i < sizeL; i++ ){
         temp[i] = array[l+i];
      }
      for(int j = 0; j < sizeR; j++){
         temp2[j] = array[m+1+j];
      }
      
      int counter1 = 0;
      int counter2 = 0;
      int counter3 = l;
      
      while( (counter1 < sizeL) && (counter2 < sizeR)){
         if(temp[counter1] <= temp2[counter2] ){
            array[counter3] = temp[counter1];
            counter1++;
            
         }
         else{
            array[counter3] = temp2[counter2];
            counter2++;
            
         }
         counter3++;
      }//all elements have been compared all that is left to do is to move remaining elements from either array
      
      while(counter1 < sizeL){
         array[counter3] = temp[counter1];
         counter1++;
         counter3++;
      }
      
      while(counter2 < sizeR){
         array[counter3]= temp2[counter2];
         counter2++;
         counter3++;
      }
   }
   
  void printArray(int[] array){
   int length = array.length;
   for(int i = 0; i < length; i++){
      System.out.print(array[i] +  "\t");
   }
   System.out.println();
  }
}