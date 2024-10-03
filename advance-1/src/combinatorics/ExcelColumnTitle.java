package combinatorics;

public class ExcelColumnTitle {
    public String solve(int A) {
        StringBuilder sb = new StringBuilder("");
        while(A>0) {
            A -= 1;
            char rem = (char)(A%26+'A');
            sb.append(rem);
            A/=26;
        }
        return sb.reverse().toString();
    }
}
