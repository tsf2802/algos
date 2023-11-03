def hopscotch_largest_sum(a):
    n = len(a)
    dp = [0] * n
    path = [-1] * n  # Initialize path array with -1.

    dp[0] = a[0]

    for i in range(1, n):
        jump_2 = dp[i - 2] + a[i] if i >= 2 else 0
        jump_3 = dp[i - 3] + a[i] if i >= 3 else 0
        print("i value: "+ str(i)+", jump_2:" + str(jump_2) +" ,jump_3: "+ str(jump_3))
        if jump_2 >= jump_3:
            dp[i] = jump_2
            path[i] = 2
        else:
            dp[i] = jump_3
            path[i] = 3
        print("dp:" + str(dp) +" ,path: "+ str(path)+ " \n")
    # Reconstruct the jump sequence.
    jump_sequence = []
    i = n - 1
    while i >= 0:
        if path[i] == 2:
            jump_sequence.append(a[i])
            i -= 2
        elif path[i] == 3:
            jump_sequence.append(a[i])
            i -= 3
        else:
            break

    return dp[n - 1], jump_sequence[::-1]  # Return the largest sum and the jump sequence in reverse order.

# Example usage:
input_sequence = [1, 5, 2, 6, 3, 1, 8]
largest_sum, jump_sequence = hopscotch_largest_sum(input_sequence)
print("Largest Sum:", largest_sum)
print("Jump Sequence:", jump_sequence)
