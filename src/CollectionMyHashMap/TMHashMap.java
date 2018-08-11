package CollectionMyHashMap;

//@author ntallapa

public class TMHashMap {

    // for simplicity size is taken as 2^4
    private Entry table[] = new Entry[4];

    class Entry {
        Employee key;
        String value;
        Entry next;

        Entry(Employee k, String v) {
            key = k;
            value = v;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Employee getKey() {
            return key;
        }
    }


    private int getSupplementalHash(int h) {

        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    private int getBucketNumber(int hash) {
        return hash & (4 - 1);
    }


    public void put(Employee key, String value) {
        int userHash = key.hashCode();
        int hash = getSupplementalHash(userHash);

        int bucket = getBucketNumber(hash);
        Entry existingElement = table[bucket];

        for (; existingElement != null; existingElement = existingElement.next) {

            if (existingElement.key.equals(key)) {
                existingElement.value = value;
                return;
            } else {
                System.out.println("Collision detected for key " + key + ", adding element to the existing bucket");

            }
        }
        Entry entryInOldBucket = new Entry(key, value);
        entryInOldBucket.next = table[bucket];
        table[bucket] = entryInOldBucket;
    }


    public Entry get(Employee key) {

        int hash = getSupplementalHash(key.hashCode());
        int bucket = getBucketNumber(hash);
        Entry existingElement = table[bucket];
        while (existingElement != null) {
            System.out.println("Traversing the list inside the bucket for the key " + existingElement.getKey());
            if (existingElement.key.equals(key)) {
                return existingElement;
            }
            existingElement = existingElement.next;
        }
        return null;
    }


    public static void main(String[] args) {
        TMHashMap tmhm = new TMHashMap();

        System.out.println("============== Adding Element ===================");
        Employee e1 = new Employee(100, "Niranjan");
        tmhm.put(e1, "dept1");

        // duplicate
        System.out.println("============== Adding Duplicate ===================");
        Employee e1_dup = new Employee(100, "Niranjan");
        tmhm.put(e1_dup, "dept12");

        Entry e = tmhm.get(e1_dup);
        System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

        System.out.println("============== Adding Elements ===================");
        Employee e2 = new Employee(102, "Sravan");
        tmhm.put(e2, "dept3");

        Employee e3 = new Employee(104, "Ananth");
        tmhm.put(e3, "dept2");

        Employee e4 = new Employee(106, "Rakesh");
        tmhm.put(e4, "dept5");

        Employee e5 = new Employee(108, "Shashi");
        tmhm.put(e5, "dept2");


        System.out.println("============== Adding Collisions ===================");
        Employee e2_collision = new Employee(112, "Chandu");
        tmhm.put(e2_collision, "dept16");
        e = tmhm.get(e2_collision);
        System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

        // collision with e3
        Employee e3_collision = new Employee(114, "Santhosh");
        tmhm.put(e3_collision, "dept9");
        e = tmhm.get(e3_collision);
        System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

        System.out.println("============== Adding Duplicate in Collision ===================");
        Employee e3_collision_dupe = new Employee(124, "Santhosh");
        tmhm.put(e3_collision_dupe, "dept91");
        e = tmhm.get(e3_collision_dupe);
        System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

    }

    static class Employee {
        private Integer id;
        private String name;

        Employee(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return id % 10;
        }

        @Override
        public boolean equals(Object obj) {
            Employee otherEmp = (Employee) obj;
            return this.name.equals(otherEmp.name);
        }

        @Override
        public String toString() {
            return this.id + "-" + name;
        }
    }

}
