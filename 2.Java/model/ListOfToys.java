package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ListOfToys список доступных игрушек для розыгрыша.
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

    // Нахождение наиболее вероятной игрушки. При этом считаем
    public Toy raffleStart() {
        Toy raffleToy = new Toy(0, "ноль", 0, 0);
        if (listToys.size() != 0) {
            raffleToy = listToys.get(0);
            int size = 0; // количество игрушек
            int probability = 0; // общая вероятность
            for (int i = 0; i < listToys.size(); i++) {
                // считаем количество игрушек всего, учитываем количество каждой игрушки
                size = size + listToys.get(i).getCount();
                // считаем всю возможную вероятность, берем вероятность каждой игрушки, умножаем
                // на ее количество и считаем сумму
                probability = probability + listToys.get(i).getWeight() * listToys.get(i).getCount();
            }
            // не стала убирать расчет выпадения вероятности каждой игрушки, что бы наглядно
            // было видно, как работает программа
            for (int i = 0; i < listToys.size(); i++) {
                System.out.println("Вероятность выпадения игрушки " + listToys.get(i).getName() + " при количестве "
                        + listToys.get(i).getCount() + ": "
                        + "\n" + (listToys.get(i).getWeight() * listToys.get(i).getCount() * 100d) / probability + "%");
            }
            Random random = new Random();
            int index = random.nextInt(probability); // Выбираем случайный индекс из воображаемого массива
            for (int i = 0; i < size - 1; i++) { // Ищем элемент, которому принадлежит этот индекс
                index -= listToys.get(i).getWeight() * listToys.get(i).getCount();
                if (index < 0) {
                    raffleToy = listToys.get(i);
                    break;
                }
            }
        }
        return raffleToy;
    }

    @Override
    public String toString() {
        String str = "";
        System.out.println("Список доступных игрушек:");
        for (int i = 0; i < listToys.size(); i++) {
            str = str + listToys.get(i).toString() + "\n";
        }
        return str;
    }
}