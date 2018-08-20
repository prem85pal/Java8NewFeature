package collections;

import java.util.*;

public class aaaTo3a {

    public static void main(String[] args) {

        String str = "aaabbcccc";
        String[] strings = str.split("");
        List<String> stringsList = Arrays.asList(strings);

        List<String> stringList = Arrays.asList("a", "a", "a", "b", "b", "c", "c", "c", "c");

        Set<String> uniqueSet = new HashSet<String>(stringList);

        for (String element : uniqueSet) {
            System.out.print(Collections.frequency(stringList, element) + element);
        }

        System.out.println("Second way");
        Map<String, Integer> map = new HashMap<>();
        for (String element : stringList) {

            Integer count = map.get(element);
            map.put(element, Objects.isNull(count) ? 1 : count + 1);

        }
        printMapInFormat(map);

    }

    public static void printMapInFormat(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + entry.getKey());
        }

        map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));

        Set<String> strings = map.keySet();
        strings.forEach(key -> System.out.println(key));
        strings.forEach(System.out::println);
    }
}
