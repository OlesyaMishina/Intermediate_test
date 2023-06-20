package model;

import view.CollecterInfo;

public class RestoreToyFromConsole {

        public Toy restoreToyFromConsole(ListOfToys listToys, CollecterInfo collecterInfo) {
    
        Toy toy = new Toy(0, collecterInfo.getName(), collecterInfo.getCount(), collecterInfo.getWeight());
        if (listToys.getToysList() == null)
            toy.setId(1);
        else {
            int maxId = 1;
            for (int i = 0; i < listToys.getToysList().size(); i++) {
                if (listToys.getToysList().get(i).getId() > maxId)
                    maxId = listToys.getToysList().get(i).getId();
            }
            toy.setId(maxId + 1);
        }
        return toy;
    }
}

