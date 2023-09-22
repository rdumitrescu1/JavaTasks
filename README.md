# Java-tasks
Java 1 Tasks

Task 1 - Check if an array is sorted ascending
Write a program that reads an array of ints and checks if the array is sorted ascending (from smallest to largest number).


Input data format:

The first line contains the size of an array.
The second line contains elements of the array separated by spaces.

Output data format:

Only a single value: true or false.

Sample Input 1:
 
4

1 2 3 4


Sample Output 1:

True


Sample Input 2:

4

1 2 3 0


Sample Output 2:

false

Task 2 - Reverse String
Write 3 implementations (or more) for reversing a string.


Input:
```java
String stringToRevers = "I'm going to go to school today morning."
```
Output:

".gninrom yadot loohcs ot og ot gniog m'I"

Task 3 - Change identities
There is a class Person that has two fields: name and age. Your task is to implement the method changeIdentities. It should swap all information (age and name) between two persons p1 and p2.


It is known that objects p1 and p2 can't be null.
```java
class Person {
  String name;
  int age;
}

class MakingChanges {
  public static void changeIdentities(Person p1, Person p2) {
      // write your code here

  }
}

```

Task 4 - Account Service (Interfaces)
Imagine an interface AccountService that is designed for keeping track of accounts and balances. It has two abstract methods:

findAccountByOwnerId(long id) takes user id and returns this user account or null in case no account was found;
countAccountsWithBalanceGreaterThan(long balance) returns the number of accounts with a balance exceeding the provided number.

There are also two classes: Account and User, each of them having several fields. The owner field of the Account class is an object of the User type. You can find the details in the provided template.


Your task is to create an AccountServiceImpl class that implements the AccountService interface and its two methods. It should have a constructor that takes an Account array which will be used for searching when either of the methods is called.For example, to find an account by the user id we need to go through all the accounts from this array and compare these accounts owners id with the given id.


Here's an example of how these methods will be called:
```java
Account[] accounts = ...
AccountService service = new AccountServiceImpl(accounts);
service.findAccountByOwnerId(10L); // returns an account where owner id is 10
```
Note: do not make classes and the interface public.


Template:
```java
interface AccountService {
  /**
   * It finds an account by owner id
   * @param id owner unique identifier
   * @return account or null
   */
  Account findAccountByOwnerId(long id);
  /**
   * It count the number of account with balance > the given value
   * @param value
   * @return the number of accounts
   */
  long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here

class Account {

  private long id;
  private long balance;
  private User owner;

  public Account(long id, long balance, User owner) {
      this.id = id;
      this.balance = balance;
      this.owner = owner;
  }

  public long getId() {
      return id;
  }

  public long getBalance() {
      return balance;
  }

  public User getOwner() {
      return owner;
  }
}

class User {

  private long id;
  private String firstName;
  private String lastName;

  public User(long id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
  }

  public long getId() {
      return id;
  }

  public String getFirstName() {
      return firstName;
  }

  public String getLastName() {
      return lastName;
  }
}
```


--------------------------------------------------------

Java 2 Tasks

Topic: Collections / Arrays

Part: 1

1. Find in Google song ""beatles yellow submarine""

2. Save this song as String

3. Remove all "","" , ""\n "" and convert all words to lowercase (Programmatically!)

4. Make an array[] (not a List) from the string (array of words)

5. Print to consol word and how many times it appeared in the array"


Part: 2

1. Update Task #1 to use collections to count the words.  (Put song from array to List)      

2. Remove all duplicate words from the song and print to console

3. Sort song words by String length. "                        

        

Part: 3                

1. Take List<String> of song from task1

2. Remove all world ""yellow"" and ""submarine""

3. Print the result."                        


Part 4:

1. Save song ""beatles yellow submarine"" to txt file

2. Read song from file (serialization, use a try with resources)

3. Define a custom exception : BeatlesException extending Exception, add a ""Beatles"" to a caught exception message

4. Create a method which verifies if some random string (ex: ""Show must go on!"") can be found in song above

5. Throw BeatlesException defined above if a given random string is not found in your song text."



Part 5: Fix this Set. It should contain 3 Objects

```java
import java.util.HashSet;

import java.util.Set;


public class SetProblem {


   static class User {

       private String name;

       private int age;


       public User(String name, int age) {

           this.name = name;

           this.age = age;

       }

       public String getName() {

           return name;

       }

       public void setName(String name) {

           this.name = name;

       }

       public int getAge() {

           return age;

       }

       public void setAge(int age) {

           this.age = age;

       }

   }

 

   public static void main(String[] args) {

           Set<User> users = new HashSet<>();

           users.add(new User("Max", 27));

           users.add(new User("Veronika", 20));

           users.add(new User("Denis", 30));

           users.add(new User("Max", 27));

 

           if (users.size() == 3) {

           System.out.println("System works well!");

           } else {

           throw new RuntimeException("Users set size should be 3!");

           }

   }

}

```
Topic: Regex

 1. Find and return true or false if String contains orderUUID


app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3

2. Find and return orderUUID substring from string


app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3


3. Find and return user email from string 


test 2667843 (test_email@griddynamics.com) test 67483 some string 


4. find and return how many orders were created from this string - 


app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [2]


Topic: Java Core. Practice 

Print to console all the words that start on 'de'.


Text to use for the search:


String testFoeSearch = "When you first start to evaluate a cloud migration, the decisions to be made, stakeholders who need to be involved, it can sometimes feel overwhelming – and with good reason. A move to the cloud can take time, resources, and manpower, and while companies are nearly universally glad they made those investments, that doesn't cancel out the fact that they take strategic planning and up-front work."
 "What do you need to plan for? Who needs to be involved (and when)? What roles and responsibilities need to be divided up? The answers vary a bit depending on your company size, the scope of your migration, and whether you have the budget (or need) for a migration partner."
"Below are the typical roles and responsibilities we see from successful migrations – and some tips to prepare your team for success. Because without the right team in place, missed deadlines, duplicative work, and post-migration workflow issues become much greater risks.";
