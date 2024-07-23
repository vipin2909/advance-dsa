package arrays2;

public class MinimumSwaps {
    public int solve(int[] A, int B) {
        int count = 0;
        for(int ele: A) {
            if(ele <= B) count += 1;
        }
        int largeElementCount = 0;
        for(int i = 0; i < count; i++) {
            if(A[i] > B) largeElementCount += 1;
        }

        int res = largeElementCount;
        for(int i = 0, j = count; j < A.length ; i++, j++) {
            if(A[i] > B) largeElementCount -= 1;
            if(A[j] > B) largeElementCount += 1;
            res = Math.min(res, largeElementCount);
        }
        return res;
    }
}

