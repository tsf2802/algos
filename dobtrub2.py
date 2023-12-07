def is_valid_move(maze, x, y):
    # Check if the move is within the bounds and not colliding with a wall
    return 0 <= x < len(maze) and 0 <= y < len(maze[0]) and maze[x][y] != 'x'

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

    while queue:
        print(queue)
        pos1, pos2, steps = queue.pop(0)
        
        
        visited.add((pos1, pos2))

        if pos1 == 0 or pos2 == 0 or pos1 == rows - 1 or pos2 == cols - 1:
            return steps
        moves= [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for i in moves:

            new_pos1 = (pos1[0] + i[0], pos1[1] + i[1])
            new_pos2 = (pos2[0] + i[0], pos2[1] + i[1])
            print(new_pos1) 
            print(new_pos2)
            if (new_pos1, new_pos2) in visited:
                continue

            if new_pos1 < 0 or new_pos1 >= rows or new_pos2 < 0 or new_pos2 >= cols:
                continue

            if maze[new_pos1][new_pos2] == 'x':
                continue

            queue.append((new_pos1, new_pos2, steps + 1))

    return -1

maze = [
    "x..xxx.x",
    ".2..1..x",
    "xx.xxxxx"
]

answer = find_exit(maze)
print(answer)
