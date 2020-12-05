public class ChainedHashTableMain {

    public static void main(String[] args) {

        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);
        Employee e5 = new Employee("Bill", "End", 78);

        ChainedHashTable ht = new ChainedHashTable();
        ht.put("Jones", e1);
        ht.put("Doe", e2);
        ht.put("Wilson", e4);
        ht.put("Smith", e3);

        // ht.printHashtable();
        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
        // System.out.println("Retrieve key Smith: " + ht.get("Vimaa "));
        ht.remove("Wilson");
        ht.remove("Jones");
        ht.printHashtable();
        System.out.println("Retrieve key Vimal : " + ht.get("Smith")); // should give null

    }

}
