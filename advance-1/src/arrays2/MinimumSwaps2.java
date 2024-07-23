package arrays2;

public class MinimumSwaps2 {
    public int solve(int[] A) {
        int numberOfSwaps = 0;
        for(int i = 0; i < A.length; i++) {
            while(A[i] != i) {
                int temp = A[i];
                int temp2 = A[A[i]];
                A[i] = temp2;
                A[temp] = temp;
                numberOfSwaps += 1;
            }
        }
        return numberOfSwaps;
    }
}
