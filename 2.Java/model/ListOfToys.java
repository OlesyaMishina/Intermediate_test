package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ListOfToys
 */
public class ListOfToys implements Serializable {

    private List<Toy> listToys;

    public ListOfToys() {
        listToys = new ArrayList<>();
    }

    public void addToy(Toy oneToy) {
        listToys.add(oneToy);
    }

    public void deleteToy(Toy oneToy) {
        listToys.remove(oneToy);
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

    public Toy raffleStart() {
        // if (listToys != null) {
            Toy raffleToy = null;
            int size = 0;
            int probability = 0;
            for (int i = 0; i < listToys.size(); i++) {
                size = size + listToys.get(i).getCount();
                probability = probability + listToys.get(i).getWeight() * listToys.get(i).getCount();
            }
            for (int i = 0; i < listToys.size(); i++) {
                System.out.println("Вероятность числа \"" + listToys.get(i) + "\":  \t"
                        + (listToys.get(i).getWeight() * listToys.get(i).getCount() * 100d / probability) + "%");
            }
            Random random = new Random();
            int index = random.nextInt(probability); // Выбираем случайный индекс из воображаемого массива
            for (int i = 0; i < size - 1; i++) { // Ищем элемент, которому принадлежит этот индекс
                index -= listToys.get(i).getWeight() * listToys.get(i).getCount();
                if (index < 0) {
                    System.out.println("Выпала призовая игрушка: " + listToys.get(i).toString());
                    raffleToy = listToys.get(i);
                    break;
                }
            }
            return raffleToy;
        }
    //     else return "Список игрушек пуст.";
    // }
}