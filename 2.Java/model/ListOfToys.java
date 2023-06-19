package model;

import java.util.PriorityQueue;

/**
 * ListOfToys
 */
public class ListOfToys {

    private PriorityQueue<Toy> listToys;
    private String filename;

    public void addToy (Toy oneToy){
        listToys.add(oneToy);
    }
    
    
}