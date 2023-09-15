import java.util.Scanner;

public class Planters {
    public static void main(String[] args) {

        class MergeSort {
            // mergesort class that can be used in the main method as a object
            // time complexity is o(log(n)) because of divide and conquer
            void merge(int arr[], int left, int mid, int right) {
                // getting subar size
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
                        i++;
                    } else {
                        arr[k] = R[j];
                        j++;
                    }
                    k++;
                }
                // add any leftover values from left & right
                while (i < side1) {
                    arr[k] = L[i];
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

        // inputs from stdin line 1
        Scanner s = new Scanner(System.in);
        String testval = s.nextLine();
        String[] parts = testval.split(" ");
        // inputs from stdin line 2
        String unavStr = s.nextLine();
        String[] arrstr = unavStr.split(" ");
        int[] arr = new int[arrstr.length];
        for (int i = 0; i < arrstr.length; i++) {
            arr[i] = Integer.parseInt(arrstr[i]);
        }
        // inputs from stdin line 3
        String avalStr = s.nextLine();
        String[] arr2str = avalStr.split(" ");
        int[] arr2 = new int[arr2str.length];
        for (int i = 0; i < arr2str.length; i++) {
            arr2[i] = Integer.parseInt(arr2str[i]);
        }

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }
        ob.sort(arr2, 0, arr2.length - 1);
        boolean possible = true;

        // loop that goes through each plant item to replace
        for (int item = 0; item < arr.length; item++) {
            int target = arr[item];
            int left = 0;
            int right = arr2.length - 1;
            int closest = Integer.MAX_VALUE; // Initialize closest with a large value
            int closestIndex = 0;
            // a binary search implementation of o(log(n)) that searches
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr2[mid] == target) {
                    // If the exact match is found, move to the right half of the array.
                    left = mid + 1;
                } else if (arr2[mid] < target) {
                    left = mid + 1; // Adjust left boundary
                } else {
                    closest = arr2[mid]; // Update closest value
                    closestIndex = mid;
                    right = mid - 1; // Adjust right boundary
                }
            }
            if (closest == Integer.MAX_VALUE) {
                possible = false;
                break;
            } else {
                int tempval = arr[item];
                arr[item] = closest;
                arr2[closestIndex] = tempval;
                ob.sort(arr2, 0, arr2.length - 1);
            }
        }
        // final output
        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // helper method to print out array for debugging purposes
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
