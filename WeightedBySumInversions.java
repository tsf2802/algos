import java.util.Scanner;
public class WeightedBySumInversions {
    public static void main (String []args){
        class MergeSort {

            public long total;
            public MergeSort(){
                //constructor that keeps track of the total
                total = 0;
            }
            public void getTotal(){
                System.out.println(this.total);
            }
        // mergesort class that can be used in the main method as a object
        // time complexity is o(log(n)) because of divide and conquer
            void merge(int arr[], int left, int mid, int right) {
                // getting subar size
                //System.out.println("Currently at left: "+left +", mid: "+mid+" ,right: "+right);
                int side1 = mid - left + 1;
                int side2 = right - mid;
                int L[] = new int[side1];
                int R[] = new int[side2];
                // add array items from arr with indexes
                for (int i = 0; i < side1; ++i)
                    L[i] = arr[left + i];
                for (int j = 0; j < side2; ++j)
                    R[j] = arr[mid + 1 + j];
                // index pointers
                int i = 0;
                int j = 0;
                int k = left;
                // main merging logic that uses index to access original array and manipulates
                // current array from low to high
                while (i < side1 && j < side2) {
                    // if left item is smaller than right, replace left ptr item with smaller value
                    if (L[i] <= R[j]) {
                        arr[k] = L[i];
                        int temp = 0;
                        //logic that adds to total due to number comparison
                        while (R[temp]< L[i]){
                            //System.out.print("adding ");
                            this.total+= L[i]+R[temp];
                            //System.out.println("temp: "+temp+"| comparing "+L[i]+" and "+R[temp]);
                            temp +=1;
                        }
                        i++;
                        
                    } else {
                        arr[k] = R[j];
                        j++;
                    }
                    k++;
                }
                
                //logic that adds to total due to number comparison, but for overflow values
                while (i < side1) {
                    arr[k] = L[i];
                    int temp = 0;
                    while (temp < side2){
                        
                        if (L[i] > R[temp]){
                            //System.out.print("adding ");
                            this.total+= L[i]+R[temp];
                        }else{
                            break;
                        }
                        //System.out.println("temp: "+temp+"| comparing "+L[i]+" and "+R[temp]);
                        temp +=1;
                    }
                    i++;
                    k++;
                    
                }
                while (j < side2) {
                    arr[k] = R[j];
                    j++;
                    k++;
                }
            }

            // sort method which is called
            void sort(int arr[], int l, int r) {
                if (l < r) {
                    int m = (l + r) / 2;
                    // recursive calls until base cases where l=r equal each other
                    sort(arr, l, m);
                    sort(arr, m + 1, r);
                    merge(arr, l, m, r);
                    
                }
                
            }
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
            MergeSort ob = new MergeSort();
            ob.sort(arr, 0, arr.length - 1);
            ob.getTotal();
            /* 
            for (int i =0; i< arr.length;i++){
                System.out.print(arr[i]+ " ");
            }
            */
            
        }
    }   
}
