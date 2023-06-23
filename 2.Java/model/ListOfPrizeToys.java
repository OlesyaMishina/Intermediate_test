package model;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ListOfPrizeToy
 */
public class ListOfPrizeToys {

    private PriorityQueue<Toy> listPrizeToys;

    public ListOfPrizeToys() {
        listPrizeToys = new PriorityQueue<>(15, new ComparatorById());
    }

    public void addRaffleToy(Toy oneToy) {

        if (listPrizeToys.size() == 0) {
            oneToy.setId(1);
            listPrizeToys.add(oneToy);
           } else {
            oneToy.setId(listPrizeToys.size() + 1);
            listPrizeToys.add(oneToy);
        }
    }

    public void giveOutToy() {
        listPrizeToys.poll();
    }

    public PriorityQueue<Toy> getPrizeToysList() {
        return listPrizeToys;
    }

    public boolean isEmpty() {
        if (listPrizeToys.isEmpty())
            return true;
        return true;
    }

    public Toy poll() {
        return listPrizeToys.poll();
    }

    public Toy peek() {
        return listPrizeToys.peek();
    }

    public void add(Toy oneToy) {
        listPrizeToys.add(oneToy);
    }

}