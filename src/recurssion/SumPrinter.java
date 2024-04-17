package recurssion;

public class SumPrinter {
    public static void main(String[] args) {
      printSum(3, 0);

        System.out.println();
        System.out.println(printSumInfunctionalWay(3));
    }

    private static int printSumInfunctionalWay(int i) {
        if (i == 0)
            return 0;
        return i + printSumInfunctionalWay(i-1);
    }

    private static void printSum(int i, int sum) {
        if (i < 0){
            System.out.println(sum);
            return;
        }
        printSum(i-1, sum+i);
    }
}

/*
below is func tree
                i, sum
        printSum(3, 0)
        /
    printSum(2,3)
    /
printSum(1,5)
/
printSum(0,6)*/
