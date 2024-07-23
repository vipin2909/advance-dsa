package arrays1;

/*
    There are A beggars sitting in a row outside a temple.
    Each beggar initially has an empty pot. When the devotees
    come to the temple, they donate some amount of coins to these
    beggars. Each devotee gives a fixed amount of coin(according
    to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from
L to R index, where 1 <= L <= R <= A,
find out the final amount of money in
each beggar's pot at the end of the day,
provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
 */
public class ContinuousSumQuery {
    public int[] solve(int A, int[][] B) {
        int n = B.length;
        int[] arr = new int[A];
        for(int i = 0; i < n; i++) {
            int startIndex = B[i][0];
            int endIndex = B[i][1];
            int amount = B[i][2];
            arr[startIndex-1] += amount;
            if(endIndex < A) {
                arr[endIndex] -= amount;
            }
        }

        int[] prefix = new int[A];
        prefix[0] = arr[0];
        for(int i = 1; i < A; i++) {
            prefix[i] = prefix[i-1]+arr[i];
        }
        return prefix;
    }
}
