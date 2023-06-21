package model;

import view.CollecterInfo;

public class Service {
    private ListOfToys listToys;
    private ListOfPrizeToy listPrizeToys;
    private FileHandler fileHandler;
    private String filename = "listToys.dat"; // файл для хранения списка возможных игрушек
    private String filenameIssued = "listIssuedToys.dat"; // файл для записи выданных игрушек

    public Service(ListOfToys listToys, ListOfPrizeToy listPrizeToys) {
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

    public String loadToysList() {
        listToys = fileHandler.LoadFromFile(filename);
        return listToys.getToysList().toString();
    }

    public String saveToysList() {
        fileHandler.SaveToFile(listToys, filename);
        return listToys.getToysList().toString();
    }

    public String raffleToy() {
        if (listToys.getToysList().size() > 1 | listToys.getToysList().get(0).getCount()>1) {
            String raffleName = listToys.raffleStart();
            System.out.println(listToys.getToysList().size());

            System.out.println(listToys.getToyByName(raffleName));
            System.out.println(listToys.getToyByName(raffleName).getCount());
            if (listToys.getToyByName(raffleName).getCount() > 1) {
                listToys.getToyByName(raffleName).setCount(listToys.getToyByName(raffleName).getCount() - 1);
            } else {
                listToys.deleteToy(listToys.getToyByName(raffleName));
                // listPrizeToys.addRaffleToy(listToys.getToyByName(raffleName));
            }
            return raffleName;
        } else {
            System.out.println(listToys.getToysList().toString());
            listToys.deleteToy(listToys.getToysList().get(0));
            return "Это была последняя игрушка.";
        }
    }
}
