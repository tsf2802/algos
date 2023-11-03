def find_matching_indices(A, B):
    A.sort()  # Sort array A
    B.sort()  # Sort array B
    matching_indices = []

    i, j = 0, 0

    while i < len(A) and j < len(B):
        if A[i] == B[j]:
            matching_indices.append((i, j))
            i += 1
            j += 1
        elif A[i] < B[j]:
            i += 1
        else:
            j += 1

    return matching_indices

A = [1, 7, 9, 2]
B = [7.4, 8, 7]

matching_indices = find_matching_indices(A, B)
print(matching_indices) 