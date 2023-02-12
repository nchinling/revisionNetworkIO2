package sg.edu.nus.iss.app.server;

import java.util.Arrays;
import java.util.Collections;

public class NumSortCollections {
    
    public static int[] getNumSortCollections(String data){
        
      
        // String[] numbers = data.split(" ");
        // String str = String.join("", numbers);
        // return str;
        String[] numbers = data.split(" ");
        int[] arrayNumbers = new int[5];
            for (int i = 0; i < numbers.length; i++ ) {
                arrayNumbers[i] = Integer.parseInt(numbers[i]);
            }
        
             // For descending. copy to wrapper array
            // Integer[] wrapperArrayNumbers = new Integer[arrayNumbers.length];
            // for (int i = 0; i < arrayNumbers.length; i++) {
            //     wrapperArrayNumbers[i] = arrayNumbers[i];
            //  }
            // Arrays.sort(wrapperArrayNumbers, Collections.reverseOrder());
            
            //Sort in ascending order
            Arrays.sort(arrayNumbers);


 
            // Printing sorted array elements
            // System.out.print(arrayNumbers[i] + " ");
        
        return arrayNumbers;
    }
}
