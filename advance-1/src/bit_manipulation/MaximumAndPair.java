package bit_manipulation;

public class MaximumAndPair {
    public int solve(int[] A) {
        // first find last set a bit for two numbers which is common
        int result = 0;
        for(int i = 31; i >= 0; i -= 1) {
            int count = 0;
            for(int j = 0; j < A.length; j++) {
                if((A[j] & (1 << i)) != 0) {
                    count += 1;
                }
            }

            if(count >= 2) {
                result |= (1 << i);
                // set all the other elements to zero, which contributing zero to the end result
                for(int j = 0; j < A.length; j++) {
                    if((A[j] & (1 << i))  == 0) {
                        A[j] = 0;
                    }
                }
            }
        }

        return result;
    }
}
