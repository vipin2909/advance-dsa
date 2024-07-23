package arrays1;

public class RainWaterTrapped {
    public int trap(int[] A) {
        int n = A.length, result = 0;
        int leftIndex = 0, rightIndex = n-1, leftMax = 0, rightMax = 0;
        while(leftIndex <= rightIndex) {
            if(leftMax <= rightMax) {
                result += Math.max(leftMax - A[leftIndex], 0);
                leftMax = Math.max(leftMax, A[leftIndex]);
                leftIndex += 1;
            }
            else {
                result += Math.max(rightMax - A[rightIndex], 0);
                rightMax = Math.max(rightMax, A[rightIndex]);
                rightIndex -= 1;
            }
        }
        return result;
    }
}
