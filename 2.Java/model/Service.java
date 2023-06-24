package model;

import view.CollecterInfo;

public class Service {
    private ListOfToys listToys;
    private ListOfPrizeToys listPrizeToys;
    private FileHandler fileHandler;
    private String filename = "listToys.dat"; // файл для хранения списка возможных игрушек
    private String fileGiveOut = "listGiveOutToys.dat"; // файл для записи выданных игрушек

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
        System.out.println("Cписок доступных игрушек:\n");
        if (listToys.getToysList().isEmpty())
            return "пуст. Загрузите список из файла или добавьте игрушки вручную.";
        else
            return listToys.getToysList().toString();
    }

    public String getPrizeToysList() {
        System.out.println("Cписок призовых игрушек:\n");
        if (listPrizeToys.getPrizeToysList().isEmpty())
            return "пуст. Запустите розыгрыш призовой игрушки.";
        else
            return listPrizeToys.getPrizeToysList().toString();
    }

    public String loadToysList() {
        listToys = fileHandler.LoadFromFile(filename);
        return listToys.getToysList().toString();
    }

    public String saveToysList() {
        fileHandler.SaveToFile(listToys, filename);
        return listToys.getToysList().toString();
    }

    // Розыгрыш призовой игрушки. Работа со списком достуаных игрушей. Если
    // количество меньше 1, удаляем ее, если боличнство
    // больше 1, уменьшаем количество. Разыгранную игрушку добавляем в список
    // призовых игрушек.
    public ListOfPrizeToys raffleToy() {
            Toy raffleToy = listToys.raffleStart();
            listPrizeToys.addRaffleToy(raffleToy);
            if (listToys.getToysList().size() > 1 | listToys.getToysList().get(0).getCount() > 1) {
                if (raffleToy.getCount() > 1) {
                    raffleToy.setCount(raffleToy.getCount() - 1);
                } else {
                    listToys.deleteToy(raffleToy);
                }
            } else {
                System.out.println("Это была последняя игрушка.");
                listToys.deleteToy(listToys.getToysList().get(0));
            }
        return listPrizeToys;
    }

    // Удаление призовой игрушки, уладенная игрушка Дозаписывается в файл
    // "listGiveOutToys.dat"
    public void deletePrizeToy() {
        Toy giveOutToy = listPrizeToys.poll();
        if (giveOutToy == null)
            System.out.println("Список призовых игрушек пуст. Запустите розыгрыш призовых игрушек.");
        else {
            System.out.println("Выдана игрушка: " + giveOutToy);
            fileHandler.SaveToFileGiveOutToys(giveOutToy, fileGiveOut);
        }
    }
}
