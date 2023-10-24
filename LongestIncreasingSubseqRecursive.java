import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LongestIncreasingSubseqRecursive {

    static int incrSubseqRecursive(int[] A, int j) {
        // If j is 0, the longest increasing subsequence is 1.
        if (j == 0) {
            return 1;
        }

        // Store the maximum length of increasing subsequence ending at index j.
        int maxLength = 1;

        // Loop from 0 to j-1 to find previous elements that can be concatenated
        // with A[j] to form an increasing subsequence.
        for (int i = 0; i < j; i++) {

            // Ensure that the current element is less than A[j] to maintain an increasing
            // order.
            if (A[i] < A[j]) {
                // Get the length of the longest increasing subsequence
                // ending at index i and add 1.
                int currLength = incrSubseqRecursive(A, i) + 1;

                // Update maxLength if the new length is larger.
                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength; // Return maxLength
    }

    public static void main(String[] args) {
        String filePath = "testcase8.txt"; // Replace with the path to your text file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Read the line from the file
            if (line != null) {
                // Split the line by commas and store the values in an array
                String[] numberStrings = line.split(",");
                int[] numbers = new int[numberStrings.length];

                for (int i = 0; i < numberStrings.length; i++) {
                    try {
                        numbers[i] = Integer.parseInt(numberStrings[i]);
                    } catch (NumberFormatException e) {
                        // Handle the case where a value is not a valid integer
                        System.err.println("Invalid integer: " + numberStrings[i]);
                    }
                }
                //numbers
                
                long startTime = System.currentTimeMillis();
                int result = 0;
                for (int i = 0; i < numbers.length; i++) {
                    result = Math.max(result, incrSubseqRecursive(numbers, i));
                }
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
                System.out.println(result);
    

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
