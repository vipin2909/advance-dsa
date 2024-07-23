package arrays2;

public class SumOfAllSubmatrices {
    public int solve(int[][] A) {
        int result = 0, N = A.length;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int contribution = (N-i) * (N-j) * (i+1) * (j+1);
                result += A[i][j] * contribution;
            }
        }
        return result;
    }
}
