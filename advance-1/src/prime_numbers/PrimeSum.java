package prime_numbers;

import java.util.Arrays;

public class PrimeSum {

    int[] sieve(int A) {
        int[] isPrime = new int[A+1];
        Arrays.fill(isPrime, 1);
        for(int i = 2; i*i <= A; i++) {
            if(isPrime[i] == 1) {
                for(int j = i*i; j <= A; j+=i) {
                    isPrime[j] = 0;
                }
            }
        }
        return isPrime;
    }

    public int[] solve(int A) {
        int[] isPrime = sieve(A);
        int[] ans = new int[2];
        for(int i = 2; i <= A; i++) {
            if(isPrime[i] == 1 && isPrime[A-i] == 1) {
                ans = new int[]{i, A-i};
                break;
            }
        }

        return ans;
    }
}
