package collections;


import java.util.*;

public class CollectionsCountDuplicatedList {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("a", "b", "c", "d", "b", "c", "a", "a", "a");

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");

        System.out.println("\nExample 1 - Count 'a' with frequency");
        System.out.println("a : " + Collections.frequency(list, "a"));

        System.out.println("\nExample 2 - Count all with frequency");
        Set<String> uniqueSet = new HashSet<String>(list);
        for (String temp : uniqueSet) {
            System.out.println(temp + ": " + Collections.frequency(list, temp));
        }

        System.out.println("\nExample 3 - Count all with Map");
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String temp : list) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        printMap(map);

        System.out.println("\nSorted Map");
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
        printMap(treeMap);

        List<String> strings = Collections.unmodifiableList(list);
        strings.forEach(System.out::println);

    }

    public static void printMap(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

    }
}
