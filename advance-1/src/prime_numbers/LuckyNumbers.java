package prime_numbers;

public class LuckyNumbers {
    int getNumberOfDivisors(int x) {
        int cnt = 0;
        for(int i = 2; i*i <= x; i++) {
            if(x%i == 0) {
                cnt += 1;
                while(x % i == 0) {
                    x /= i;
                }
            }
        }
        if(x > 1) {
            cnt += 1;
        }
        return cnt;
    }
    public int solve(int A) {
        int[] result = new int[A+1];
        int cnt = 0;
        for(int i = 1; i <= A; i++) {
            int x = getNumberOfDivisors(i);
            if(x == 2)  {
                System.out.println(i);
                cnt += 1;
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        LuckyNumbers obj = new LuckyNumbers();
        int res = obj.solve(12);
        System.out.println(res);
    }
}
