public class SimpleHashTable {
    private StoredEmployee[] hashtable;

    public SimpleHashTable() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {

        // Solving collision via linear probing
        int hashedKey = hashkey(key);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey; // hash key before colliding
            // if (hashedKey == hashtable.length - 1) { // Eg: for hasttable 10 , hashkey is
            // at 9 => rseset to 0
            // hashedKey = 0;
            // } else {
            // hashedKey++;
            // }
            hashedKey = (hashedKey + 1) % hashtable.length;
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) { // collision
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee); // storing along with key
        }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1)
            return null;
        return hashtable[hashedKey].employee;
    }

    private int findKey(String key) { // Finding key with last name
        int hashedKey = hashkey(key);// hashedkey is int; key is string last name
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) { // No collision occurs
            return hashedKey;
        }
        // collision solved via Linear probing

        int stopIndex = hashedKey; // hash key before colliding
        // if (hashedKey == hashtable.length - 1) { // Eg: for hasttable 10 , hashkey is
        // // at 9 => rseset to 0
        // hashedKey = 0;
        // } else {
        // hashedKey++;
        // }
        hashedKey = (hashedKey + 1) % hashtable.length; // increasing hashedkey bby one value
        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        // if (stopIndex == hashedKey) {
        // return -1;
        // } else {
        // return hashedKey;
        // }
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    public Employee remove(String key) {
        int hashedkey = findKey(key);
        if (hashedkey == -1)
            return null;
        Employee employee = hashtable[hashedkey].employee;
        hashtable[hashedkey] = null;// This makes hole in the hash table
        // Hoe to solve the hole
        // Soln 1- Rehasing the hash table;
        // Soln 2 - Don't make null..But this increases loadfactor too

        // Doing Rehasing
        StoredEmployee[] oldHashTable = hashtable;
        hashtable = new StoredEmployee[oldHashTable.length];
        for (int i = 0; i < oldHashTable.length; i++) {
            if (oldHashTable[i] != null) {
                put(oldHashTable[i].key, oldHashTable[i].employee);
            }
        }
        return employee;
    }

    private int hashkey(String key) {
        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {

            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println("Positiob " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
