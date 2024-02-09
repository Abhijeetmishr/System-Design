package DSA.Array.BinarySearch;

/**
 * You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n*m-1;

        while(low <= high){
            int mid = (low + high)/2;

            if(matrix[mid/m][mid%m] == target){
                return true;
            } else if(matrix[mid/m][mid%m] < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}
