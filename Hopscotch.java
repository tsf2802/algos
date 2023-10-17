import java.util.Scanner;

public class Hopscotch {
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        String arrlen = s.nextLine();
        String valuearr = s.nextLine();
        int arrlenint = Integer.parseInt(arrlen);
        String[] parts = valuearr.split(" ");

        int[] arr = new int[arrlenint];
        for (int i = 0; i < arrlenint ; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        
        hopscot(arr, arrlenint);
    }

    private static void hopscot(int[] arr, int arlen) {
        int[] dp = new int[arlen];
        for (int i = 0; i < arlen ; i++) {
            dp[i] = 0;
        }
        int[] path = new int[arlen];
        for (int i = 0; i < arlen ; i++) {
            path[i] = -1;
        }
        dp[0] = arr[0];

        for ( int it = 1; it < arlen; it++){
            int j2 = 0;
            int j3 = 0;
            if (it >= 2){
                j2 = dp[it - 2] + arr[it];
            }
            if (it >=3){
                j3 = dp[it - 3] + arr[it]; 
            }
            if (j2 >= j3) {
                dp[it] = j2;
                path[it] = 2;
            }else{
                dp[it] = j3;
                path[it] = 3;
            }
        }
        int largest = 0;
        for (int i = 0; i < arlen ; i++) {
            if (dp[i] > largest){
                largest = dp[i];
            }
        }
        System.out.println(largest);

    }
    
}
