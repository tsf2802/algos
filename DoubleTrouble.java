import java.util.Scanner;

public class DoubleTrouble {
    public static void main (String []args){
        /* 
        Some test cases 
        String[][] maze1 = {
            {"x", "x", "x", "x", "x", "x", ".", "x"},
            {"2", ".", ".", ".", "1", ".", ".", "x"},
            {"x", "x", ".", "x", "x", "x", "x", "x"}
        };
        
        // Example 2
        String[][] maze2 = {
            {"x", ".", ".", "x", "x", "x", ".", "x"},
            {".", "2", ".", ".", "1", ".", ".", "x"},
            {"x", "x", ".", "x", "x", "x", "x", "x"}
        };
        */
        Scanner s = new Scanner(System.in);
        String inputnm = s.nextLine();
        String[] partsnm = inputnm.split(" ");
        int n = Integer.parseInt(partsnm[0]); //intput size (by lines)
        int m = Integer.parseInt(partsnm[1]); //size of each line
        String[][] maze = new String[n][];
        for (int i = 0; i < n; i++) {
            String eachline = s.nextLine();
            String[] indivline= eachline.split("");
            maze[i] = indivline;
        }
        int answer = -1;
        try{
            answer  = findExit(maze);
        }catch(Exception e){
            answer = -1;
        }      
        if (answer == -1){
            System.out.println("STUCK");
         } else{
            System.out.println(answer+1);
         }
    }

    private static int is_valid_move(String[][] maze, int x, int y) {
        // Check if the move is within the bounds and not colliding with a wall
        //return 1 if wall, return 2 if valid, return 3 is exits
        if ((0 <= x && x < maze.length) && (0 <= y && y < maze[0].length) && maze[x][y].equals("x")) {
            return 1;
        }
        if ((0 <= x && x < maze.length) && (0 <= y && y < maze[0].length)) {
            return 2;
        } else {
            return 3;
        }
    }

    private static int findExit(String[][] maze) {
        //initially searches for the two starting locations to add into a bfs.
        //keeps track of [firstcoord,secondcoord,step]
        int rows = maze.length;
        int cols = maze[0].length;
        int[] start1 = null;
        int[] start2 = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j].equals("2")) {
                    start1 = new int[]{i, j};
                } else if (maze[i][j].equals("1")) {
                    start2 = new int[]{i, j};
                }
            }
        }
        //queue implementation that is used for bfs
        String[][] queue = new String[10000][3];
        //set implementation with anotehr class called arrayset 
        //visited keeps track of duplicates so that the algorithm doesnt backpedal
        ArraySet visited = new ArraySet();
        
        int front = 0, rear = 0;
        queue[rear][0] = convertToString(start1); //[1,1]
        queue[rear][1] = convertToString(start2);
        queue[rear][2] = "0";
        rear++;
         
        while (front < rear && rear < 10000) {

            String [] pos1 = queue[front][0].split(","); //for example ["1","1"]
            String [] pos2 = queue[front][1].split(","); //for example ["1","4"]
            int steps = Integer.parseInt(queue[front][2]);
            String [] adddeclare={queue[front][0],queue[front][1]};
            visited.add(adddeclare);
            front++;
            int pos1x = Integer.parseInt(pos1[0]);
            int pos1y = Integer.parseInt(pos1[1]);
            int pos2x = Integer.parseInt(pos2[0]);
            int pos2y = Integer.parseInt(pos2[1]);
            int [] pos1declaration = {pos1x, pos1y};
            int [] pos2declaration = {pos2x, pos2y};
            if ((pos1x == 0 && pos2x == 0) ||(pos1x == rows-1 && pos2x == rows-1) || (pos1y == 0 && pos2y == 0) || (pos1y == cols-1 && pos2y == cols-1)  ) {
                return steps;
            }

            int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int[] move : moves) {
                int new_pos1_x = pos1x+move[0];
                int new_pos1_y = pos1y+move[1];
                int new_pos2_x = pos2x+move[0];
                int new_pos2_y = pos2y+move[1];
                int [] newpos1declaration = {new_pos1_x, new_pos1_y};
                int [] newpos2declaration = {new_pos2_x, new_pos2_y};
                String [] posdeclare={convertToString(newpos1declaration),convertToString(newpos2declaration)};
                int validMove1 = is_valid_move(maze, new_pos1_x, new_pos1_y);
                int validMove2 = is_valid_move(maze, new_pos2_x, new_pos2_y);
                //main logic that deals with if to add items into queue or not
                if (!(visited.contains(posdeclare))){
                    if (validMove1 == 2 && validMove2 == 2) {
                        queue[rear][0] = convertToString(newpos1declaration); //[1,1]
                        queue[rear][1] = convertToString(newpos2declaration);
                        queue[rear][2] = steps +1 +"";
                        rear++;
                    } else if (validMove1 == 2 && validMove2 == 1) {
                        if (areArraysEqual(newpos1declaration, pos2declaration)== false){
                            queue[rear][0] = convertToString(newpos1declaration); //[1,1]
                            queue[rear][1] = convertToString(pos2declaration);
                            queue[rear][2] = steps +1 +"";
                            rear++;
                        }
                    } else if (validMove1 == 1 && validMove2 == 2) {
                       if (areArraysEqual(pos1declaration, newpos2declaration)== false){
                            queue[rear][0] = convertToString(pos1declaration); //[1,1]
                            queue[rear][1] = convertToString(newpos2declaration);
                            queue[rear][2] = steps +1 +"";
                            rear++;
                        }
                    } else if (validMove1 == 2 && validMove2 == 3) {
                        continue;
                    } else if (validMove1 == 3 && validMove2 == 2) {
                        continue;
                    } 
                }
            }
        }
        return -1;
    }
    //helper methods to deal with string and integer conversions
    public static String convertToString(int[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        String result = Integer.toString(array[0]);

        for (int i = 1; i < array.length; i++) {
            result += "," + Integer.toString(array[i]);
        }
        return result;
    }
    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
    
}
