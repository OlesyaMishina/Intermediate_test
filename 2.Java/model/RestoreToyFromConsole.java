package model;

import view.CollecterInfo;

public class RestoreToyFromConsole {

        public Toy restoreToyFromConsole(ListOfToys listToys, CollecterInfo collecterInfo) {
    
        Toy toy = new Toy(0, collecterInfo.getName(), collecterInfo.getCount(), collecterInfo.getWeight());
        if (listToys.getToyList() == null)
            toy.setId(1);
        else {
            int maxId = 1;
            for (int i = 0; i < listToys.getToyList().size(); i++) {
                if (listToys.getToyList().get(i).getId() > maxId)
                    maxId = listToys.getToyList().get(i).getId();
            }
            toy.setId(maxId + 1);
        }
        return toy;
    }
}

