package java11;

public class StringMethods {
    public static void main(String[] args) {
        String s = "    abdd   asdsa   ";
        System.out.println(s);
        System.out.println("After split method \n" +s.strip());

        System.out.println(s.lines());
        String s2 = "null";
        System.out.println(s2.isEmpty());
    }
}
