import java.util.Scanner;

public class DoubleKnapsackWithSolution {
     public static void main (String [] args){
        //Main method recieving inputs and calling our hopscoptch method
        Scanner s = new Scanner(System.in);
        String arrleninfo = s.nextLine();
        String[] parts = arrleninfo.split(" ");
        int n = Integer.parseInt(parts[0]);
        int knapsize1 = Integer.parseInt(parts[1]);
        int knapsize2 = Integer.parseInt(parts[2]);
        int[] weight = new int[n];
        int[] cost = new int[n];
        //One loop to create the weight and cost arrays
        for (int i = 0; i < n ; i++) {
            //getting inputs from knapsack
            String inputt = s.nextLine();
            String[] inputsplit = inputt.split(" ");
            int wei = Integer.parseInt(inputsplit[0]);
            int cos = Integer.parseInt(inputsplit[1]);
            weight[i] = wei;
            cost[i] = cos;
        }
        //initialize dp array for knapsack
        int[][][] dp = new int[n + 1][knapsize1 + 1][knapsize2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int w1 = 0; w1 <= knapsize1; w1++) {
                for (int w2 = 0; w2 <= knapsize2; w2++) {
                    //main logic that looks at what to include and what to include in second as it traverses
                    int exclude = dp[i - 1][w1][w2];
                    int includeInFirst = (w1 >= weight[i - 1]) ? dp[i - 1][w1 - weight[i - 1]][w2] + cost[i - 1] : 0; 
                    int includeInSecond = (w2 >= weight[i - 1]) ? dp[i - 1][w1][w2 - weight[i - 1]] + cost[i - 1] : 0;
                    if (includeInFirst > exclude) {
                        dp[i][w1][w2] = includeInFirst;
                    } else {
                        dp[i][w1][w2] = exclude;
                    }
                    
                    if (includeInSecond > dp[i][w1][w2]) {
                        dp[i][w1][w2] = includeInSecond;
                    }
                }
            }
        }
        
        int maxCost = dp[n][knapsize1][knapsize2];
        System.out.println(maxCost);
        int w1 = knapsize1, w2 = knapsize2;
        int[] firstBackpackItems = new int[n];
        int[] secondBackpackItems = new int[n];
        int firstCount = 0, secondCount = 0;
        for (int i = n; i > 0; i--) {
            if (dp[i][w1][w2] != dp[i - 1][w1][w2]) {
                if (w1 >= weight[i - 1]) {
                    firstBackpackItems[firstCount++] = i;
                    w1 -= weight[i - 1];
                } else {
                    secondBackpackItems[secondCount++] = i;
                    w2 -= weight[i - 1];
                }
            }
        }
        //printing out the two knapsack items
        for (int i = 0; i < firstCount; i++) {
            System.out.print(firstBackpackItems[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < secondCount; i++) {
            System.out.print(secondBackpackItems[i] + " ");
        }
    }
}
