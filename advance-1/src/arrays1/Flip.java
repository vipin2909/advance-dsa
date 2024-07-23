package arrays1;

/*
You are given a binary string A(i.e., with characters 0 and 1) consisting
of characters A1, A2, ..., AN. In a single operation, you can choose
two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters
AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array.
Else, return an array consisting of two elements denoting L and R.
If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 */

// good problem of kadane's algorithm

public class Flip {

    public int[] flip(String A) {
        int sz = A.length(), cnt = 0, j = 0, k = 0, curr = 0, best = 0, leftIndex = 0, rightIndex = 0;
        char[] arr = A.toCharArray();
        int[] nums = new int[sz];
        for(int i = 0; i < sz; i++) {
            cnt += (arr[i] == '1' ? 1 : 0);
            nums[k++] = (arr[i] == '1' ? -1 : 1);
        }
        if(cnt == sz) return new int[]{};

        for(int i = 0; i < sz; i++) {
            curr += nums[i];
            if(best < curr) {
                best = curr;
                leftIndex = j+1;
                rightIndex = i+1;
            }
            else if(curr < 0) {
                j = i+1;
                curr = 0;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }
}
