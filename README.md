Tasks:

1.Show in console 
Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);

2.Create a list of random numbers using Stream.generate() , should have 20 items and print in console

3.Collect Stream elements to a List:  Convert list elements to stream, select only even ones, use the collect method to collect them into a List:

List<Integer> list = new ArrayList<Integer>();
for(int i = 1, i < 10; i++){
list.add(i)
}

4.Repeat the same as in task 3 but collect all the elements in Array [];

5.filter values, keep those that start with "c", convert all values, convert to uppercase, sort in Descending order
 List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

6.
a) Display names that start with ‘A’ and have length > 5;
b) Sort all names and display them in lower case on the screen
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

7.Stream.match() - Various matching operations can be used to check whether a given predicate matches the stream elements. Match returns a boolean result.
From task 6, take an array and check with allMatch or anyMatch whether the list contains names with the letter ‘S’ (allMatch should display false, anyMatch should display true)
From task 6, take an array and check with noneMatch whether the list contains names with the letter ‘H’ (should display true)

8.Stream.count() - The count() is a terminal operation returning the number of elements in the stream as a long value.

9.From task 6 count the number of names starting with “A” - display their number.

10.Stream.findFirst() - take the array from task 6 and print the first name starting with ‘L’


11.Java Stream flatMap() - concatenate 3 arrays into one using flatMap ()
        List<Integer> list1 = Arrays.asList(1,2,3);
       List<Integer> list2 = Arrays.asList(4,5,6);
       List<Integer> list3 = Arrays.asList(7,8,9);


12.Stream.distinct() to remove duplicates - remove duplicates from this array and display.
ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
