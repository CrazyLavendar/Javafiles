import java.io.*;
import java.util.*;
import java.lang.Math;

public class min_GeneticAlgo {

    static int Path = 5; // since cyclomatic complecity , total paths = 5
    static int inputSet; //
    static int I = 3; // Input number - maximum of 3 Nos

    public static void main(String[] args) throws IOException {
        int execute;
        Scanner scan = new Scanner(System.in);
        System.out.println("Executed Genetic Algortithm for finding minimum of 3 input numbers.");

        System.out.println("Enter No.of Testcases. \nValue : can be greater than or equal to 1");
        execute = scan.nextInt();
        if (execute < 1) {
            System.out.println("No.of times to execute not properly defined");
            scan.close();
            System.exit(0);

        }
        System.out.println("Enter the number of input set for Each Testcase"
                + "\nValue :  greater than equal to 5. Since Cyclomatic complexity has 5 Paths in the code written");
        inputSet = scan.nextInt();
        if (inputSet < 5 || inputSet > 20) {
            System.out.println("Reexecute the input sets with the range 5 to 20");
            scan.close();
            System.exit(0);
        }
        ArrayList<ArrayList<Integer>> graph_nodes = new ArrayList<ArrayList<Integer>>(inputSet); // graph via Adjaceny
                                                                                                 // List
        for (int i = 0; i < inputSet; i++)
            graph_nodes.add(new ArrayList<Integer>());
        Integer numbers[][] = new Integer[inputSet][I];

        for (int executing = 1; executing <= execute; executing++) {

            System.out.println(
                    "\n**********************************Executing Genetic algorithm Min of three numbers. Testcase No : "
                            + executing + " ****************************************************\n");
            for (int i = 0; i < inputSet; i++) {
                // numbers = readInput();
                numbers = readInputRandom();
            }
            GeneticTesting(graph_nodes, numbers);
        }
        scan.close();
    }

    static void GeneticTesting(ArrayList<ArrayList<Integer>> graph_nodes, Integer inp_numbers[][]) throws IOException {

        int MutBit = 6; // Starting mutation from 2nd LSB wherever mutation occurs
        int NumbMutuate = 1;
        int CrossOverStart = 0, startBitCross = 2;
        int PathCoverPercent = 0;
        int loopCheck = 0;
        // Check Path covered Percent
        GetPath(graph_nodes, inp_numbers);
        while (true) {
            loopCheck++;
            if (loopCheck > 100) {
                loopCheck = 0;
                System.out.println(
                        "Selected Testcase Didn't cover all unique paths, \nSince Mutation & Crossover goes into Loop more than 100 times\n Stopping the current Testcase\n");
                break;
            }
            PathCoverPercent = GeneratePath(graph_nodes);
            if (PathCoverPercent < 95 && PathCoverPercent > 75) {

                System.out.println(
                        "Path covered by above TestCase: " + PathCoverPercent + "  percent \n Performing Mutation...");
                NumbMutuate = (NumbMutuate + 1) % 3;

                Mutation(inp_numbers, MutBit % 7, NumbMutuate);
                GetPath(graph_nodes, inp_numbers);
                if (NumbMutuate == 0) {
                    MutBit++;
                }
            } else if (PathCoverPercent < 75) {

                System.out.println(
                        "Path covered by above TestCase: " + PathCoverPercent + "  percent\n Performing CrossOver...");
                CrossOver(inp_numbers, CrossOverStart++, (startBitCross++) % 7);
                GetPath(graph_nodes, inp_numbers);
            } else {
                System.out.println(
                        "Path covered by above TestCase: " + PathCoverPercent + "  percent\n Satisfied!!!!!!!!!");
                loopCheck = 0;
                break;

            }
        }

    }

