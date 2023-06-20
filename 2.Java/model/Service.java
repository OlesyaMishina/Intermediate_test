package model;

import view.CollecterInfo;

public class Service {
    private ListOfToys listToys;
    private FileHandler fileHandler;
    private String filename = "listToys.dat";

    public Service(ListOfToys listToys) {
        this.listToys = listToys;
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

    public String loadToysList() {
        listToys = fileHandler.LoadFromFile(filename);
        return listToys.getToysList().toString();
    }

    public String saveToysList() {
        fileHandler.SaveToFile(listToys, filename);
        return listToys.getToysList().toString();
    }

    public String raffleToy() {
        String raffleName = listToys.raffleStart();
        System.out.println(listToys.getToyByName(raffleName));
        System.out.println(listToys.getToyByName(raffleName).getCount());
        if (listToys.getToyByName(raffleName).getCount() > 0) {
            listToys.getToyByName(raffleName).setCount(listToys.getToyByName(raffleName).getCount() - 1);
        } else {
            listToys.deleteToy(listToys.getToyByName(raffleName));
        }
        return listToys.getToyByName(raffleName).toString();
    }
}
