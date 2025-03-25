import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class Lab4_Tester {

  @Test
  public void test1() {
    Address address = new Address("800", "22nd Street", "Washington", "DC", 20002);
    Person jane = new Person("Jane", "Doe", 23, address);
    System.out.println(jane);
    // Originally printed: Jane Doe 23 years old
    // The address is not printed
    System.out.println(jane.address);
    // Printed: Jane Doe 23 years old [EMPTY LINE] 800 null null,  20002
    // Address exists but not printed because it is not in Person.java's toString() method
    System.out.println(jane);
    // Printed: Jane Doe 23 years old 800 null null,  20002
    // Street and city incorrectly set to null (bugs in Address.java's constructor)
    // The state is not printed (not in Address.java's toString() method)
    assertEquals("Jane Doe\n\t23 years old\n\t800 22nd Street\n\tWashington, DC 20002", jane.toString());
    assertEquals(1, Person.getCount());
    Person.count = 0;
  }
  
  @Test
  public void test2() {
    Address address = new Address("800", "22nd Street", "Washington", "DC", 20002);
    Person jane = new Person("Jane", "Doe", 23, address);
    jane = new Person("Jane", "Doe", 23, address);
    assertEquals(2, Person.getCount()); // No bugs, 2 new Person objects created, each one increments Person.count
    Person.count = 0;
  }

  @Test
  public void test3() {
    ArrayList<Person> people = new ArrayList<Person>();

    Person person = new Person("Jane", "Doe", 23, null);
    people.add(person);
    person = new Person("Yoon", "Kim", 23, null);
    people.add(person);
    person = new Person("Priya", "Patel", 23, null);
    people.add(person);
    person = new Person("Michael", "Abraham", 23, null);
    people.add(person);
    person = new Person("Zack", "Martinez", 23, null);
    people.add(person);
    person = new Person("John", "Doe", 23, null);
    people.add(person);
    Person.count = 0;

    // See the original order to see where it goes wrong
    System.out.println("\nORIGINAL ORDER:");
    for (Person p : people)
		  System.out.println(p.firstname + " " + p.lastname);		

    // See the order after being sorted
		// Originally was Jane Doe to Zack Martinez
		// Should be Michael Abraham to Priya Patel
		System.out.println("\nSORTED ORDER:");
		for (Person p : people)
		  System.out.println(p.firstname + " " + p.lastname);		

    String alphabetized_names = "Michael Abraham\nJane Doe\nJohn Doe\nYoon Kim\nZack Martinez\nPriya Patel";
    assertEquals(alphabetized_names, Person.sortPeople(people)); // The problem turns out to be the sorting algorithm
  }

}
