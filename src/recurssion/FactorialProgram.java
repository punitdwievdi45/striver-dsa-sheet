package recurssion;

public class FactorialProgram {

    public static void main(String[] args) {
        System.out.println(printFactorial(3));
    }

    private static int printFactorial(int i) {
        //fact of 5 = 5*4*3*2*1 = 120
        if ( i == 0){
            return 1;
        }

        //System.out.println();

        //return fact;
         return i * printFactorial(i-1);

    }



}
