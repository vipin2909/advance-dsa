package arrays2;

/*
Given a matrix of integers A of size N x M and multiple queries Q,
for each query, find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e)
indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
The sum may be large, so return the answer mod 109 + 7.
Also, select the data type carefully, if you want to store the addition of some elements.
Indexing given in B, C, D, and E arrays is 1-based.
Top Left 0-based index = (B[i] - 1, C[i] - 1)
Bottom Right 0-based index = (D[i] - 1, E[i] - 1)

 */
public class SubMatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int qSize = B.length;
        long[] sum = new long[qSize];
        int mod = (int) (1e9+7);
        long[][] prefixSum = new long[rowSize][colSize];

        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < colSize; j++) {
                if(i == 0 && j == 0) {
                    prefixSum[i][j] = (A[i][j] % mod + mod) % mod;
                }
                else if(i == 0 && j > 0) {
                    prefixSum[i][j] = (A[i][j] % mod + prefixSum[i][j-1] % mod + mod) % mod;
                }
                else if(i > 0 && j == 0) {
                    prefixSum[i][j] = (A[i][j] % mod + prefixSum[i-1][j] % mod + mod) % mod;
                }
                else {
                    prefixSum[i][j] = (A[i][j] % mod + prefixSum[i-1][j] % mod + prefixSum[i][j-1] % mod - prefixSum[i-1][j-1] % mod + mod) % mod;
                }
            }
        }


        for(int i = 0; i < qSize; i++) {
            int x1 = B[i] - 1;
            int y1 = C[i] - 1;
            int x2 = D[i] - 1;
            int y2 = E[i] - 1;

            if(x1 == 0 && y1 == 0) {
                sum[i] = (prefixSum[x2][y2] % mod);
            }
            else if(x1 == 0 && y1 > 0) {
                sum[i] = ((prefixSum[x2][y2] % mod - prefixSum[x2][y1-1] % mod + mod) % mod);
            }
            else if(y1 == 0 && x1 > 0) {
                sum[i] = ((prefixSum[x2][y2] % mod - prefixSum[x1-1][y2] % mod + mod) % mod);
            }
            else {
                sum[i] = ((prefixSum[x2][y2] % mod - prefixSum[x2][y1-1] % mod - prefixSum[x1-1][y2] % mod + prefixSum[x1-1][y1-1] % mod + mod) % mod);
            }
        }

        int[] result = new int[qSize];
        for(int i = 0; i < qSize; i++) {
            result[i] = (int)(sum[i] % mod + mod) % mod;
        }

        return result;
    }
}
