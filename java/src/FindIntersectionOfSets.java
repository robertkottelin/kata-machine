// Find the intersection of two sets.
// Data structure: HashSet.java

import java.util.HashSet;

public class SetIntersection {
    public HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> resultSet = new HashSet<>();

        for (Integer element : set1) {
            if (set2.contains(element)) {
                resultSet.add(element);
            }
        }

        return resultSet;
    }
}
