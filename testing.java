import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConnectGraph {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputnm = s.nextLine();
        String[] partsnm = inputnm.split(" ");
        int n = Integer.parseInt(partsnm[0]); //Num of verticies
        int m = Integer.parseInt(partsnm[1]); //num of edges (connections between verticies)
        int[][] adjlist = new int[n][];
        for (int i = 0; i < n; i++) {
            adjlist[i] = new int[0];
        }
        for (int j =0; j<m; j++){
            String eachnm = s.nextLine();
            String[] splitnm = eachnm.split(" ");
            int first = Integer.parseInt(splitnm[0])-1; //Num of verticies
            int sec = Integer.parseInt(splitnm[1])-1; //num of edges (connections between verticies)
            addEdge(adjlist, first, sec);
            addEdge(adjlist, sec, first);
        }
        int count = 0;
        for (int i = 0; i < adjlist.length; i++) {
            if (adjlist[i].length<1){
                count = count+1;
            }
        }
        s.close();
        System.out.println(countIndividualGraphs(adjlist)-1);
    
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
    public static int countIndividualGraphs(int[][] adjList) {
        int numVertices = adjList.length;
        boolean[] visited = new boolean[numVertices];
        int numGraphs = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                dfs(vertex, adjList, visited);
                numGraphs++;
            }
        }
        return numGraphs;
    }

    private static void dfs(int vertex, int[][] adjList, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
