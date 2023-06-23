package presenter;

import model.Service;
import view.CollecterInfo;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addRecord(CollecterInfo collecterInfo) {
        service.addToy(collecterInfo);
    }

    public void getAllRecords() {
        String answer = service.getToysList();
        view.print(answer);
    }

    
    public void getAllChooseRecords() {
        String answer = service.getPrizeToysList();
        view.print(answer);
    }

    public void loadAllRecords() {
        String answer = service.loadToysList();
        view.print(answer);
    }

    public void chooseRecord() {
        String answer = service.raffleToy().toString();
        view.print(answer);
    }

    public void saveRecords() {
        String answer = service.saveToysList();
        view.print(answer);
    }

}
