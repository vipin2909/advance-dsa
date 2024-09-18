package bit_manipulation;

public class SubarrayOR {
    public int checkBit(int val, int index) {
        if((val & (1 << index)) == 0) return 0;
        return 1;
    }
    public int solve(int[] A) {
        int N = A.length;
        long totalSubarrays = (long)N * (N+1) / 2;
        int mod = (int)1e9+7;
        long countSubarraysWithOne = 0;
        long finalAns = 0;

        for(int i = 0; i < 31; i++) {
            long countSubarraysWithZero = 0;
            long consecutiveZeros = 0;

            for(int j = 0; j < N; j++) {
                if(checkBit(A[j], i) == 0) {
                    consecutiveZeros += 1;
                }
                else {
                    countSubarraysWithZero += (consecutiveZeros * (consecutiveZeros + 1) / 2);
                    consecutiveZeros = 0;
                }
            }

            countSubarraysWithZero += (consecutiveZeros * (consecutiveZeros + 1) / 2);
            countSubarraysWithOne = totalSubarrays - countSubarraysWithZero;
            finalAns += countSubarraysWithOne * (1 << i);
        }
        return (int) (finalAns % mod);
    }
}
