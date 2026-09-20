package recursion;

public class Factorial {
    public static void main(String[] args) {

        System.out.println(f(7));
    }
    
/* Iterative inplementation
    static int f(int n) {
        int result=1;
        for (int i=1;i<=n;i++) {
            result=result*i;
        }
        return result;
    }
 */
    static int f(int n) {
        int result;
        if (n == 1) {
            result = 1;
        } else {
            result = n*f(n-1);
        }
        return result;
    }
}
