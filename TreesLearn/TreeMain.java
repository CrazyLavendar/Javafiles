public class TreeMain {
    public static void main(String[] args) {
        // Tree intTree = new Tree();
        // intTree.insert(25);
        // intTree.insert(20);
        // intTree.insert(15);
        // intTree.insert(17);
        // intTree.insert(27);
        // intTree.insert(30);
        // intTree.insert(29);
        // intTree.insert(26);
        // intTree.insert(22);
        // intTree.insert(32);

        // intTree.travereInOrder();

        // System.out.println("");
        // System.out.println("Data get : " + intTree.get(1577));
        // System.out.println("Data get : " + intTree.get(15));

        // System.out.println("Max is : " + intTree.max());
        // System.out.println("Min is : " + intTree.min());

        // intTree.delete(25);
        // intTree.travereInOrder();

        CustomTree ctree = new CustomTree();

        ctree.insert(25);
        ctree.insert(20);
        ctree.insert(15);
        ctree.insert(17);
        ctree.insert(27);
        ctree.insert(30);
        ctree.insert(29);
        ctree.insert(26);
        ctree.insert(22);
        ctree.insert(32);

        ctree.traverseInOrder();

        System.out.println("");
        System.out.println("Data get : " + ctree.get(25));
        System.out.println(ctree.min());
        System.out.println(ctree.max());
        ctree.delete(25);
        System.out.println("Data get : " + ctree.get(32));
        // System.out.println("Data get : " + ctree.get(135));

        ctree.traverseInOrder();
    }
}
