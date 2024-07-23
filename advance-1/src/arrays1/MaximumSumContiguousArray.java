package arrays1;

public class MaximumSumContiguousArray {
    public int maxSubArray(int[] arr) {
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for(int ele: arr) {
            sum = Math.max(sum+ele, ele);
            best = Math.max(sum, best);
        }
        return best;
    }
}
