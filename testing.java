public class testing {
    public static void main (String [] args){
        int [] arr = {1,2,3,4,7};
        int target = 5;
        int left = 0;
        int right = arr.length - 1;
        int closest = Integer.MAX_VALUE; // Initialize closest with a large value
        int closestIndex = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                // If the exact match is found, move to the right half of the array.
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1; // Adjust left boundary
            } else {
                closest = arr[mid]; // Update closest value
                closestIndex = mid;
                right = mid - 1; // Adjust right boundary
            }
        }
        if (closest == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        }else{
            System.out.println("Possible");
            System.out.println(closest);
            System.out.println(closestIndex);
        }
    }
    
}
