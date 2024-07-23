package arrays2;

public class MaximumSubmatrixSum {

    public long solve(int[][] A) {
        int N = A.length, M = A[0].length;


        long[][] prefix = new long[N][M];
        prefix[N-1][M-1] = A[N-1][M-1];
        long res = prefix[N-1][M-1];
        for(int i = N-2; i >= 0; i -= 1) {
            prefix[i][M-1] = prefix[i+1][M-1] + A[i][M-1];
            res = Math.max(1L*res, 1L*prefix[i][M-1]);
        }

        for(int j = M-2; j >= 0; j -= 1) {
            prefix[N-1][j] = prefix[N-1][j+1] + A[N-1][j];
            res = Math.max(1L*res, 1L*prefix[N-1][j]);
        }

        for(int i = N-2; i >= 0; i -= 1) {
            for(int j = M-2; j >= 0; j -= 1) {
                prefix[i][j] = prefix[i+1][j] + prefix[i][j+1] + A[i][j] - prefix[i+1][j+1];
                res = Math.max(1L*res, 1L*prefix[i][j]);
            }
        }

        return res;
    }
}
