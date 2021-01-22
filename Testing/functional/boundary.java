import java.io.*;

public class boundary {
    public static void main(String[] args) throws IOException {
        FileReader fd = new FileReader("boundaryInput.txt");
        BufferedReader bd = new BufferedReader(fd);
        System.out.println(
                "Boundary Value Analysis Testing: Addition of two inputs of x and y \n\t 100 <= x <= 300 \n\t 200 <=  y <= 400 \n# of Test cases : 5n + 1,  n = 2 (input for program) \n");

        int x;
        int y;
        int i = 1;
        String input1, input2;
        System.out.println("Test case ID \t Input 1 \t Input 2 \t Expected Output \t Observed Output \tPass/Fail \n");
        while ((input1 = bd.readLine()) != null && (input2 = bd.readLine()) != null) {
            System.out.print("\t" + i);
            x = Integer.parseInt(input1);
            System.out.print("\t   " + x + "\t");

            y = Integer.parseInt(input2);
            System.out.print("\t   " + y + "\t");
            if (x >= 100 && x <= 300 && y >= 200 && y <= 400) {
                System.out.print("\t    " + (x + y) + "  \t\t     " + (x + y) + " \t\t   Pass \n");
            }

            else {
                System.out.print("\t    Error  \t\t  Invalid Input \t   Fail \n");
            }

            i++;
        }
        bd.close();
        fd.close();
    }
}
