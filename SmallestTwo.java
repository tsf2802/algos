import java.util.Scanner;

public class SmallestTwo {
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        int testval = s.nextInt();
        //Initializing the two return integer, fsmall for first smallest, ssmall for second
        int fsmall = 10000;
        int ssmall = 10000;
        for (int i = 0; i<testval; i++){
            //retarr keeps track of changes in each iteration
            int [] retarr = {fsmall,ssmall};
            int input = s.nextInt();
            if (fsmall >= 10000 && ssmall >= 10000){
                //runs at the beginning to set the smallest value
                retarr[0] = input;
            }else{
                //after one number at first smallest, two conditions shift left or right
                if (input<fsmall){
                    int temp = retarr[0];
                    retarr[0] = input;
                    retarr[1] = temp;
                }else{
                    //this takes care of when input is larger than smallest but smaller than second smallest.
                    //also makes sure to skip the duplicate of first small
                    if (input< ssmall && input!= fsmall){
                        retarr[1] = input;
                    }
                }
            }
            //updates the original fsmall and ssmall 
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
