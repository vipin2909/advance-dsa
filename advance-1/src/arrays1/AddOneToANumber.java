package arrays1;

import java.util.ArrayList;

public class AddOneToANumber {
    public int[] plusOne(int[] A) {
        int n = A.length, carry = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i  = n-1; i >= 0; i -= 1) {
            int sum = (A[i] + carry);
            int num = sum % 10;
            carry = sum/10;
            arr.add(num);
        }
        if(carry > 0) arr.add(carry);
        int sz = arr.size() - 1;
        while(sz >= 0) {
            if(arr.get(sz) == 0) sz -= 1;
            else break;
        }
        int[] result = new int[sz+1];
        for(int i = 0; i <= sz; i++) result[i] = arr.get(sz-i);
        return result;
    }
}
