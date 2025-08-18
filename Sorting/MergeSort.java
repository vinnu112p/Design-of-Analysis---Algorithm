
class MergeSort {

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;  // Left array
        int j = mid + 1;  // Right array
        int k = 0;  // Temp array

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }

    }

    public static void mergesort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 1, 4, 9, 8, 7};
        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergesort(arr, 0, arr.length - 1);
        System.out.println("");

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}


// Step-by-Step: How Your Merge Sort Code Works
// Main Method

// Initializes an array: {6, 3, 1, 4, 9, 8, 7}
// Prints the original array.
// Calls mergesort(arr, 0, arr.length - 1) to sort the array.
// Prints the sorted array.
// mergesort(arr, si, ei)

// Base Case: If si >= ei, returns (subarray has 0 or 1 element).
// Divide: Finds the middle index: mid = si + (ei - si) / 2.
// Recursion: Recursively sorts the left half (si to mid) and right half (mid+1 to ei).
// Conquer: Calls merge(arr, si, mid, ei) to merge the two sorted halves.
// merge(arr, si, mid, ei)

// Creates a temporary array to hold merged elements.
// Uses two pointers (i for left, j for right) to compare and copy the smaller element to temp.
// Copies any remaining elements from the left or right subarray to temp.
// Copies merged elements from temp back to the original array (arr).

// Summary of Flow
// Recursively split the array until each subarray has one element.
// Merge sorted subarrays step by step, building up to the full sorted array.
// Prints the array before and after sorting.

// Key Points to Remember
// Uses extra space for merging (temp array).
// Time complexity: O(n log n).
// Stable sort (preserves order of equal elements).
// Handles all cases (already sorted, reverse sorted, random).
