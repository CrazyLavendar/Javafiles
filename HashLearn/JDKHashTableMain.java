import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JDKHashTableMain {
    public static void main(String[] args) {

        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", e1);
        hashMap.put("Doe", e2);
        hashMap.put("Smith", e3);

        // hashMap.put("Doe", e4); // This replaces Doe with Mike Wilson.. since e4 =
        // Mike Wilson
        hashMap.putIfAbsent("Doe", e4); // Doesn't override

        System.out.println(hashMap.containsKey("Doe"));

        System.out.println(hashMap.containsValue(e2));

        // Iterator<Employee> iterator = hashMap.values().iterator();
        // while (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }

        // Arrow function
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }

}
