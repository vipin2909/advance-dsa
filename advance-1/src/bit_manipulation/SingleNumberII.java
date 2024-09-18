package bit_manipulation;

public class SingleNumberII {
    public int solve(int[] A) {
        int result = 0;
        int[] arr = new int[32];
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < 32; j++) {
                if((A[i] & (1 << j)) != 0) {
                    arr[j] += 1;
                }
            }
        }

        for(int i = 0; i < 32; i++)
        {
            if((arr[i] % 3) != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
