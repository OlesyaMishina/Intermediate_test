package view;

import java.util.Scanner;

public class CollecterInfo {
    private Scanner scanner;
    private int id;
    private String name;
    private int count;
    private int weight;

    public CollecterInfo() {
        scanner = new Scanner(System.in, "cp866");
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

    public CollecterInfo getInfoFromUser() {
        CollecterInfo collecterInfo = new CollecterInfo();
        System.out.println("Введите название игрушки:");
        collecterInfo.setName(scanner.nextLine());
        System.out.println("Введите количество:");
        collecterInfo.setCount(Integer.parseInt(scanner.nextLine()));
        System.out.println("Введите частоту выпадения игрушки в % от 100:");
        collecterInfo.setWeight(Integer.parseInt(scanner.nextLine()));
        return collecterInfo;
    }
}
