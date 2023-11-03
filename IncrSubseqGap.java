import java.util.Scanner;

public class IncrSubseqGap {
    public static void main (String [] args){
        
        Scanner s = new Scanner(System.in);
        String arrsize = s.nextLine();
        String[] twoparts = arrsize.split(" ");
        int fullarrsize =  Integer.parseInt(twoparts[0]);// INPUT SIZE 
        int acceptGap = Integer.parseInt(twoparts[1]); // ACCEPTABLE GAP SIZE

        String inputs = s.nextLine();
        String[] sizeparts = inputs.split(" ");
        int[] arr = new int[fullarrsize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sizeparts[i]);
        } 
        dpSolution(arr, acceptGap);
         /* 
        int []fakeinput = {6 ,17, 5, 9, 14, 13, 17, 14, 6, 7, 11, 2, 14, 11, 10, 15, 4, 2, 2, 16};
        int fakegap = 5;
        
*/
    
    
    }
    private static void dpSolution(int[]input, int gap) {
        int [] DParr = new int [input.length];
        DParr[0] = input[0];
        for (int i =0; i < input.length;i++){
            DParr[i] = input[i];
            for (int j= 0; j < i; j++){
                if (input[i] >input[j] && i-j <= gap){
                    if (DParr[i]>= (input[i]+DParr[j])){
                        DParr[i] = DParr[i];
                    }else{
                        DParr[i] = input[i]+DParr[j];
                    }
                }
            }
        }
        int max =0;
        for (int i = 0; i < DParr.length; i++) {
            if (DParr[i] > max){
                max = DParr[i];
            }
        } 
        System.out.println(max);
    }
    
}
