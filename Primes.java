import java.util.Scanner;
public class Primes {
    public static void main (String [] args){
        //recieving input
        Scanner s = new Scanner(System.in);
        int testval = s.nextInt();
        retPrimes(testval);
        s.close();
    }

    public static void retPrimes(int input){
        /*
         * Following the Sieve of Eratosthenes 
         * Initialize the array first.
         */
        boolean [] allNums = new boolean[input+1];
        int index = 0;
        // Set array with all true with the intention of changing multiples to false
        while (index != allNums.length){
            allNums[index] = true;
            index = index+1;
        }
        //First loop goes from 2 - n, where n goes until n*n exceeds the target size
        for ( int outer  = 2; outer*outer<=allNums.length; outer++ ){
                // this second loop flips the multiples of each outer loop to false
                for (int mult = outer*outer; mult < allNums.length; mult+= outer)
                    allNums[mult] = false;
        }
        for (int i=2; i < allNums.length; i++){
            if (allNums[i] == true)
                System.out.println(i);
        }
        //return allNums;
        
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
