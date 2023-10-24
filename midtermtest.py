def count_pairs_with_sum_at_least_t(arr, t):
    arr.sort()  # Step 1: Sort the array in O(n log n) time.
    left, right = 0, len(arr) - 1
    count = 0

    while left < right:
        current_sum = arr[left] + arr[right]

        if current_sum >= t:
            count += right - left  # Count pairs with sum >= t.
            right -= 1  # Move right pointer to the left.
        else:
            left += 1  # Move left pointer to the right.

    return count

# Example usage:
arr = [2, 6,3,7,1,4]
t = 9 
result = count_pairs_with_sum_at_least_t(arr, t)
print(result) 