package model;

// Java program to demonstrate working of
// comparator based priority queue constructor
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Creating Priority queue constructor having
        // initial capacity=5 and a StudentComparator instance
        // as its parameters
        PriorityQueue<Toy> pq = new PriorityQueue<Toy>(5, new StudentComparator());

        // Invoking a parameterized Student constructor with
        // name and cgpa as the elements of queue
        Toy toy1 = new Toy(1, "кукла", 0, 0);

        // Adding a student object containing fields
        // name and cgpa to priority queue
        pq.add(toy1);
        Toy student2 = new Toy(4, "мишка", 0, 0);
        pq.add(student2);
        Toy student3 = new Toy(2, "робот", 1, 12);
        pq.add(student3);

        // Printing names of students in priority order,poll()
        // method is used to access the head element of queue
        System.out.println("Students served in their priority order");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
    }

        public void addRaffleToy(Toy oneToy) {
        if (listPrizeToys.isEmpty()) {
            oneToy.setId(1);
            listPrizeToys.add(oneToy);
        } else {
            oneToy.setId(listPrizeToys.peek().getId() + 1);
            listPrizeToys.add(oneToy);
        }
    }

}

class StudentComparator implements Comparator<Toy> {

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(Toy s1, Toy s2) {
        if (s1.getId() > s2.getId())
            return 1;
        else if (s1.getId() > s2.getId())
            return -1;
        return 0;
    }
}
