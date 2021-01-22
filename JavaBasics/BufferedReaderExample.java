import java.io.*;

public class BufferedReaderExample {
    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("inputs\\testout.txt");
        BufferedReader br = new BufferedReader(fr);

        String i;
        while ((i = br.readLine()) != null) {
            System.out.println((String) i);
        }
        System.out.println(i);
        br.close();
        fr.close();
    }
}