package model;

import java.util.Comparator;
import java.util.PriorityQueue;

import view.CollecterInfo;

public class Service {
    private ListOfToys listToys;
    private ListOfPrizeToys listPrizeToys;
    private FileHandler fileHandler;
    private String filename = "listToys.dat"; // файл для хранения списка возможных игрушек
    private String filenameIssued = "listIssuedToys.dat"; // файл для записи выданных игрушек
    // public PriorityQueue<Toy> listPrizeToys = new PriorityQueue<Toy>(5, new
    // ComparatorById());

    public Service(ListOfToys listToys, ListOfPrizeToys listPrizeToys) {
        this.listToys = listToys;
        this.listPrizeToys = listPrizeToys;
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
        System.out.println("Cписок призовых игрушек:\n");
        // while (!listPrizeToys.isEmpty()) {
        //     System.out.println(listPrizeToys.peek().toString() + "\n");
        // }
        return listPrizeToys.getPrizeToysList().toString();
    }

    public String loadToysList() {
        listToys = fileHandler.LoadFromFile(filename);
        return listToys.getToysList().toString();
    }

    // public String loadPrizeToysList() {
    // listPrizeToys = fileHandler.LoadFromFilePQ(filenameRaffle);
    // return listPrizeToys.toString();
    // }

    // public String savePrizeToysList() {
    // fileHandler.SaveToFilePQ(listPrizeToys, filenameRaffle);
    // return listPrizeToys.toString();
    // }

    public String saveToysList() {
        fileHandler.SaveToFile(listToys, filename);
        return listToys.getToysList().toString();
    }

    public ListOfPrizeToys raffleToy() {
        Toy raffleToy = listToys.raffleStart();
        // System.out.println(raffleToy.toString());
        // listPrizeToys.addRaffleToy(raffleToy);
        if (listToys.getToysList().size() > 1 | listToys.getToysList().get(0).getCount() > 1) {
            if (listToys.getToyByName(raffleToy.getName()).getCount() > 1) {
                listPrizeToys.addRaffleToy(listToys.getToyByName(raffleToy.getName()));
                listToys.getToyByName(raffleToy.getName())
                        .setCount(listToys.getToyByName(raffleToy.getName()).getCount() - 1);
                System.out.println(listPrizeToys.getPrizeToysList());
            } else {
                listPrizeToys.addRaffleToy(listToys.getToyByName(raffleToy.getName()));
                listToys.deleteToy(listToys.getToyByName(raffleToy.getName()));
                System.out.println(listPrizeToys.getPrizeToysList());
            }
        } else {
            // raffleToy=listToys.getToysList().get(0);
            listPrizeToys.addRaffleToy(listToys.getToyByName(raffleToy.getName()));
            System.out.println("Это была последняя игрушка.");
            listToys.deleteToy(listToys.getToysList().get(0));
            // return raffleToy;
            System.out.println(listPrizeToys.getPrizeToysList());
        }
        return listPrizeToys;
    }
}
