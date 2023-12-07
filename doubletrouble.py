
#take into account each thing,then generate what next position is if they go each way and if its a valid move add them to queue while queue is not empty keep doing that and if you ever find a position they can finish at the same time its good. 
#bfs but all configuration routes, keep track how long it takes, position in queue

def is_valid_move(maze, x, y, other):
    # Check if the move is within the bounds and not colliding with a wall
    #return 1 if wall, return 2 if valid, return 3 is exits
    
        if (0 <= x < len(maze) and 0 <= y < len(maze[0]) and maze[x][y] == 'x'):
            return 1
        if 0 <= x < len(maze) and 0 <= y < len(maze[0]):
            return 2
        else:
            return 3
    #return 0 <= x < len(maze) and 0 <= y < len(maze[0]) and maze[x][y] != 'x'
def find_exit(maze):
    rows = len(maze)
    cols = len(maze[0])

    start_positions = []
    for i in range(rows):
        for j in range(cols):
            if maze[i][j] == '2':
                start_positions.append((i, j))
            elif maze[i][j] == '1':
                start_positions.append((i, j))

    queue = [(start_positions[0], start_positions[1], 0)]
    visited = set()

    while queue and len(queue)< 10000000:
        print(len(queue))
        pos1, pos2, steps = queue.pop(0)
        
        # Convert positions to tuples
        pos1 = tuple(pos1)
        pos2 = tuple(pos2)
        visited.add((pos1, pos2))
        if (pos1[0] == 0 and pos2[0] == 0) or (pos1[0] == rows - 1 and pos2[0] == rows - 1) or (pos1[1] == 0 and pos2[1] == 0) or (pos1[1] == cols - 1 and pos2[1] == cols - 1):
            
            return steps

        moves = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for move in moves:
            new_pos1 = (pos1[0] + move[0], pos1[1] + move[1])
            new_pos2 = (pos2[0] + move[0], pos2[1] + move[1])
            if (new_pos1, new_pos2) in visited: # basically so that it doesnt backpedal from the previous move it came from
                continue
            else:
                
                if ((is_valid_move(maze, new_pos1[0], new_pos1[1], new_pos2)==2) and (is_valid_move(maze, new_pos2[0], new_pos2[1], new_pos1)==2)):
                    
                    queue.append((new_pos1, new_pos2, steps + 1))
                elif((is_valid_move(maze, new_pos1[0], new_pos1[1], new_pos2)==2) and (is_valid_move(maze, new_pos2[0], new_pos2[1], new_pos1) == 1)):
                    if new_pos1!= pos2:
                        queue.append((new_pos1, pos2, steps + 1))  
                elif ((is_valid_move(maze, new_pos1[0], new_pos1[1], new_pos2)== 1) and (is_valid_move(maze, new_pos2[0], new_pos2[1], new_pos1)==2) ):
                    if pos1 != new_pos2:
                        queue.append((pos1, new_pos2, steps + 1))
                    
                elif((is_valid_move(maze, new_pos1[0], new_pos1[1], new_pos2)==2) and (is_valid_move(maze, new_pos2[0], new_pos2[1], new_pos1) == 3)):
                    continue
                elif ((is_valid_move(maze, new_pos1[0], new_pos1[1], new_pos2)== 3) and (is_valid_move(maze, new_pos2[0], new_pos2[1], new_pos1)==2) ):
                    continue
    return -1

maze = [
    "xxxxxx.x",
    "2...1..x",
    "xx.xxxxx"
]

answer = find_exit(maze)
if answer == -1: 
    print("STUCK")
else:
    print(answer+1)


                    