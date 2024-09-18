package bit_manipulation;

public class StrangeEquality {

    int findMSB(int A) {
        if(A == 0) return 0;
        int msb = 0;
        A >>= 1;
        while(A != 0) {
            A >>= 1;
            msb += 1;
        }
        return msb;
    }
    public int solve(int A) {
        int firstValue = 0, msb = findMSB(A), secondValue = 1 << (1 + msb);

        for(int i = 0; i < 32; i++) {
            if((A & (1 << i)) == 0 && i < msb) {
                firstValue |= (1 << i);
            }
        }

        return firstValue ^ secondValue;
    }
}
