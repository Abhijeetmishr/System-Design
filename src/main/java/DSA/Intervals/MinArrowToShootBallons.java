package DSA.Intervals;

public class MinArrowToShootBallons {
    /*
        Input: points = [[10,16],[2,8],[1,6],[7,12]]
        Output: 2
        Explanation: The balloons can be burst by 2 arrows:
        - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
        - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
    */
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        // Sort the points based on the end coordinate
        java.util.Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1; // At least one arrow is needed
        int end = points[0][1]; // End of the first balloon
        
        for(int i = 1; i < points.length; i++){
            // If the start of the current balloon is greater than the end of the last balloon
            if(points[i][0] > end){
                arrows++; // Need a new arrow
                end = points[i][1]; // Update the end to the current balloon's end
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points)); // Output: 2
    }
}