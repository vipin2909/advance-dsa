package prime_numbers;

public class CountOfDivisors {
    int MAX_LEN = 1000000;
    int[] spf = new int[MAX_LEN+5];
    public void sieve() {
        for(int i = 1; i <= MAX_LEN; i++) spf[i] = i;
        for(int i = 2; i*i <= MAX_LEN; i++) {
            if(spf[i] == i) {
                for(int j = i*i; j <= MAX_LEN; j+=i) {
                    if(spf[j] == j) spf[j] = i;
                }
            }
        }
    }
    public int[] solve(int[] A) {
        int N = A.length;
        int[] sol = new int[N];
        sieve();
        for(int i = 0; i < N; i++) {
            int temp = A[i];
            int ans = 1;
            while(temp != 1) {
                int count = 1;
                int d = spf[temp];
                while(temp != 1 && temp % d == 0) {
                    count += 1;
                    temp /= d;
                }
                ans *= count;
            }
            sol[i] = ans;
        }
        return sol;
    }
}
