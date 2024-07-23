package arrays2;

public class SearchInRowAndColWiseSortedMatrix {

    // if A[i][j] == B return i * 1009 + j
    // if B not present return -1
    public int solve(int[][] A, int B) {
        int result = -1;
        for(int i = 0; i < A.length; i++) {
            int j = A[i].length - 1;
            if(A[i][j] >= B) {
                for(int k = j; k >= 0; k-=1) {
                    if(A[i][k] == B) {

                        result = (i+1) * 1009 + (k+1);
                    }
                }
                if(result != -1) return result;
            }
        }
        return result;
    }
}
