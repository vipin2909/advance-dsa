package arrays2;

public class MaximumSumSquareSubMatrix {

    public int solve(int[][] A, int B) {
        int N = A.length;
        int[][] prefix = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == 0 && j == 0) {
                   prefix[i][j] = A[i][j];
                }
                else if(i == 0) {
                    prefix[i][j] = prefix[i][j-1] + A[i][j];
                }
                else if(j == 0) {
                    prefix[i][j] = prefix[i-1][j] + A[i][j];
                }
                else {
                    prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + A[i][j] - prefix[i-1][j-1];
                }
            }
        }

        int res = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i+B-1 < N && j+B-1 < N) {
                    if(i == 0 && j == 0) {
                        currSum = prefix[i+B-1][j+B-1];
                    }
                    else if(i == 0) {
                        currSum = prefix[i+B-1][j+B-1] - prefix[i+B-1][j-1];
                    }
                    else if(j == 0) {
                        currSum = prefix[i+B-1][j+B-1] - prefix[i-1][j+B-1];
                    }
                    else {
                        currSum = prefix[i+B-1][j+B-1]-prefix[i-1][j+B-1]-prefix[i+B-1][j-1]+prefix[i-1][j-1];
                    }
                    res = Math.max(currSum, res);
                }
            }
        }
        return res;
    }
}

