import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyListWithoutLibraries {
    public static void main(String[] args) {
        // Assuming the input is provided as a String
        String input = "92 16\n50 42\n82 11\n30 3\n62 60\n65 71\n51 98\n95 81\n15 79\n35 48\n89 35\n34 42\n77 58\n38 3\n" +
                "30 56\n7 73\n23 56\n14 4\n66 95\n58 79\n54 23\n49 56\n72 96\n88 86\n74 23\n85 14\n9 19\n7 85\n76 45\n" +
                "40 57\n52 46\n29 74\n53 94\n78 70\n88 35\n48 93\n9 96\n48 80\n43 36\n17 68\n10 2\n81 18\n72 40\n3 99\n" +
                "84 94\n55 87\n91 35\n60 43\n28 37\n12 67\n24 59\n59 84\n6 6\n16 49\n93 32\n16 2\n85 49\n20 8\n88 74\n" +
                "6 23\n9 9\n46 20\n51 73\n9 14\n91 32\n24 49\n67 29\n7 82\n29 99\n14 97\n1 50\n97 72\n58 84\n45 63\n" +
                "58 63\n27 18\n71 72\n37 73\n97 45\n86 87\n28 9\n36 95\n89 42\n28 18\n40 41\n66 92\n43 62\n63 100\n" +
                "45 59\n14 54\n21 40\n23 43\n12 59\n67 8\n56 52\n46 35\n12 81\n81 1\n74 9\n70 66";

        // Split the input into lines
        String[] lines = input.split("\n");

        // Number of vertices and edges
        int n = 100; // Assuming there are 100 vertices
        int m = lines.length; // Number of edges

        // Initialize the adjacency list
        int[][] adjList = new int[n + 1][];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new int[0];
        }

        // Build the adjacency list
        for (String line : lines) {
            String[] vertices = line.split(" ");
            int vertex1 = Integer.parseInt(vertices[0]);
            int vertex2 = Integer.parseInt(vertices[1]);

            addEdge(adjList, vertex1, vertex2);
            addEdge(adjList, vertex2, vertex1);
        }

        // Print the adjacency list
        for (int i = 1; i <= n; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < adjList[i].length; j++) {
                System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }
        int largestConnectedPairs = findLargestConnectedPairs(adjList);
        System.out.println(n-largestConnectedPairs);

    }

    public static void addEdge(int[][] adjacencyList, int vertex, int value) {
        int[] oldArray = adjacencyList[vertex];
        int[] newArray = new int[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[newArray.length - 1] = value;
        adjacencyList[vertex] = newArray;
    }

    static int findLargestConnectedPairs(int[][] graph) {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        int maxConnectedPairs = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                int connectedPairs = bfs(graph, i, visited);
                maxConnectedPairs = Math.max(maxConnectedPairs, connectedPairs);
            }
        }

        return maxConnectedPairs;
    }

    static int bfs(int[][] graph, int start, boolean[] visited) {
        int connectedPairs = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            connectedPairs++;

            for (int neighbor : graph[currentVertex]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return connectedPairs / 2; // Divide by 2 because each pair is counted twice (A-B and B-A)
    }
}
