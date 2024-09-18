package bit_manipulation;

import java.util.Arrays;

public class MinXORValue {
    public int solve(int[] A) {
        Arrays.sort(A);
        int result = Integer.MIN_VALUE;
        for(int i = 1; i < A.length; i++) {
            result = Math.max(A[i] ^ A[i-1], result);
        }
        return result;
    }
}
