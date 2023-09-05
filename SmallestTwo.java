import java.util.Scanner;

public class SmallestTwo {
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        int testval = s.nextInt();
        //System.out.println("Testval"+testval);
        int fsmall = 10000;
        int ssmall = 10000;
        for (int i = 0; i<testval; i++){
            int [] retarr = {fsmall,ssmall};
            int input = s.nextInt();
            //System.out.println("input "+input);
            if (fsmall >= 10000 && ssmall >= 10000){
                //inital set
                retarr[0] = input;
            }else{
                //after one number at first smallest, two conditions shift left or right
                if (input<fsmall){
                    int temp = retarr[0];
                    retarr[0] = input;
                    retarr[1] = temp;
                }else{
                    if (input< ssmall && input!= fsmall){
                        retarr[1] = input;
                    }
                }
            }
            fsmall = retarr[0];
            ssmall = retarr[1];
        }
        System.out.println(fsmall);
        System.out.println(ssmall);
    }

        /* 
        System.out.println("array: ");
        for( int k = 0; k< retarr.length; k++){
            System.out.print(retarr[k]+",");
        }
        System.out.println("");
        */

}
