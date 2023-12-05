package DSA.Array.Sorting;

import java.util.*;
/*
 * How can the elements of an array representing heights [5, 3, 2, 6, 1, 4] be arranged
 * according to the order specified by another array [0, 1, 2, 0, 3, 2]?
 * The second array indicates the number of people with height equal to or ahead
 * of each corresponding height in the first array. What would be the resulting output
 * arrangement for the given example, where the desired output is [5, 3, 2, 1, 6, 4]?
 */
class Person {
    int height;
    int peopleAhead;

    public Person(int height, int peopleAhead) {
        this.height = height;
        this.peopleAhead = peopleAhead;
    }
}

public class HardArrangements {

    // Custom comparator for sorting Person objects
    public static class MyArrayListComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            // Compare based on the number of people ahead
            int d1 = p1.peopleAhead - p2.peopleAhead;
            // If the number of people ahead is the same, compare based on height in descending order
            int d2 = p2.height - p1.height;

            // If heights are equal, return the comparison based on people ahead
            if (p1.height == p2.height) {
                return d1;
            } else {
                return d2;
            }
        }
    }

    // Function to arrange heights based on the specified criteria
    public static ArrayList<Integer> arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n) {
        // Create a list of Person objects to store heights and people ahead values
        ArrayList<Person> people = new ArrayList<>();

        // Populate the people list with Person objects
        for (int i = 0; i < n; i++) {
            people.add(new Person(A.get(i), B.get(i)));
        }

        // Sort the people list using the custom comparator
        Collections.sort(people, new MyArrayListComparator());

        // Create a new list to store the arranged heights
        ArrayList<Integer> ans = new ArrayList<>();

        // Arrange the heights based on the sorted people list
        for (int i = 0; i < n; i++) {
            ans.add(people.get(i).peopleAhead, people.get(i).height);
        }

        return ans; // Return the final arranged heights
    }

    public static void main(String[] args) {
        // Example input
        ArrayList<Integer> A = new ArrayList<>(List.of(5, 3, 2, 6, 1, 4));
        ArrayList<Integer> B = new ArrayList<>(List.of(0, 1, 2, 0, 3, 2));
        int n = A.size();

        // Call the arrange function and store the result
        ArrayList<Integer> result = arrange(A, B, n);

        // Print the result
        System.out.println(result);
    }
}

