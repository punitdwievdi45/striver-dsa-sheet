package recurssion;

public class PalindromeTeller {
    public static void main(String[] args) {
        String s = "dad";
        System.out.println(checkPallindrome(s, 0, s.length()));
    }

    private static boolean checkPallindrome(String s, int i, int length) {
        if (i >= length / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(length - i - 1)) {
            return false;
        }
        return checkPallindrome(s,i+1,length);
    }
}