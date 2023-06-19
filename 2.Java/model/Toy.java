package model;

/**
 * Toy
 */
public class Toy {

    private int id;
    private String name;
    private int count;
    private float price;
    private int weight;  //частота выпадения игрушки (вес в % от 100)
    
    public Toy(int id, String name, int count, float price, int weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + count + ", " + weight;
    }
}