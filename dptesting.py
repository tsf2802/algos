def find_largest_sum(arr,pp):
    n = len(arr)
    dp = [0] * n  # Initialize an array to store the maximum sums at each index

    for i in range(n):
        print("i: "+str(i))
        print(dp)
        dp[i] = arr[i]  # Initialize with the value at the current index

        for j in range(i):
            print("    j: "+str(j)+" w/ if "+str(arr[i])+" > "+str(arr[j]) + " and "+ str(i)+" - "+str(j)+" <= "+str(pp))
            if arr[i] > arr[j] and i - j <= pp:
                dp[i] = max(dp[i], arr[i] + dp[j])
                print("        True! dp[i] chooses "+ str(dp[i]))
        print(dp)
        print()
    # Find the maximum sum in the dp array
    print("final:")
    print(dp)
    max_sum = max(dp)

    return max_sum
arr = [8,1,7,10,2,3,4,5]
p=1
largest_sum = find_largest_sum(arr, p)
print(largest_sum)
"""
arr = [6,17, 5, 9,14 ,13 ,17, 14, 6,7 ,11 ,2 ,14 ,11 ,10 ,15, 4, 2, 2,16 ]
p=5
largest_sum = find_largest_sum(arr, p)
print(largest_sum)"""