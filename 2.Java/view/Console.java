package view;

import java.util.Scanner;
import presenter.Presenter;

/**
 * Console
 */
public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
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
                    loadAllToys()
                    break;
                case 2:
                    getAllToys();
                    break;
                case 3:
                    addToy();
                    break;
                case 4:
                    deleteToyById();
                    break;
                case 5:
                    saveToysInFile();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Введите число!");
            }
        }
        
    }

    private void addToy() {
        CollecterInfo collecterInfo = new CollecterInfo();
        collecterInfo = collecterInfo.getInfoFromUser();
        presenter.addToy(collecterInfo);
        System.out.printf("Игрушка добавлена.");

    }
}