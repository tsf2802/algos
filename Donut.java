import java.util.Scanner;

public class Donut {
    public static int partition(int arr[], int low, int high) { 
        //partition takes into account the left & right index values
        //follows nico lomuto partitioning logic
        int temp;
        int pivot = arr[high]; 
        int i = (low - 1); 
        for (int j = low; j <= high - 1; j++) { 
            if (arr[j] <= pivot) { 
                i++; 
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } 
        } 
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1); 
    } 

    public static int select(int a[], int left,int right, int k) { 
        //IMPLEMENTAITON OF QUICKSELECT ALGORITHM
        while (left <= right) { 
            //IDENTIFYIGN PARTITION
            int pivot = partition(a, left, right);
            //Logic given partition from other method 
            if (pivot == k - 1) 
                return a[pivot]; 
            else if (pivot > k - 1) 
                right = pivot - 1; 
            else
                left = pivot + 1; 
        } 
        return -1; 
    } 
    public static void findbest(int[] xs, int[] ys){
        int x = select(xs, 0, xs.length-1,  xs.length/2+1);
        int y = select(ys, 0, ys.length-1, ys.length/2+1);
        int count = 0;
        int total = 0;
        //FINAL MATH DONE IN ORDER TO FIND TOTAL DISTANCE
        while(count<xs.length){
            total += Math.abs(x - xs[count]);
            total += Math.abs(y - ys[count]);
            count ++;
        }

        System.out.println(total);
    }
    public static void main(String[] args) {
        //RECIEVING INPUT 
        Scanner input = new Scanner(System.in);
        int inputsize = Integer.parseInt(input.nextLine());
        int[] xvals = new int[inputsize];
        int[] yvals = new int[inputsize];
        for (int i =0; i <inputsize;i++){
            String []lineinput = (input.nextLine()).split(" ");
            xvals[i]=Integer.parseInt(lineinput[0]);
            yvals[i]=Integer.parseInt(lineinput[1]);
        }
        /* 
        TEST CASES
        int [] x = {0,2,7,4,3,1,6};
        int [] y = {2,7,5,5,1,1,3};

        int  [] x1= {1,4,9,10,8,2,0,3,6,5,1,3};
        int [] y1 = {8,9,9,5,1,0,6,7,6,2,3,4};
        */
        findbest(xvals,yvals);
    }
    
    
}
