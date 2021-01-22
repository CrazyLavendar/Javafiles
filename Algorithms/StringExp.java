public class StringExp {
    public static void main(String[] args) {
        String x = "hello";

        char a = x.charAt(1);
        System.out.println(a);

        StringBuilder str = new StringBuilder(x);

        str.setCharAt(1, 'P');
        System.out.println(str);

    }
}
