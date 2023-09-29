import java.util.Scanner;

public class testing {

    static long totalInversions = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arrSize = Integer.parseInt(s.nextLine());
        String[] inputs = s.nextLine().split(" ");
        if (arrSize <= 1) {
            System.out.println(0);
        } else {
            int[] arr = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }
            mergeSort(arr, 0, arr.length - 1);
            System.out.println(totalInversions);
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                totalInversions += (long) (mid - i + 1) * arr[j];
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }
}
