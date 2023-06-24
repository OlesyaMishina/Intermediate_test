package view;

import java.util.Scanner;
import presenter.Presenter;

/**
 * Console
 */
public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    public String filename = "listToys.dat";
    private boolean work = true;

    public Console() {
        scanner = new Scanner(System.in, "cp866");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (work) {
            ToChooseStart start = new ToChooseStart();
            int choice = start.toChoose();
            switch (choice) {
                case 1:
                    loadAllToys();
                    break;
                case 2:
                    getAllToys();
                    break;
                case 3:
                    addToy();
                    break;
                case 4:
                    raffleToy();
                    break;
                case 5:
                    getAllPrizeToys();
                    break;
                case 6:
                    giveOutToy();
                    break;
                case 7:
                    saveToysInFile();
                    break;
                case 8:
                    exit();
                    // break;
                default:
                    System.out.println("Введите число!");
            }
        }
    }

    // 1 - Загрузить список доступных игрушек из файла\n"
    private void loadAllToys() {
        System.out.printf("\nFile " + filename + " has been loaded:\n");
        System.out.print("id Toy, name Toy; count Toy; weight Toy\n");
        presenter.loadAllRecords();
    }

    // 2 - Распечатать список доступных игрушек\n
    private void getAllToys() {
        presenter.getAllRecords();
    }

    // 3 - Добавить игрушку в список доступных игрушек\n"
    private void addToy() {
        CollecterInfo collecterInfo = new CollecterInfo();
        collecterInfo = collecterInfo.getInfoFromUser();
        presenter.addRecord(collecterInfo);
        System.out.printf("Игрушка " + collecterInfo.getName() + " добавлена.");
    }

    // 4 - Запустить розыгрыш призовой игрушки\n"
    private void raffleToy() {
        presenter.chooseRecord();
    }

    // 5 - Распечатать список призовых игрушек\n
    private void getAllPrizeToys() {
        presenter.getAllChooseRecords();
    }

    // 6 - Выдать призовую игрушку из очереди\n
    private void giveOutToy() {
        presenter.deleteRecord();
    }

    // 7 - Сохрянить список доступных игрушек в файл\n
    private void saveToysInFile() {
        System.out.printf("File " + filename + " has been written.\n");
        presenter.saveRecords();
    }

    // 8
    private void exit() {
        System.out.println("Работа программы завершена.");
        scanner.close();
        work = false;
    }
}
