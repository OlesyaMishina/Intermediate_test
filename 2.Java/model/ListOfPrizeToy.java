package model;

import java.util.PriorityQueue;

/**
 * ListOfPrizeToy
 */
public class ListOfPrizeToy {

    private PriorityQueue<Toy> listPrizeToys;

    public ListOfPrizeToy() {
        listPrizeToys = new PriorityQueue<>();
    }

    public void addRaffleToy(Toy oneToy) {
        listPrizeToys.add(oneToy);
    }

    public void giveOutToy() {
        listPrizeToys.poll();
    }
}