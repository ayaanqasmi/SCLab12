package recursion;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    /**
     * Performs a recursive binary search to find the index of a target integer in a sorted array.
     *
     * @param arr   the sorted array of integers to search
     * @param target the integer value to find
     * @param left  the starting index of the current search range
     * @param right the ending index of the current search range
     * @return the index of the target if found, or -1 if the target is not in the array
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        // Base case: range is empty or invalid input
        if (arr == null || arr.length == 0 || left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right); // Search the right half
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1); // Search the left half
        }
    }

    /**
     * Performs a recursive binary search to find the index of a target string in a sorted array.
     *
     * @param arr   the sorted array of strings to search
     * @param target the string value to find
     * @param left  the starting index of the current search range
     * @param right the ending index of the current search range
     * @return the index of the target if found, or -1 if the target is not in the array
     */
    public static int binarySearchRecursive(String[] arr, String target, int left, int right) {
        // Base case: range is empty or invalid input
        if (arr == null || arr.length == 0 || left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int comparison = target.compareTo(arr[mid]); // Compare strings lexicographically

        if (comparison == 0) {
            return mid; // Target found
        } else if (comparison > 0) {
            return binarySearchRecursive(arr, target, mid + 1, right); // Search the right half
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1); // Search the left half
        }
    }

    /**
     * Finds all indices of a target integer in a sorted array using recursion.
     *
     * @param arr   the sorted array of integers to search
     * @param target the integer value to find
     * @param left  the starting index of the current search range
     * @param right the ending index of the current search range
     * @return a list of all indices where the target is found, or an empty list if not found
     */
    public static List<Integer> binarySearchAllIndices(int[] arr, int target, int left, int right) {
        // Base case: range is empty or invalid input
        if (arr == null || arr.length == 0 || left > right) {
            return new ArrayList<>();
        }

        int mid = left + (right - left) / 2;
        List<Integer> indices = new ArrayList<>();

        if (arr[mid] == target) {
            indices.add(mid); // Add the current index to the result

            // Search both sides for duplicates
            indices.addAll(binarySearchAllIndices(arr, target, left, mid - 1));
            indices.addAll(binarySearchAllIndices(arr, target, mid + 1, right));
        } else if (arr[mid] < target) {
            indices.addAll(binarySearchAllIndices(arr, target, mid + 1, right)); // Search the right half
        } else {
            indices.addAll(binarySearchAllIndices(arr, target, left, mid - 1)); // Search the left half
        }

        return indices;
    }

    /**
     * Helper method to perform binary search on integers with simplified parameters.
     *
     * @param arr   the sorted array of integers to search
     * @param target the integer value to find
     * @return the index of the target if found, or -1 if the target is not in the array
     */
    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    /**
     * Helper method to perform binary search on strings with simplified parameters.
     *
     * @param arr   the sorted array of strings to search
     * @param target the string value to find
     * @return the index of the target if found, or -1 if the target is not in the array
     */
    public static int binarySearch(String[] arr, String target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    /**
     * Helper method to find all indices of a target integer with simplified parameters.
     *
     * @param arr   the sorted array of integers to search
     * @param target the integer value to find
     * @return a list of all indices where the target is found, or an empty list if not found
     */
    public static List<Integer> binarySearchAllIndices(int[] arr, int target) {
        return binarySearchAllIndices(arr, target, 0, arr.length - 1);
    }
}
