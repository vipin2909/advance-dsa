package prime_numbers;

public class NumberOfOpenDoors {

    public int solve(int A) {
        int x = 1;
        int count = 0;
        while(x * x <= A) {
            count += 1;
            x += 1;
        }
        return count;
    }
}
