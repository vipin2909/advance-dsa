package combinatorics;



public class ComputenCr {
    // computing this using fermat little theorm

    long fast_power(long A, long B, long C) {
        if(B == 0) return 1;
        long ans = 1;
        while(B > 0) {
            if((B&1) == 1) {
                ans = (ans * A) % C;
            }
            A = (A*A) % C;
            B >>= 1;
        }
        return ans;
    }

    long fast_power_recr(long A, long B, long C) {
        if(B == 0) return 1;
        long u = fast_power_recr(A, B/2, C);
        u = (u*u) % C;
        if(B%2==1) u = (u*A)%C;
        return u;
    }
    public int solve(int A, int B, int C) {
        long[] fact = new long[1000005];
        fact[0] = 1;
        for(int i = 1; i <= A; i++) {
            fact[i] = (fact[i-1] * i) % C;
        }
        long ans = fact[A];
        ans = (ans * fast_power(fact[B], C-2, C)) % C;
        ans = (ans * fast_power(fact[A-B], C-2, C)) % C;
        return (int)(ans%C);
    }
}
