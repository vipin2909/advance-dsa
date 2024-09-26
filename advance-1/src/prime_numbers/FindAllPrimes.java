package prime_numbers;


import java.util.ArrayList;
import java.util.Arrays;

public class FindAllPrimes {
    public void findAllPrimes(int A, ArrayList<Integer> res) {
        int[] arr = new int[A+1];
        Arrays.fill(arr, -1);
        for(int i = 2; i*i <= A; i+=1) {
            if(arr[i] == -1) {
                for(int j = i*i; j <= A; j+=i) {
                    // this if statement used when we want to find smallest divisor of any number
                    if(arr[j] == -1) arr[j] = 1;
                }
            }
        }

        for(int i = 2; i <= A; i++) if(arr[i] == -1) res.add(i);
    }

    public int[] solve(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        findAllPrimes(A, res);
        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }


}
