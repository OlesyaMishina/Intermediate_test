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

    
    public void addToy(CollecterInfo collecterInfo) {
        service.addToy(collecterInfo);
    }

    public void getAllToys() {
        String answer = service.getToysList();
        view.print(answer);
    }

    public void loadAllToys() {
        String answer = service.loadToysList();
        view.print(answer);
    }
}
