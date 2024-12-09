package recursion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchIntegers() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, BinarySearch.binarySearch(arr, 3));
        assertEquals(-1, BinarySearch.binarySearch(arr, 6));
    }

    @Test
    public void testBinarySearchStrings() {
        String[] arr = {"apple", "banana", "cherry", "date"};
        assertEquals(1, BinarySearch.binarySearch(arr, "banana"));
        assertEquals(-1, BinarySearch.binarySearch(arr, "fig"));
    }

    @Test
    public void testBinarySearchAllIndices() {
        int[] arr = {1, 2, 2, 3, 4, 5};
        List<Integer> indices = BinarySearch.binarySearchAllIndices(arr, 2);
        assertEquals(List.of(2, 1), indices);
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};
        assertEquals(-1, BinarySearch.binarySearch(emptyArray, 3));
       
      
    }
}