package arrays2;

public class RowWithMaximumNumberOfOnes {
    public int solve(int[][] A) {
        int ans = 0;
        for(int i = 0, j = A[0].length - 1; i < A.length && j >= 0; i++) {
            while(A[i][j] == 1 && j >= 0) {
                ans = i;
                j -= 1;
            }
        }
        return ans;
    }
}
