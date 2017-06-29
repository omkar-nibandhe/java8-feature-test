import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Omkar Nibandhe <br>
 * 		Jun 28, 2017 <br>
 * 		https://www.linkedin.com/in/omkarnibandhe
 */
public class LambdaExercise {

	public static void main(String[] args) {

		List<Person> myList = Arrays.asList(
			
			new Person("Omkar", "Nibandhe", 25),
			new Person("Yash", "Divecha", 27),
			new Person("Pranav", "Pitale", 27),
			new Person("Ashish", "Bhumkar", 27),
			new Person("Abhijit", "Jagdale", 27)
		);
		printList(myList);
		
		
		// Sort List on last name
		//Java 7
		Collections.sort(myList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLname().compareTo(o2.getLname());

			}
			
		});
		printList(myList);
		
		//Java 8
		Collections.sort(myList, (o1, o2) -> o2.getLname().compareTo(o1.getLname()));
		printList(myList);
		
		// Print people with first name starting with "O"
		
		//Java 7
		printPeopleWith(myList, new Condition(){

			@Override
			public boolean test(Person p) {
				return p.getFname().startsWith("O");
			}
			
		});	
		
		//Java 8
		printPeopleWith(myList, p -> p.getLname().startsWith("N"));
		
		
		
		// Printing all records in Java 8
		printPeopleWith(myList, p -> true);
		
	}

	private static void printPeopleWith(List<Person> myList, Condition c) {
		System.out.println("---printPeopleWith--");
		for (Person person : myList) {
			if(c.test(person)){
				System.out.println(person);
			}
		}
	}

	
	private static void printList(List<Person> myList) {
		System.out.println("------------------------------------");
		for (Person person : myList) {
			System.out.println(person);
		}
	}
	
	interface Condition{
		boolean test(Person p);
		
	}
}