    static Integer[][] readInputRandom() {
        Integer[][] nums = new Integer[inputSet][I];
        Random random;
        int min = 0, max = 20;
        for (int i = 0; i < inputSet; i++) {
            for (int j = 0; j < I; j++) {
                random = new Random();
                nums[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return nums;
    }

    static Integer GeneratePath(ArrayList<ArrayList<Integer>> input) {
        int unique = input.size();
        for (int i = 0; i < (input.size() - 1); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (input.get(i).equals(input.get(j))) {
                    unique--;
                    break;
                }
            }
        }
        return (unique * 100) / Path;
    }

    static void Mutation(Integer[][] input, Integer MutuateBit, Integer MutationInput) {
        for (int i = 0; i < inputSet; i++) {
            Integer[] bits1 = IntToBinaryArray(input[i][MutationInput]);
            if (bits1[MutuateBit % 8] == 1) {
                bits1[MutuateBit % 8] = 0;
            } else {
                bits1[MutuateBit % 8] = 1;
            }
            input[i][MutationInput] = BinaryArrayToInt(bits1);
        }
    }

    static void CrossOver(Integer[][] input, int num, int start) {
        for (int i = 0; i < inputSet; i++) {
            Integer[][] bits = new Integer[3][8];
            for (int j = 0; j < 3; j++) {
                bits[j] = IntToBinaryArray(input[i][j]);
            }
            int temp;
            // CrossOver a and b
            for (int j = 0; j < 3; j++) {
                temp = bits[(num) % 3][(j + start) % 7];
                bits[(num) % 3][(j + start) % 7] = bits[(num + 1) % 3][(j + start) % 7];
                bits[(num + 1) % 3][(j + start) % 7] = temp;
            }
            // CrossOver b and c
            start = start + 3;
            for (int j = 0; j < 3; j++) {
                temp = bits[(num + 1) % 3][(j + start) % 7];
                bits[(num + 1) % 3][(j + start) % 7] = bits[(num + 2) % 3][(j + start) % 7];
                bits[(num + 2) % 3][(j + start) % 7] = temp;
            }
            for (int j = 0; j < 3; j++) {
                input[i][j] = BinaryArrayToInt(bits[j]);
            }
        }
    }

    static Integer[] IntToBinaryArray(int num) {
        Integer[] bits = new Integer[8];
        for (int i = 7; i >= 0; i--) {
            bits[i] = num % 2;
            num = num / 2;
        }
        return bits;
    }

    static Integer BinaryArrayToInt(Integer[] bits) {
        int numb = 0;
        int temp;
        for (int i = 0; i <= 7; i++) {
            temp = 0;
            if (bits[i] > 0) {

                temp = (int) Math.pow(2, 7 - i);
            }
            numb = numb + temp;
        }

        return numb;
    }

    static void PrintNumbers(Integer[][] input) {
        for (int i = 0; i < inputSet; i++) {
            System.out.println("Inputs : a : " + input[i][0] + ", b:  " + input[i][1] + ", c :  " + input[i][2]);
        }
    }

    static void GetPath(ArrayList<ArrayList<Integer>> nodes, Integer[][] inp_numbers) { // Core Logic
        // Emptying initially if it has something
        for (int i = 0; i < inputSet; i++) {
            nodes.get(i).clear();
            int a = inp_numbers[i][0];
            int b = inp_numbers[i][1];
            int c = inp_numbers[i][2];
            nodes.get(i).add(0); // Start
            int Min;
            if (nodes.get(i).add(1) && a < b) {
                if (nodes.get(i).add(2) && b < c) {
                    nodes.get(i).add(3);
                    Min = a;

                } else if (nodes.get(i).add(4) && a < c) {
                    {
                        nodes.get(i).add(5);
                        Min = a;
                    }
                } else {
                    nodes.get(i).add(6);
                    Min = c;

                }
            } else if (nodes.get(i).add(7) && b < c) {
                {
                    nodes.get(i).add(8);
                    Min = b;
                }
            } else {
                nodes.get(i).add(9);
                Min = c;
            }

            nodes.get(i).add(10);// end
            System.out.println("Input set " + (i + 1) + " : " + a + " " + b + " " + c + "   ; \tMin Val :" + Min
                    + " \tFrom Cyclomatic complexity " + Path + " (unique) Paths" + ", Current input set " + (i + 1)
                    + " chooses path nodes : " + nodes.get(i));

        }
    }

}

// static Integer[][] readInput() throws IOException {
// FileReader fd = new FileReader("Input.txt");
// BufferedReader bd = new BufferedReader(fd);
// Integer[][] nums = new Integer[inputSet][I];
// for (int i = 0; i < inputSet; i++) {
// String str = bd.readLine();
// String[] integers = str.split(" ");
// for (int j = 0; j < I; j++) {
// nums[i][j] = Integer.parseInt(integers[j]);
// }
// }
// bd.close();
// fd.close();
// return nums;
// }