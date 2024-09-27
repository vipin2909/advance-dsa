package prime_numbers;

import java.util.Arrays;

public class FactorialArray {
    // find the number of subsequences in factorial array which has similar set of prime factors
    public int solve(int[] A) {
        Arrays.sort(A);

        int N = A.length;
        int maxEle = A[N-1];
        boolean[] isPrime = new boolean[maxEle+1];
        Arrays.fill(isPrime, true);
        // stored prime numbers in form of boolean array
        for(int i = 2; i * i <= maxEle; i+=1) {
            if(isPrime[i]) {
                for(int j = i*i; j <= maxEle; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        // now maintain primeCount of Elements till maxEle
        int[] primeCount = new int[maxEle+1];
        for(int i = 2; i <= maxEle; i++) {
            if(isPrime[i]) {
                primeCount[i] = primeCount[i-1]+1;
            }
            else {
                primeCount[i] = primeCount[i-1];
            }
        }

        for(int i = 0; i < N; i++) System.out.println(primeCount[A[i]]+" prime count of element: " + A[i]);
        int cnt = 1;
        long sum = 0L;
        int mod = (int)(1e9+7);
        if(A[0] < 2) cnt = 0;
        for(int i = 0; i < N-1; i++) {
            if(primeCount[A[i]] == primeCount[A[i+1]]) cnt += 1;
            else {
                sum = (sum % mod + (1L*(1<<cnt) - 1) % mod) % mod;
            }
        }

        sum = (sum % mod + (1L*(1<<cnt) - 1) % mod) % mod;
        return (int)(sum % mod);


    }

    public static void main(String[] args) {
        int[] ele = new int[]{2, 6, 2, 6};
//                new int[]{6, 15, 36};
        FactorialArray obj = new FactorialArray();
        int ans = obj.solve(ele);
        System.out.println("The number of subsequences that has similar set of prime factors: " + ans);
    }

    // best problem on top logic building

}
