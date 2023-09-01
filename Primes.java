
public class Primes {
    public static void main (String [] args){
        //input size
        int input = 10000;
        
        boolean newlist [] = retPrimes(input);
        for (int i=2; i < newlist.length; i++){
            if (newlist[i] == true)
                System.out.println(i);
        }
    }
    
    public static boolean[] retPrimes(int input){
        /*
         * Following the Sieve of Eratosthenes 
         */
        // Initialize the array 
        boolean [] allNums = new boolean[input+1];
        int index = 0;
        // Set array with all true with the intention of changing multiples to false
        while (index != allNums.length){
            allNums[index] = true;
            index = index+1;
        }
        //First loop goes from 2 - n, where n goes until n*n exceeds the target size
        for ( int outer  = 2; outer*outer<=allNums.length; outer++ ){
            if (allNums[outer] == true){
                // this second loop flips the multiples of each outer loop to false
                for (int mult = outer*outer; mult < allNums.length; mult+= outer)
                    allNums[mult] = false;
            }
        }
        return allNums;
        
    }
    /* 
    public static int[] addTList(int adding, int arr[]){
        
         // Method creates a new array (original+1) size to add all items
         // and new item to the end of the array. Unused method for previous approach
         
        int newarr []  = new int[arr.length + 1];
        for (int i =0; i< arr.length; i++){
            newarr[i] = arr[i];
        }
        newarr[arr.length] = adding;
        return newarr;
    }
    */
}
