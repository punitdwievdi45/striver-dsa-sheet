package recurssion;

public class NumberPrinter {


    public static void main(String[] args) {

        // print 1 to N using recurssion
        int n = 5;
        //printNumber(1, n);

        System.out.println();
        System.out.println();

        // print N to 1 using recursion
      //  printNumberNto1(n, 1);


       // print from N to 1 using backtracking
        printNumberNto1UsingBack(1,5);
    }

    private static void printNumberNto1UsingBack(int i, int i1) {

        if(i == i1){
            return;
        }
        printNumberNto1UsingBack(i+1, i1);
        System.out.println(i);
    }

    private static void printNumberNto1(int n, int i) {
        if (i > n) {
            return;
        }
        System.out.println(n);
        printNumberNto1(--n, i);
    }

    private static void printNumber(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        printNumber(++i, n);
    }

}
