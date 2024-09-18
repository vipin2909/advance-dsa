package bit_manipulation;

// 001
// 010
// 011
// 001
// 010
// 100
// xor = 111
public class SingleNumberIII {
    public int[] solve(int[] A) {
        int xor = 0, firstIndex = 0;
        for(int num: A) xor ^= num;
        for(int i = 0; i < 32; i++) {
            if((xor & (1 << i)) != 0) {
                firstIndex = i;
                break;
            }
        }


        int[] arr = new int[2];
        int xor1 = 0;
        int xor2 = 0;
        for(int num: A) {
            if((num & (1 << firstIndex)) != 0) {
                xor1 ^= num;
            }
            else {
                xor2 ^= num;
            }
        }

        arr[0] = xor1 > xor2 ? xor2 : xor1;
        arr[1] = xor1 > xor2 ? xor1 : xor2;
        return arr;
    }
}
