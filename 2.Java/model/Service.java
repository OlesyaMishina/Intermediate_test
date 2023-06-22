package model;

import java.util.Comparator;
import java.util.PriorityQueue;

import view.CollecterInfo;

public class Service {
    private ListOfToys listToys;
    // private ListOfPrizeToy listPrizeToys;
    private FileHandler fileHandler;
    private String filename = "listToys.dat"; // файл для хранения списка возможных игрушек
    private String filenameIssued = "listIssuedToys.dat"; // файл для записи выданных игрушек
    private PriorityQueue<Toy> listPrizeToys = new PriorityQueue<Toy>(5, new ComparatorById());

    public Service(ListOfToys listToys) {
        this.listToys = listToys;
        // this.listPrizeToys = listPrizeToys;
        fileHandler = new FileHandler();
    }

    public void addToy(CollecterInfo collecterInfo) {
        if (listToys.getToyByName(collecterInfo.getName()) == null) {
            RestoreToyFromConsole rToy = new RestoreToyFromConsole();
            Toy toy = rToy.restoreToyFromConsole(listToys, collecterInfo);
            listToys.addToy(toy);
        } else {
            listToys.getToyByName(collecterInfo.getName())
                    .setCount(listToys.getToyByName(collecterInfo.getName()).getCount() + collecterInfo.getCount());
        }
    }

    public String getToysList() {
        return listToys.getToysList().toString();
    }

    public String getPrizeToysList() {
        String listPrize = "Cписок призовых игрушек:\n";
        while (!listPrizeToys.isEmpty()) {
            listPrize = listPrize + listPrizeToys.poll().toString() + "\n";
        }
        return listPrize;
    }

    public String loadToysList() {
        listToys = fileHandler.LoadFromFile(filename);
        return listToys.getToysList().toString();
    }

    public String saveToysList() {
        fileHandler.SaveToFile(listToys, filename);
        return listToys.getToysList().toString();
    }

    public PriorityQueue<Toy> addRaffleToy(Toy oneToy) {
        if (listPrizeToys.isEmpty()) {
            oneToy.setId(1);
            listPrizeToys.add(oneToy);
        } else {
            oneToy.setId(listPrizeToys.peek().getId() + 1);
            listPrizeToys.add(oneToy);
        }
        return listPrizeToys;
    }

    public Toy raffleToy() {
        Toy raffleToy = listToys.raffleStart();

        if (listToys.getToysList().size() > 1 | listToys.getToysList().get(0).getCount() > 1) {
            if (listToys.getToyByName(raffleToy.getName()).getCount() > 1) {
                // addRaffleToy(listToys.getToyByName(raffleName));
                listToys.getToyByName(raffleToy.getName())
                        .setCount(listToys.getToyByName(raffleToy.getName()).getCount() - 1);
                // System.out.println(listPrizeToys.peek().toString());
            } else {
                // addRaffleToy(listToys.getToyByName(raffleName));
                listToys.deleteToy(listToys.getToyByName(raffleToy.getName()));
                // System.out.println(listPrizeToys.peek().toString());
            }

        } else {
            raffleToy=listToys.getToysList().get(0);
            System.out.println(raffleToy.toString() + "Это была последняя игрушка.");
            listToys.deleteToy(listToys.getToysList().get(0));
            return raffleToy;
        }
        return raffleToy;
    }
}
