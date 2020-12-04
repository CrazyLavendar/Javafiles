public class StoredEmployee {

    public String key; // Raw key. Not the hash value
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
