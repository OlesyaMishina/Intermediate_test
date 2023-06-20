package model;

import java.util.ArrayList;
import java.util.List;

/**
 * ListOfToys
 */
public class ListOfToys {

    private List<Toy> listToys;
    private String filename;

    public ListOfToys() {
        listToys = new ArrayList<>();
    }

    public void addToy(Toy oneToy) {
        listToys.add(oneToy);
    }

    public Toy getToyByName(String name) {
        Toy findToy = null;
        for (int i = 0; i < listToys.size(); i++) {
            if (listToys.get(i).getName().equals(name)) {
                findToy = listToys.get(i);
            }
        }
        return findToy;
    }

    public List<Toy> getToysList() {
        return listToys;
    }
}