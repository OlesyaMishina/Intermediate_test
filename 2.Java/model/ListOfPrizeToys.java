package model;

import java.util.PriorityQueue;

/**
 * ListOfPrizeToy
 */
public class ListOfPrizeToys {

    private PriorityQueue<Toy> listPrizeToys;

    public ListOfPrizeToys() {
        listPrizeToys = new PriorityQueue<>(100, new ComparatorById());
    }

    public void addRaffleToy(Toy oneToy) {
        Toy newToy = new Toy(0, null, 0, 0);
        newToy.setName(oneToy.getName());
        newToy.setCount(1);
        newToy.setWeight(oneToy.getWeight());
        if (listPrizeToys.size() == 0) {
            newToy.setId(1);
            listPrizeToys.add(newToy);
           } else {
            newToy.setId(listPrizeToys.peek().getId() + listPrizeToys.size());
            listPrizeToys.add(newToy);
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

}