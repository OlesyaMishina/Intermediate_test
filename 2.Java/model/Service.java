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
        // boolean find=false;
        if (listToys.getToyByName(collecterInfo.getName()) == null) {
            RestoreToyFromConsole rToy = new RestoreToyFromConsole();
            Toy toy = rToy.restoreToyFromConsole(listToys, collecterInfo);
            // find=true;
            listToys.addToy(toy);
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
}
