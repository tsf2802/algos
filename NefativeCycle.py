def has_negative_cycle(graph):
    n = len(graph)
    dist = [[float('inf')] * n for _ in range(n)]
    print(dist)
    # Initialize dist array
    for u, v, weight in graph:
        dist[u - 1][v - 1] = weight
    print(dist)

    # Floyd-Warshall algorithm
    for k in range(n-1):
        for i in range(n):
            for j in range(n):
                
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
                print(f"{dist[i][j]} vs {dist[i][k] + dist[k][j]}, {dist[i][j]} chosen")
                print(dist)

    # Check for negative-weight cycle
    for i in range(n):
        if dist[i][i] < 0:
            return True

    return False

# Example input
graph_input = [
    (1, 2, 3),
    (2, 3, 5),
    (3, 4, -10),
    (4, 1, 1),
    (4, 3, 20),
]

# Check if the graph contains a negative-weight cycle
result = has_negative_cycle(graph_input)

if result:
    print("The graph contains a negative-weight cycle.")
else:
    print("The graph does not contain a negative-weight cycle.")
