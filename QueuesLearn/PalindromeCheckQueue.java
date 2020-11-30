import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCheckQueue {
    public static void main(String[] args) {

        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctuation.append(c);
                // You can push char here itself.. But writing separately for stack operations
            }
        }
        // Upto now we are just polishing the strimg
        // System.out.println(stringNoPunctuation);

        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < stringNoPunctuation.length(); i++) {
            stack.push(stringNoPunctuation.charAt(i)); // push into stack
            queue.addLast(stringNoPunctuation.charAt(i));
        }
        // Use one stack and one queue
        while (!stack.isEmpty()) { // stack and queue size should equal
            if (stack.pop() != queue.removeFirst())
                return false;
        }
        return true;
    }
}
