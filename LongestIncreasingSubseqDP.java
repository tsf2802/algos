import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LongestIncreasingSubseqDP {

    // Definition of the Node class to create a linked list.
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Function to calculate the maximum length of the increasing subsequence.
    static int incrSubseqDP(Node head, int n) {
        
        // The initial node for storing subsequence lengths.
        Node dpHead = new Node(1);
        Node currDP = dpHead;
        
        // Initializing the linked list to store subsequence lengths.
        for (int i = 1; i < n; i++) {
            currDP.next = new Node(1);
            currDP = currDP.next;
        }

        int maxOverallLength = 1; // Store the maximum length found.

        // Outer loop node (jNode) and corresponding DP value (jDPNode).
        Node jNode = head.next;
        Node jDPNode = dpHead.next;

        // Looping through every node starting from the second one.
        while (jNode != null) {
            
            // Nodes for inner loop traversal (iNode and iDPNode).
            Node iNode = head;
            Node iDPNode = dpHead;
            
            // Inner loop: traverse all previous elements to find the
            // longest subsequence ending in jNode.
            while (iNode != jNode) {
                // Only consider iNode if it is less than jNode.
                if (iNode.value < jNode.value) {
                    // Update the length of the longest subsequence ending in jNode.
                    jDPNode.value = Math.max(jDPNode.value, iDPNode.value + 1);
                }
                
                // Move to the next nodes in the sequence and DP list.
                iNode = iNode.next;
                iDPNode = iDPNode.next;
            }
            
            // Update maxOverallLength if we found a longer subsequence.
            maxOverallLength = Math.max(maxOverallLength, jDPNode.value);

            // Move to the next nodes in the sequence and DP list.
            jNode = jNode.next;
            jDPNode = jDPNode.next;
        }
        
        // Return the overall maximum length found.
        return maxOverallLength;
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
                Node head = new Node(numbers[0]);
                Node current = head;
                for (int i = 1; i < numbers.length; i++) {
                    current.next = new Node(numbers[i]);
                    current = current.next;
                }
                System.out.println(incrSubseqDP(head, numbers.length));

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
