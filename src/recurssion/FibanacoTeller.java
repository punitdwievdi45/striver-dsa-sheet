package recurssion;

public class FibanacoTeller {
    public static void main(String[] args) {
        System.out.println(fib(1));
    }

    private static int fib(int n) {
        if(n <= 1){
            return n;
        }
        int last = fib(n-1);
        int slast = fib(n-2);
        return last+slast;
    }
}
