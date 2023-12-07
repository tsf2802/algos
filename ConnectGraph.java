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
        //function exists to modify the array size by +1 and 
        int[] oldArray = adjacencyList[vertex];
        int[] newArray = new int[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[newArray.length - 1] = value;
        adjacencyList[vertex] = newArray;
    }
    public static int countIndividualGraphs(int[][] adjList) {
        //function calls the dfs method when vetrex is unvisited. Does this until all vertices in boolean are true
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
    private static void dfs(int startVertex, int[][] adjList, boolean[] visited) {
        //dfs that takes in the parameters the adjacencyList (resembling the graph)
        //a boolean array to keep track of unvisited/visited nodes
        //startVertex identifies the inital node that the DFS should ran on.
        int numVertices = adjList.length;
        int[] stack = new int[numVertices];
        int stackSize = 0;
        //stack keeps track of items that needs to be explored. follows standard DFS implementation
        stack[stackSize++] = startVertex;
        while (stackSize > 0) {
            int vertex = stack[--stackSize];
            if (!visited[vertex]) {
                visited[vertex] = true;
                for (int neighbor : adjList[vertex]) {
                    if (!visited[neighbor]) {
                        if (stackSize == stack.length) {
                            int[] newStack = new int[stack.length * 2];
                            for (int i = 0; i < stack.length; i++) {
                                newStack[i] = stack[i];
                            }
                            stack = newStack;
                        }
                        stack[stackSize++] = neighbor;
                    }
                }
            }
        }
    }
}
