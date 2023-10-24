import java.util.Scanner;

public class testing {

    public static int[] parition(int[] A, int start, int end){
        int[] newArray = new int[end-start];
        int count = 0;
        while(start<end){
            newArray[count] = A[start];
            count++;
            start++;
        }
        return newArray;

    }

    public static int select(int[] nums, int k){
        if(nums.length<=5){
            return nums[k];
        }
        double length = nums.length;
        int numOfArrays = (int)java.lang.Math.ceil(length/5);
        int[] medians = new int[numOfArrays];
        int medianIndex = 0;

        int count = 0;
        int[] replace = new int[5];
        for(int i = 0; i<nums.length ; i++){
            int e = nums[i];
            replace[count] = e;
            count ++;
            if(count == 5){
                int med = select(replace, replace.length/2);
                medians[medianIndex] = med;
                medianIndex++;
                count = 0;
            }else if(i == nums.length-1 && count != 0){   //end of the array
                int[] smallArray = parition(replace, 0, count);
                int med = select(smallArray, smallArray.length/2);
                medians[medianIndex] = med;
            }
        }

        int medianB = select(medians, medians.length/2);
        //make new array
        int start = 0;
        int end = nums.length-1;
        int[] newArray = new int[nums.length];


        for(int i = 0; i<nums.length ; i++){
            int currInt = nums[i];
            if(currInt < medianB){
                newArray[start] = currInt;
                start++;
            }else if(currInt > medianB){
                newArray[end] = currInt;
                end --;
            }
        }
        int j;

        if(k<start){
            j = start;
            return select(parition(newArray, 0, j), k);
        }else if(end<k){
            j = end;
            return select(parition(newArray, j, newArray.length), k-j);
        }else{
            return medianB;
        }

    }

    public static void calculate(int[] xs, int[] ys){
        int x = select(xs, xs.length/2); 
        int y = select(ys, ys.length/2);
        System.out.println(" Selected: "+x +", "+y);
        int count = 0;
        int total = 0;
        while(count<xs.length){
            total += Math.abs(x - xs[count]);
            total += Math.abs(y - ys[count]);
            count ++;
        }

        System.out.println(total);
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int bubbleSortAndMedian(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return arr[arr.length/2];
    }
    public static void main(String[] args) {
        /* 
        Scanner input = new Scanner(System.in);
        String line1 = input.nextLine();
        int[] x = new int[Integer.parseInt(line1)];
        int[] y = new int[Integer.parseInt(line1)];

        int count = 0;
        int totalx = 0;
        int totaly = 0;

        while(count<x.length){
            line1 = input.nextLine();
            String[] coordinates = line1.split(" ");
            int xCoor = Integer.parseInt(coordinates[0]);
            int yCoor = Integer.parseInt(coordinates[1]);

            x[count] = xCoor;
            y[count] = yCoor;

            totalx += xCoor;
            totaly += yCoor;

            count++;
        }
        */
        int [] x = {0,2,7,4,3,1,6};
        int [] y = {2,7,5,5,1,1,3};
        int  [] x1= {1,4,9,10,8,2,0,3,6,5,1,3};
        int [] y1 = {8,9,9,5,1,0,6,7,6,2,3,4};
        calculate(x, y);
        calculate(x1, y1);

    }
}
