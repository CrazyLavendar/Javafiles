public class knapsackMain {
    public static void main(String[] args) {
        int numOfItems = 3;
        int capacityOfKnapsack = 5;

        int[] weightOfItems = new int[numOfItems + 1];
        weightOfItems[1] = 4;
        weightOfItems[2] = 2;
        weightOfItems[3] = 3;

        int[] profitOfItems = new int[numOfItems + 1];
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        knapsack k = new knapsack(numOfItems, capacityOfKnapsack, weightOfItems, profitOfItems);
        k.solve();
        k.showResult();
    }
}
