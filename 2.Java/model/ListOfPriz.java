package model;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ListOfPrizeToy
 */
public class ListOfPriz {

    private PriorityQueue<Toy> listPrizeToys = new PriorityQueue<Toy>(15, new ComparatorById());

    public ListOfPriz() {
        listPrizeToys = new PriorityQueue<>();
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

    public void giveOutToy() {
        listPrizeToys.poll();
    }

    public PriorityQueue<Toy> getPrizeToysList() {
        return listPrizeToys;
    }

    public boolean isEmpty() {
        if (listPrizeToys.isEmpty())
            return false;
        return false;
    }

    public Toy poll() {
        return listPrizeToys.poll();
    }

}