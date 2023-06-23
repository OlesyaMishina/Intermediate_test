
import model.ListOfPrizeToys;
import model.ListOfToys;
import model.Service;
import presenter.Presenter;
import view.Console;
import view.View;

public class main {
    public String filename = "listToys.dat";

    public static void main(String[] args) {

        ListOfPrizeToys listPrizeToys = new ListOfPrizeToys();
        ListOfToys listToys = new ListOfToys();
        View view = new Console();
        Service service = new Service(listToys, listPrizeToys);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
