import java.util.Scanner;

public class IncrSubseqGap {
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        String arrsize = s.nextLine();
        String[] twoparts = arrsize.split(" ");
        int fullarrsize =  Integer.parseInt(twoparts[0]); 
        int acceptGap = Integer.parseInt(twoparts[1]);

        String inputs = s.nextLine();
        String[] sizeparts = inputs.split(" ");
        int[] arr = new int[Integer.parseInt(arrsize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sizeparts[i]);
        } 
        Scanner s = new Scanner(System.in);
        String arrsize = s.nextLine();
        String inputs = s.nextLine();
        if (Integer.parseInt(arrsize) <= 1){
            System.out.println(0);
        }else{
            String[] parts = inputs.split(" ");
            int[] arr = new int[Integer.parseInt(arrsize)];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
        
    }
}
