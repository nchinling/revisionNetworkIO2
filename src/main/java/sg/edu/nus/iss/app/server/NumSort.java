package sg.edu.nus.iss.app.server;

public class NumSort {
    
    public static int[] getNumSort(String data){
        
      
        // String[] numbers = data.split(" ");
        // String str = String.join("", numbers);
        // return str;
        String[] numbers = data.split(" ");
        int[] arrayNumbers = new int[5];
            for (int i = 0; i < numbers.length; i++ ) {
                arrayNumbers[i] = Integer.parseInt(numbers[i]);
            }

         // Outer loop
         for (int i = 0; i < arrayNumbers.length; i++) {
 
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arrayNumbers.length; j++) {
 
                // Checking elements. '>': descending, Change to '<' for ascending
                int temp = 0;
                if (arrayNumbers[j] > arrayNumbers[i]) {
 
                    // Swapping
                    temp = arrayNumbers[i];
                    arrayNumbers[i] = arrayNumbers[j];
                    arrayNumbers[j] = temp;
                }
            }
 
            // Printing sorted array elements
            System.out.print(arrayNumbers[i] + " ");
        }
   
        return arrayNumbers;
    }
}
