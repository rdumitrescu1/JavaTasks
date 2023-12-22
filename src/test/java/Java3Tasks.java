import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Java3Tasks {

    @Test
    public void task1() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> streamResult = stream.collect(Collectors.toList());
        streamResult.forEach(System.out::println);

        assertEquals(streamResult, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void task2() {

        List<Double> randomNumbers = Stream.generate(Math::random)
                .limit(20)
                .collect(Collectors.toList());
        randomNumbers.forEach(System.out::println);

        assertEquals(randomNumbers.size(), 20);
    }

    @Test
    public void task3() {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        List<Integer> newList = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        newList.forEach(System.out::println);

        assertEquals(newList, List.of(2, 4, 6, 8));
    }

    @Test
    public void task4() {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Integer[] newArray = list.stream()
                .filter(i -> i % 2 == 0)
                .toArray(Integer[]::new);

        for (Integer number : newArray) {
            System.out.println(number);
        }
        assertArrayEquals(new Integer[]{2, 4, 6, 8}, newArray);
    }

    @Test
    public void task5() {

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> filteredList = myList.stream()
                .filter(e -> e.startsWith("c"))
                .map(String::toUpperCase)
                .sorted((e1, e2) -> e2.compareTo(e1))
                .collect(Collectors.toList());
        filteredList.forEach(System.out::println);

        assertEquals(filteredList, List.of("C2", "C1"));
    }

    @Test
    public void task6_a() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        //a)
        System.out.println("//6.a)");
        List<String> newList2 = memberNames.stream()
                .filter(e -> e.startsWith("A"))
                .filter(e -> e.length() > 5)
                .collect(Collectors.toList());
        newList2.forEach(System.out::println);

        assertEquals(newList2, List.of("Amitabh", "Abibaba"));
    }

    @Test
    public void task6_b() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        List<String> sortedList = memberNames.stream()
                .sorted(String::compareTo)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);

        assertEquals(sortedList, List.of("abibaba", "aman", "amitabh", "lokesh", "rahul", "salman", "shahrukh", "shekhar", "yana"));
    }

    @Test
    public void task7() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        boolean allMatch = memberNames.stream()
                .allMatch(e -> e.contains("S"));
        System.out.println(allMatch);

        boolean anyMatch = memberNames.stream()
                .anyMatch(e -> e.contains("S"));
        System.out.println(anyMatch);

        boolean noneMatch = memberNames.stream()
                .noneMatch(e -> e.contains("H"));
        System.out.println(noneMatch);

        assertEquals(allMatch, false);
        assertEquals(anyMatch, true);
        assertEquals(noneMatch, true);
    }

    @Test
    public void task8() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        long memberCount = memberNames.stream()
                .count();
        System.out.println(memberCount);

        assertEquals(memberCount, 9);
    }

    @Test
    public void task9() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        long memberCountStartsWithA = memberNames.stream()
                .filter(e -> e.startsWith("A"))
                .count();
        System.out.println(memberCountStartsWithA);

        assertEquals(memberCountStartsWithA, 3);
    }

    @Test
    public void task10() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        String findFirst = memberNames.stream()
                .filter(e -> e.startsWith("L"))
                .findFirst()
                .orElse(null);
        System.out.println(findFirst);

        assertEquals(findFirst, "Lokesh");
    }

    @Test
    public void task11() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<Integer> concatenateLists = Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(concatenateLists);

        assertEquals(concatenateLists, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void task12() {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
        List<Integer> distinctIntList = numbersList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctIntList);

        assertEquals(distinctIntList, List.of(1, 2, 3, 4, 5, 6, 7));
    }
}
