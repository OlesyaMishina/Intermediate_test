package model;

import java.io.Serializable;

/**
 * Toy
 */
public class Toy implements Serializable {

    private int id;
    private String name;
    private int count;
    private int weight;  //частота выпадения игрушки (вес в % от 100)
    public Object setName;
    
    public Toy(int id, String name, int count, int weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + count + ", " + weight + ";\n";
    }

}