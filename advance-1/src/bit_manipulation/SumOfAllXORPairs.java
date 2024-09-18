package bit_manipulation;

public class SumOfAllXORPairs {
    public int solve(int[] A) {
        int mod = (int)(1e9+7), N = A.length, sum = 0;
        for(int i = 0; i < 31; i++) {
            int ones = 0, zero = 0, tempSum = 0;
            for(int j = 0; j < N; j++) {
                if((A[j] & 1) == 1) ones+=1;
                else zero += 1;
                A[j] >>= 1;
            }

            tempSum = (int)((long)zero * ones * (1 << i) % mod);
            sum = (sum % mod + tempSum % mod) % mod;
        }
        return sum;
    }
}
